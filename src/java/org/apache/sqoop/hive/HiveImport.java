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

package org.apache.sqoop.hive;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapred.FileOutputCommitter;
import org.apache.hadoop.util.ReflectionUtils;
import org.apache.hadoop.util.Shell;
import org.apache.hadoop.util.ToolRunner;
import org.apache.hadoop.util.Tool;
import org.apache.sqoop.io.CodecMap;
import org.apache.sqoop.util.Executor;
import org.apache.sqoop.util.LoggingAsyncSink;
import org.apache.sqoop.util.SubprocessSecurityManager;

import com.cloudera.sqoop.SqoopOptions;
import com.cloudera.sqoop.manager.ConnManager;
import com.cloudera.sqoop.util.ExitSecurityException;

/**
 * Utility to import a table into the Hive metastore. Manages the connection
 * to Hive itself as well as orchestrating the use of the other classes in this
 * package.
 */
public class HiveImport {

  public static final Log LOG = LogFactory.getLog(HiveImport.class.getName());

  private SqoopOptions options;
  private ConnManager connManager;//数据库连接器,目的是获取table数据源的描述信息
  private Configuration configuration;
  private boolean generateOnly;//true 表示设置了 --generate-only,则表示仅仅生成hive的DDL,并不会真正的运行他,因此不会有任何数据的流动
  private static boolean testMode = false;//是否是测试模式

  public static boolean getTestMode() {
    return testMode;
  }

  public static void setTestMode(boolean mode) {
    testMode = mode;
  }

  /** Entry point through which Hive invocation should be attempted.
   *  确保有hive的jar包
   **/
  private static final String HIVE_MAIN_CLASS =
      "org.apache.hadoop.hive.cli.CliDriver";

  public HiveImport(final SqoopOptions opts, final ConnManager connMgr,
      final Configuration conf, final boolean generateOnly) {
    this.options = opts;
    this.connManager = connMgr;
    this.configuration = conf;
    this.generateOnly = generateOnly;
  }


  /**
   * @return the filename of the hive executable to run to do the import
   * 获取hive的bin路径
   */
  private String getHiveBinPath() {
    // If the user has $HIVE_HOME set, then use $HIVE_HOME/bin/hive if it
    // exists.
    // Fall back to just plain 'hive' and hope it's in the path.

    String hiveHome = options.getHiveHome();
    String hiveCommand = Shell.WINDOWS ? "hive.cmd" : "hive";
    if (null == hiveHome) {
      return hiveCommand;
    }

    Path p = new Path(hiveHome);
    p = new Path(p, "bin");
    p = new Path(p, hiveCommand);
    String hiveBinStr = p.toString();
    if (new File(hiveBinStr).exists()) {
      return hiveBinStr;
    } else {//不存在全路径,就执行hive命令,如果此时有环境变量的话,也是可以使用的
      return hiveCommand;
    }
  }

  /**
   * If we used a MapReduce-based upload of the data, remove the _logs dir
   * from where we put it, before running Hive LOAD DATA INPATH.
   * 为table创建临时目录,并且清空该目录内容 ,并且移除该临时目录
   */
  private void removeTempLogs(Path tablePath) throws IOException {
    FileSystem fs = FileSystem.get(configuration);
    Path logsPath = new Path(tablePath, "_logs");
    if (fs.exists(logsPath)) {
      LOG.info("Removing temporary files from import process: " + logsPath);
      if (!fs.delete(logsPath, true)) {
        LOG.warn("Could not delete temporary files; "
            + "continuing with import, but it may fail.");
      }
    }
  }

  /**
   * @return true if we're just generating the DDL for the import, but
   * not actually running it (i.e., --generate-only mode). If so, don't
   * do any side-effecting actions in Hive.
   * 如果设置了 --generate-only,则表示仅仅生成hive的DDL,并不会真正的运行他,因此不会有任何数据的流动
   */
  private boolean isGenerateOnly() {
    return generateOnly;
  }

  /**
   * @return a File object that can be used to write the DDL statement.
   * If we're in gen-only mode, this should be a file in the outdir, named
   * after the Hive table we're creating. If we're in import mode, this should
   * be a one-off temporary file.
   * 创建脚本文件
   */
  private File getScriptFile(String outputTableName) throws IOException {
    if (!isGenerateOnly()) {
      return File.createTempFile("hive-script-", ".txt",
          new File(options.getTempDir()));//在临时目录下创建hive-script-**.txt的脚本文件
    } else {
      return new File(new File(options.getCodeOutputDir()),
          outputTableName + ".q");//创建一个.q的文件
    }
  }

