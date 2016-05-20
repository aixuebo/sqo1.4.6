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
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import com.cloudera.sqoop.lib.SqoopRecord;

/**
 * Reducer for merge tool. Given records tagged as 'old' or 'new', emit
 * a new one if possible; otherwise, an old one.
 * 合并的reducef方法,key就是合并的主键,value分别是新老数据一行行的数据信息
 */
public class MergeReducer
    extends Reducer<Text, MergeRecord, SqoopRecord, NullWritable> {

  @Override
  public void reduce(Text key, Iterable<MergeRecord> vals, Context c)
      throws IOException, InterruptedException {
    SqoopRecord bestRecord = null;
    try {
      for (MergeRecord val : vals) {
        if (null == bestRecord && !val.isNewRecord()) {//如果是老数据,并且是第一条老数据,则先初始化该数据,如果bestRecord!=null,说明已经存在了新数据了,因此不需要老数据覆盖新数据
          // Use an old record if we don't have a new record.
          bestRecord = (SqoopRecord) val.getSqoopRecord().clone();
        } else if (val.isNewRecord()) {//如果是新数据,则使用最新的数据,即新数据会覆盖老数据
          bestRecord = (SqoopRecord) val.getSqoopRecord().clone();
        }
      }
    } catch (CloneNotSupportedException cnse) {
      throw new IOException(cnse);
    }

    if (null != bestRecord) {//存储最新的数据
      c.write(bestRecord, NullWritable.get());
    }
  }
}

