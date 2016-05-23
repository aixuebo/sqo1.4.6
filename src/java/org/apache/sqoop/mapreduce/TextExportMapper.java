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

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.hadoop.util.ReflectionUtils;
import com.cloudera.sqoop.lib.SqoopRecord;
import com.cloudera.sqoop.mapreduce.AutoProgressMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Converts an input record from a string representation to a parsed Sqoop
 * record and emits that DBWritable to the OutputFormat for writeback to the
 * database.
 * hdfs上存储的是文本文件,将该文本文件插入到数据库中
 *
 * 将一行text转换成SqoopRecord对象
 */
public class TextExportMapper
    extends AutoProgressMapper<LongWritable, Text, SqoopRecord, NullWritable> {

  public static final Log LOG =
    LogFactory.getLog(TextExportMapper.class.getName());

  private SqoopRecord recordImpl;//解析table对应的实体类

  public TextExportMapper() {
  }

  protected void setup(Context context)
      throws IOException, InterruptedException {
    super.setup(context);

    Configuration conf = context.getConfiguration();

    // Instantiate a copy of the user's class to hold and parse the record.
    //table表对应的实体类
    String recordClassName = conf.get(
        ExportJobBase.SQOOP_EXPORT_TABLE_CLASS_KEY);
    if (null == recordClassName) {
      throw new IOException("Export table class name ("
          + ExportJobBase.SQOOP_EXPORT_TABLE_CLASS_KEY
          + ") is not set!");
    }

    try {
      Class cls = Class.forName(recordClassName, true,
          Thread.currentThread().getContextClassLoader());
      recordImpl = (SqoopRecord) ReflectionUtils.newInstance(cls, conf);
    } catch (ClassNotFoundException cnfe) {
      throw new IOException(cnfe);
    }

    if (null == recordImpl) {
      throw new IOException("Could not instantiate object of type "
          + recordClassName);
    }
  }

  //将一行text转换成SqoopRecord对象
  public void map(LongWritable key, Text val, Context context)
      throws IOException, InterruptedException {
    try {
      recordImpl.parse(val);//进行对文本解析
      context.write(recordImpl, NullWritable.get());//然后放到reduce中
    } catch (Exception e) {//解析异常
      // Something bad has happened
      LOG.error("");
      LOG.error("Exception raised during data export");
      LOG.error("");

      LOG.error("Exception: ", e);//异常信息
      LOG.error("On input: " + val);//异常的原始内容

      InputSplit is = context.getInputSplit();
      if (is instanceof FileSplit) {//哪个文件有异常
        LOG.error("On input file: " + ((FileSplit)is).getPath());
      } else if (is instanceof CombineFileSplit) {//哪个合并的压缩文件有异常
        LOG.error("On input file: "
          + context.getConfiguration().get("map.input.file"));
      }
      LOG.error("At position " + key);//异常在原始文件的什么字节处开始的异常

      LOG.error("");
      LOG.error("Currently processing split:");
      LOG.error(is);

      LOG.error("");
      LOG.error("This issue might not necessarily be caused by current input");
      LOG.error("due to the batching nature of export.");
      LOG.error("");
      //抛异常,导入操作失败
      throw new IOException("Can't export data, please check failed map task logs", e);
    }
  }
}