  /**
   * Perform the import of data from an HDFS path to a Hive table.
   *
   * @param inputTableName the name of the table as loaded into HDFS 被加载到HDFS时候的输入源的table名字
   * @param outputTableName the name of the table to create in Hive.//导入到hive中的table名字
   * @param createOnly if true, run the CREATE TABLE statement but not LOAD DATA. true表示没有数据的时候也要创建hive的DDL
   */
  public void importTable(String inputTableName, String outputTableName,
      boolean createOnly) throws IOException {

    if (null == outputTableName) {//如果没有输出的hive的table名字,则默认与输入名字一样
      outputTableName = inputTableName;
    }
    LOG.debug("Hive.inputTable: " + inputTableName);
    LOG.debug("Hive.outputTable: " + outputTableName);

    // For testing purposes against our mock hive implementation,
    // if the sysproperty "expected.script" is set, we set the EXPECTED_SCRIPT
    // environment variable for the child hive process. We also disable
    // timestamp comments so that we have deterministic table creation scripts.
    String expectedScript = System.getProperty("expected.script");
    List<String> env = Executor.getCurEnvpStrings();
    boolean debugMode = expectedScript != null;
    if (debugMode) {
      env.add("EXPECTED_SCRIPT=" + expectedScript);
      env.add("TMPDIR=" + options.getTempDir());
    }

    // generate the HQL statements to run.
    // reset the connection as it might have timed out
    connManager.discardConnection(true);

    //创建hive的建表语句和加载数据语句对象
    TableDefWriter tableWriter = new TableDefWriter(options, connManager,
        inputTableName, outputTableName,
        configuration, !debugMode);
    String createTableStr = tableWriter.getCreateTableStmt() + ";\n";//创建hive的建表DDL
    String loadDataStmtStr = tableWriter.getLoadDataStmt() + ";\n";//创建hive的加载数据的DDL
    Path finalPath = tableWriter.getFinalPath();//最终写入到hive的HDFS什么目录下

    if (!isGenerateOnly()) {//false表示不仅仅是建表语句
      removeTempLogs(finalPath);//创建临时目录,并且移除该临时目录
      LOG.info("Loading uploaded data into Hive");

      String codec = options.getCompressionCodec();
      if (codec != null && (codec.equals(CodecMap.LZOP)
              || codec.equals(CodecMap.getCodecClassName(CodecMap.LZOP)))) {
        try {
          Tool tool = ReflectionUtils.newInstance(Class.
                  forName("com.hadoop.compression.lzo.DistributedLzoIndexer").
                  asSubclass(Tool.class), configuration);
          ToolRunner.run(configuration, tool,
              new String[] { finalPath.toString() });
        } catch (Exception ex) {
          LOG.error("Error indexing lzo files", ex);
          throw new IOException("Error indexing lzo files", ex);
        }
      }
    }

    // write them to a script file.获取脚本,将hive的建表语法和load语法写入脚本中
    File scriptFile = getScriptFile(outputTableName);
    try {
      String filename = scriptFile.toString();
      BufferedWriter w = null;
      try {
        FileOutputStream fos = new FileOutputStream(scriptFile);
        w = new BufferedWriter(new OutputStreamWriter(fos));
        w.write(createTableStr, 0, createTableStr.length());
        if (!createOnly) {
          w.write(loadDataStmtStr, 0, loadDataStmtStr.length());
        }
      } catch (IOException ioe) {
        LOG.error("Error writing Hive load-in script: " + ioe.toString());
        ioe.printStackTrace();
        throw ioe;
      } finally {
        if (null != w) {
          try {
            w.close();
          } catch (IOException ioe) {
            LOG.warn("IOException closing stream to Hive script: "
                + ioe.toString());
          }
        }
      }

      if (!isGenerateOnly()) {//如果是false,表示要执行该建表语法和导入语法
        executeScript(filename, env);//执行ddl文件

        LOG.info("Hive import complete.");

        cleanUp(finalPath);
      }
    } finally {
      if (!isGenerateOnly()) {
        // User isn't interested in saving the DDL. Remove the file.删除ddl文件,因为用户不关注这个ddl文件是什么
        if (!scriptFile.delete()) {
          LOG.warn("Could not remove temporary file: " + scriptFile.toString());
          // try to delete the file later.
          scriptFile.deleteOnExit();
        }
      }
    }
  }

