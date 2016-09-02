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
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import com.cloudera.sqoop.lib.SqoopRecord;

/**
 * Given a set of SqoopRecord instances which are from a "new" dataset
 * or an "old" dataset, extract a key column from the record and tag
 * each record with a bit specifying whether it is a new or old record.
 * 对新 老记录进行合并,抽取出关键的key属性对他进行合并
 */
public class MergeMapperBase<INKEY, INVAL>
    extends Mapper<INKEY, INVAL, Text, MergeRecord> {

  public static final Log LOG = LogFactory.getLog(
      MergeMapperBase.class.getName());

  private String keyColName; // name of the key column.合并的属性,仅能是一个属性
  private boolean isNew; // true if this split is from the new dataset. 新数据还是老数据文件

  @Override
  protected void setup(Context context)
      throws IOException, InterruptedException {
    Configuration conf = context.getConfiguration();
    keyColName = conf.get(MergeJob.MERGE_KEY_COL_KEY);//获取合并的属性

    InputSplit is = context.getInputSplit();
    FileSplit fs = (FileSplit) is;
    Path splitPath = fs.getPath();

    //根据输入源判断是新数据还是老数据文件
    if (splitPath.toString().startsWith(
        conf.get(MergeJob.MERGE_NEW_PATH_KEY))) {//说明是新文件
      this.isNew = true;
    } else if (splitPath.toString().startsWith(
        conf.get(MergeJob.MERGE_OLD_PATH_KEY))) {//说明是老文件
      this.isNew = false;
    } else {
      throw new IOException("File " + splitPath + " is not under new path "
          + conf.get(MergeJob.MERGE_NEW_PATH_KEY) + " or old path "
          + conf.get(MergeJob.MERGE_OLD_PATH_KEY));
    }
  }

  protected void processRecord(SqoopRecord r, Context c)
      throws IOException, InterruptedException {
    MergeRecord mr = new MergeRecord(r, isNew);
    Map<String, Object> fieldMap = r.getFieldMap();//获取该记录每一个key与对应的value值映射个关系
    if (null == fieldMap) {
      throw new IOException("No field map in record " + r);
    }
    Object keyObj = fieldMap.get(keyColName);
    if (null == keyObj) {
      throw new IOException("Cannot join values on null key. "
          + "Did you specify a key column that exists?");
    } else {//key就是合并的主键,value是一整行信息
      c.write(new Text(keyObj.toString()), mr);
    }
  }
}
