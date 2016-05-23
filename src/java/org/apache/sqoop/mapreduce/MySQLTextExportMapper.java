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
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import com.cloudera.sqoop.manager.MySQLUtils;
import com.cloudera.sqoop.mapreduce.MySQLExportMapper;

/**
 * mysqlimport-based exporter which accepts lines of text from files
 * in HDFS to emit to the database.
 * 使用mysql的import快速导入功能,将数据导入到mysql中的map处理类
 */
public class MySQLTextExportMapper
    extends MySQLExportMapper<LongWritable, Text> {

  // End-of-record delimiter.
  private String recordEndStr;//每一行的拆分符号,默认是\n

  @Override
  protected void setup(Context context) {
    super.setup(context);

    char recordDelim = (char) conf.getInt(MySQLUtils.OUTPUT_RECORD_DELIM_KEY,
        (int) '\n');//每一行的拆分符号,默认是\n
    this.recordEndStr = "" + recordDelim;//将其改成字符串形式,而不是char形式
  }

  /**
   * Export the table to MySQL by using mysqlimport to write the data to the
   * database.
   *
   * Expects one delimited text record as the 'val'; ignores the key.
   * 导入直接到mysql中,不需要输出到reduce里面,因此没有看到方法里面有输出方法
   */
  @Override
  public void map(LongWritable key, Text val, Context context)
      throws IOException, InterruptedException {

    //将一行已经格式化成mysql import可以是别的文本导入到mysql中
    writeRecord(val.toString(), this.recordEndStr);

    // We don't emit anything to the OutputCollector because we wrote
    // straight to mysql. Send a progress indicator to prevent a timeout.
    context.progress();
  }

}