  /**
   * 导入到hive后,要清理输入源目录
   * Clean up after successful HIVE import.
   *
   * @param outputPath path to the output directory
   * @throws IOException
   */
  private void cleanUp(Path outputPath) throws IOException {
    FileSystem fs = FileSystem.get(configuration);

    // HIVE is not always removing input directory after LOAD DATA statement
    // (which is our export directory). We're removing export directory in case
    // that is blank for case that user wants to periodically populate HIVE
    // table (for example with --hive-overwrite).
    try {
      if (outputPath != null && fs.exists(outputPath)) {
        FileStatus[] statuses = fs.listStatus(outputPath);
        if (statuses.length == 0) {//没有文件内容,则可以删除
          LOG.info("Export directory is empty, removing it.");
          fs.delete(outputPath, true);
        } else if (statuses.length == 1 && statuses[0].getPath().getName().equals(FileOutputCommitter.SUCCEEDED_FILE_NAME)) {//说明是只有成功文件夹,因此可以删除
          LOG.info("Export directory is contains the _SUCCESS file only, removing the directory.");
          fs.delete(outputPath, true);
        } else {//说明文件夹下有内容,要保持不删除
          LOG.info("Export directory is not empty, keeping it.");
        }
      }
    } catch(IOException e) {
      LOG.error("Issue with cleaning (safe to ignore)", e);
    }
  }

  @SuppressWarnings("unchecked")
  /**
   * Execute the script file via Hive.
   * If Hive's jars are on the classpath, run it in the same process.
   * Otherwise, execute the file with 'bin/hive'.
   *
   * @param filename The script file to run.
   * @param env the environment strings to pass to any subprocess.
   * @throws IOException if Hive did not exit successfully.
   * 执行建表和load数据的hive脚本
   */
  private void executeScript(String filename, List<String> env)
      throws IOException {
    SubprocessSecurityManager subprocessSM = null;

    if (testMode) {
      // We use external mock hive process for test mode as
      // HCatalog dependency would have brought in Hive classes.
      LOG.debug("Using external Hive process in test mode.");
      executeExternalHiveScript(filename, env);
      return;
    }

    try {//使用hive的内置class类的main方法,执行hive脚本, -f filename
      Class cliDriverClass = Class.forName(HIVE_MAIN_CLASS);

      // We loaded the CLI Driver in this JVM, so we will just
      // call it in-process. The CliDriver class has a method:
      // void main(String [] args) throws Exception.
      //
      // We'll call that here to invoke 'hive -f scriptfile'.
      // Because this method will call System.exit(), we use
      // a SecurityManager to prevent this.
      LOG.debug("Using in-process Hive instance.");

      subprocessSM = new SubprocessSecurityManager();
      subprocessSM.install();

      // Create the argv for the Hive Cli Driver.
      String [] argArray = new String[2];
      argArray[0] = "-f";
      argArray[1] = filename;

      // And invoke the static method on this array.
      Method mainMethod = cliDriverClass.getMethod("main", argArray.getClass());
      mainMethod.invoke(null, (Object) argArray);

    } catch (ClassNotFoundException cnfe) {
      //使用hive的全路径执行脚本文件
      // Hive is not on the classpath. Run externally.
        // This is not an error path.
      LOG.debug("Using external Hive process.");
      executeExternalHiveScript(filename, env);
    } catch (NoSuchMethodException nsme) {
      // Could not find a handle to the main() method.
      throw new IOException("Could not access CliDriver.main()", nsme);
    } catch (IllegalAccessException iae) {
      // Error getting a handle on the main() method.
      throw new IOException("Could not access CliDriver.main()", iae);
    } catch (InvocationTargetException ite) {
      // We ran CliDriver.main() and an exception was thrown from within Hive.
      // This may have been the ExitSecurityException triggered by the
      // SubprocessSecurityManager. If so, handle it. Otherwise, wrap in
      // an IOException and rethrow.

      Throwable cause = ite.getCause();
      if (cause instanceof ExitSecurityException) {
        ExitSecurityException ese = (ExitSecurityException) cause;
        int status = ese.getExitStatus();
        if (status != 0) {
          throw new IOException("Hive CliDriver exited with status=" + status);
        }
      } else {
        throw new IOException("Exception thrown in Hive", ite);
      }
    } finally {
      if (null != subprocessSM) {
        // Uninstall the SecurityManager used to trap System.exit().
        subprocessSM.uninstall();
      }
    }
  }

  /**
   * Execute Hive via an external 'bin/hive' process.
   * @param filename the Script file to run.
   * @param env the environment strings to pass to any subprocess.
   * @throws IOException if Hive did not exit successfully.
   * 使用hive执行一个脚本文件
   * 即hive -f 文件全路径  环境变量
   */
  private void executeExternalHiveScript(String filename, List<String> env)
      throws IOException {
    // run Hive on the script and note the return code.
    String hiveExec = getHiveBinPath();
    ArrayList<String> args = new ArrayList<String>();
    args.add(hiveExec);
    args.add("-f");
    args.add(filename);

    LoggingAsyncSink logSink = new LoggingAsyncSink(LOG);
    int ret = Executor.exec(args.toArray(new String[0]),
        env.toArray(new String[0]), logSink, logSink);
    if (0 != ret) {
      throw new IOException("Hive exited with status " + ret);
    }
  }
}
