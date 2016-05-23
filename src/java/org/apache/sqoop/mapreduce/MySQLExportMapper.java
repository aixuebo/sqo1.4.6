/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.sqoop.mapreduce;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapred.JobConf;
import org.apache.sqoop.util.AsyncSink;
import org.apache.sqoop.util.JdbcUrl;
import org.apache.sqoop.util.LoggingAsyncSink;
import org.apache.sqoop.util.NullAsyncSink;
import org.apache.sqoop.util.TaskId;
import com.cloudera.sqoop.io.NamedFifo;
import com.cloudera.sqoop.mapreduce.db.DBConfiguration;
import com.cloudera.sqoop.manager.MySQLUtils;

/**
 * Mapper that starts a 'mysqlimport' process and uses that to export rows from
 * HDFS to a MySQL database at high speed.
 *
 * map() methods are actually provided by subclasses that read from
 * SequenceFiles (containing existing SqoopRecords) or text files
 * (containing delimited lines) and deliver these results to the fifo
 * used to interface with mysqlimport.
 *
 * map方法是由子类实现的,子类数据源可能是文本文件 也可能是序列化的文件
 */
public class MySQLExportMapper<KEYIN, VALIN>
    extends SqoopMapper<KEYIN, VALIN, NullWritable, NullWritable> {

  public static final Log LOG = LogFactory.getLog(
      MySQLExportMapper.class.getName());

  /** Configuration key that specifies the number of bytes before which it
   * commits the current export transaction and opens a new one.
   * Default is 32 MB; setting this to 0 will use no checkpoints.
   * 每一个export的事物,多少字节就会被提交一次,然后重新打开一个事物去处理
   * 默认是32M,如果设置为0,则就会一直处理完后才会进行export事物提交
   */
  public static final String MYSQL_CHECKPOINT_BYTES_KEY =
      "sqoop.mysql.export.checkpoint.bytes";

  public static final long DEFAULT_CHECKPOINT_BYTES = 32 * 1024 * 1024;

  // Configured value for MSYQL_CHECKPOINT_BYTES_KEY.
  protected long checkpointDistInBytes;

  /** Configuration key that specifies the number of milliseconds
   * to sleep at the end of each checkpoint commit
   * Default is 0, no sleep.
   * 每一次export事物提交后,休息多久
   */
  public static final String MYSQL_CHECKPOINT_SLEEP_KEY =
      "sqoop.mysql.export.sleep.ms";

  public static final long DEFAULT_CHECKPOINT_SLEEP_MS = 0;

  // Configured value for MYSQL_CHECKPOINT_SLEEP_KEY.
  protected long checkpointSleepMs;

  protected Configuration conf;

  /** The FIFO being used to communicate with mysqlimport. */
  protected File fifoFile;

  /** The process object representing the active connection to mysqlimport. */
  protected Process mysqlImportProcess;

  /** The stream to write to stdin for mysqlimport. mysqlimport命令的输入流*/
  protected OutputStream importStream;

  // Handlers for stdout and stderr from mysqlimport.
  protected AsyncSink outSink;
  protected AsyncSink errSink;

  /** File object where we wrote the user's password to pass to mysqlimport. */
  protected File passwordFile;

  /** Character set used to write to mysqlimport. */
  protected String mysqlCharSet;

  /**
   * Tally of bytes written to current mysqlimport instance.
   * We commit an interim tx and open a new mysqlimport after this
   * gets too big. */
  private long bytesWritten;

  /**
   * Create a named FIFO, and start mysqlimport connected to that FIFO.
   * A File object representing the FIFO is in 'fifoFile'.
   */
  private void initMySQLImportProcess() throws IOException {
    File taskAttemptDir = TaskId.getLocalWorkPath(conf);//任务的工作目录

    this.fifoFile = new File(taskAttemptDir,
        conf.get(MySQLUtils.TABLE_NAME_KEY, "UNKNOWN_TABLE") + ".txt");
    String filename = fifoFile.toString();

    // Create the FIFO itself.
    try {
      new NamedFifo(this.fifoFile).create();
    } catch (IOException ioe) {
      // Command failed.
      LOG.error("Could not mknod " + filename);
      this.fifoFile = null;
      throw new IOException(
          "Could not create FIFO to interface with mysqlimport", ioe);
    }

    // Now open the connection to mysqlimport.
    ArrayList<String> args = new ArrayList<String>();

    String connectString = conf.get(MySQLUtils.CONNECT_STRING_KEY);//获取连接串
    //从连接串中获取数据库 host 和port
    String databaseName = JdbcUrl.getDatabaseName(connectString);
    String hostname = JdbcUrl.getHostName(connectString);
    int port = JdbcUrl.getPort(connectString);

    if (null == databaseName) {
      throw new IOException("Could not determine database name");
    }

    args.add(MySQLUtils.MYSQL_IMPORT_CMD); // needs to be on the path. mysql的import命令mysqlimport
    String password = DBConfiguration.getPassword((JobConf) conf); //将密码写成文件

    if (null != password && password.length() > 0) {
      passwordFile = new File(MySQLUtils.writePasswordFile(conf));
      args.add("--defaults-file=" + passwordFile);
    }

    String username = conf.get(MySQLUtils.USERNAME_KEY);//添加用户名参数
    if (null != username) {
      args.add("--user=" + username);
    }

    args.add("--host=" + hostname);
    if (-1 != port) {
      args.add("--port=" + Integer.toString(port));
    }


    args.add("--compress");
    args.add("--local");
    args.add("--silent");

    // Specify the subset of columns we're importing.
    DBConfiguration dbConf = new DBConfiguration(conf);
    String [] cols = dbConf.getInputFieldNames();
    if (null != cols) {
      StringBuilder sb = new StringBuilder();
      boolean first = true;
      for (String col : cols) {
        if (!first) {
          sb.append(",");
        }
        sb.append(col);
        first = false;
      }

      args.add("--columns=" + sb.toString());//追加要导入的属性col1,col2,col3
    }

    // Specify the delimiters to use.
    int outputFieldDelim = conf.getInt(MySQLUtils.OUTPUT_FIELD_DELIM_KEY,
        (int) ',');//属性分隔符
    int outputRecordDelim = conf.getInt(MySQLUtils.OUTPUT_RECORD_DELIM_KEY,
        (int) '\n');//换行分隔符
    int enclosedBy = conf.getInt(MySQLUtils.OUTPUT_ENCLOSED_BY_KEY, 0);
    int escapedBy = conf.getInt(MySQLUtils.OUTPUT_ESCAPED_BY_KEY, 0);
    boolean encloseRequired = conf.getBoolean(
        MySQLUtils.OUTPUT_ENCLOSE_REQUIRED_KEY, false);

    args.add("--fields-terminated-by=0x"
        + Integer.toString(outputFieldDelim, 16));
    args.add("--lines-terminated-by=0x"
        + Integer.toString(outputRecordDelim, 16));
    if (0 != enclosedBy) {
      if (encloseRequired) {
        args.add("--fields-enclosed-by=0x" + Integer.toString(enclosedBy, 16));
      } else {
        args.add("--fields-optionally-enclosed-by=0x"
            + Integer.toString(enclosedBy, 16));
      }
    }

    if (0 != escapedBy) {
      args.add("--escaped-by=0x" + Integer.toString(escapedBy, 16));
    }

    // These two arguments are positional and must be last.
    //向哪个库和哪个表导入数据
    args.add(databaseName);
    args.add(filename);

    // Begin the export in an external process.
    LOG.debug("Starting mysqlimport with arguments:");
    for (String arg : args) {
      LOG.debug("  " + arg);
    }

    // Actually start mysqlimport.开始执行语法
    mysqlImportProcess = Runtime.getRuntime().exec(args.toArray(new String[0]));

    // Log everything it writes to stderr.将标准异常输出到log中
    // Ignore anything on stdout.
    //忽略任何标准输出
    this.outSink = new NullAsyncSink();
    this.outSink.processStream(mysqlImportProcess.getInputStream());

    this.errSink = new LoggingAsyncSink(LOG);
    this.errSink.processStream(mysqlImportProcess.getErrorStream());

    // Open the named FIFO after starting mysqlimport.
    this.importStream = new BufferedOutputStream(
        new FileOutputStream(fifoFile));

    // At this point, mysqlimport is running and hooked up to our FIFO.
    // The mapper just needs to populate it with data.

    this.bytesWritten = 0;
  }

  //一行记录进入map方法处理,重新定义了run方法,但是map方法没有被重新定义
  @Override
  public void run(Context context) throws IOException, InterruptedException {
    this.conf = context.getConfiguration();
    setup(context);
    initMySQLImportProcess();
    try {
      while (context.nextKeyValue()) {
        map(context.getCurrentKey(), context.getCurrentValue(), context);
      }
      cleanup(context);
    } finally {
      // Shut down the mysqlimport process.
      closeExportHandles();
    }
  }

  private void closeExportHandles() throws IOException, InterruptedException {
    int ret = 0;
    if (null != this.importStream) {
      // Close the stream that writes to mysqlimport's stdin first.
      LOG.debug("Closing import stream");
      this.importStream.close();
      this.importStream = null;
    }

    if (null != this.mysqlImportProcess) {
      // We started mysqlimport; wait for it to finish.
      LOG.info("Waiting for mysqlimport to complete");
      ret = this.mysqlImportProcess.waitFor();
      LOG.info("mysqlimport closed connection");
      this.mysqlImportProcess = null;
    }

    if (null != this.passwordFile && this.passwordFile.exists()) {
      if (!this.passwordFile.delete()) {
        LOG.error("Could not remove mysql password file " + passwordFile);
        LOG.error("You should remove this file to protect your credentials.");
      }

      this.passwordFile = null;
    }

    // Finish processing any output from mysqlimport.
    // This is informational only, so we don't care about return codes.
    if (null != outSink) {
      LOG.debug("Waiting for any additional stdout from mysqlimport");
      outSink.join();
      outSink = null;
    }

    if (null != errSink) {
      LOG.debug("Waiting for any additional stderr from mysqlimport");
      errSink.join();
      errSink = null;
    }

    if (this.fifoFile != null && this.fifoFile.exists()) {
      // Clean up the resources we created.
      LOG.debug("Removing fifo file");
      if (!this.fifoFile.delete()) {
        LOG.error("Could not clean up named FIFO after completing mapper");
      }

      // We put the FIFO file in a one-off subdir. Remove that.
      File fifoParentDir = this.fifoFile.getParentFile();
      LOG.debug("Removing task attempt tmpdir");
      if (!fifoParentDir.delete()) {
        LOG.error("Could not clean up task dir after completing mapper");
      }

      this.fifoFile = null;
    }

    if (0 != ret) {
      // Don't mark the task as successful if mysqlimport returns an error.
      throw new IOException("mysqlimport terminated with error code " + ret);
    }
  }

  @Override
  protected void setup(Context context) {
    this.conf = context.getConfiguration();

    // TODO: Support additional encodings.
    this.mysqlCharSet = MySQLUtils.MYSQL_DEFAULT_CHARSET;//mysql的编码

    this.checkpointDistInBytes = conf.getLong(
        MYSQL_CHECKPOINT_BYTES_KEY, DEFAULT_CHECKPOINT_BYTES);
    if (this.checkpointDistInBytes < 0) {
      LOG.warn("Invalid value for " + MYSQL_CHECKPOINT_BYTES_KEY);
      this.checkpointDistInBytes = DEFAULT_CHECKPOINT_BYTES;
    }

    this.checkpointSleepMs = conf.getLong(
        MYSQL_CHECKPOINT_SLEEP_KEY, DEFAULT_CHECKPOINT_SLEEP_MS);

    if (this.checkpointSleepMs < 0) {
      LOG.warn("Invalid value for " + MYSQL_CHECKPOINT_SLEEP_KEY);
      this.checkpointSleepMs = DEFAULT_CHECKPOINT_SLEEP_MS;
    }

    if (this.checkpointSleepMs >= conf.getLong("mapred.task.timeout", 0)) {
      LOG.warn("Value for "
          + MYSQL_CHECKPOINT_SLEEP_KEY
          + " has to be smaller than mapred.task.timeout");
      this.checkpointSleepMs = DEFAULT_CHECKPOINT_SLEEP_MS;
    }
  }

  /**
   * Takes a delimited text record (e.g., the output of a 'Text' object),
   * re-encodes it for consumption by mysqlimport, and writes it to the pipe.
   * @param record A delimited text representation of one record.
   * @param terminator an optional string that contains delimiters that
   *   terminate the record (if not included in 'record' itself).
   *  子类要调用该方法
   */
  protected void writeRecord(String record, String terminator)
      throws IOException, InterruptedException {

    // We've already set up mysqlimport to accept the same delimiters,
    // so we don't need to convert those. But our input text is UTF8
    // encoded; mysql allows configurable encoding, but defaults to
    // latin-1 (ISO8859_1). We'll convert to latin-1 for now.
    // TODO: Support user-configurable encodings.
    /**
     * 但是我们的输入源可能是utf-8编码,mysql允许配置编码为utf-8,但是默认是ISO-8859-1,我们需要将utf-8转换成mysql要的编码方式
     */

    byte [] mysqlBytes = record.getBytes(this.mysqlCharSet);//将记录按照mysql编码集进行编码成字节数组
    this.importStream.write(mysqlBytes, 0, mysqlBytes.length);//将编码后的记录写入到输入流中
    this.bytesWritten += mysqlBytes.length;//被写入的总字节数累加

    if (null != terminator) {//写入换行符
      byte [] termBytes = terminator.getBytes(this.mysqlCharSet);
      this.importStream.write(termBytes, 0, termBytes.length);
      this.bytesWritten += termBytes.length;
    }

    // If bytesWritten is too big, then we should start a new tx by closing
    // mysqlimport and opening a new instance of the process.
    if (this.checkpointDistInBytes != 0
        && this.bytesWritten > this.checkpointDistInBytes) {//写入的字节长度超过了数据块长度,就做一次检查导入
      LOG.info("Checkpointing current export.");

      if (this.checkpointSleepMs != 0) {//每次检查导入要休息一阵子
        LOG.info("Pausing.");
        Thread.sleep(this.checkpointSleepMs);
      }

      closeExportHandles();//关闭导入流
      initMySQLImportProcess();//重新建立import命令
      this.bytesWritten = 0;
    }
  }
}

