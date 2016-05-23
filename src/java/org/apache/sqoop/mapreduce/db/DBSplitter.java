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
package org.apache.sqoop.mapreduce.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.InputSplit;

/**
 * DBSplitter will generate DBInputSplits to use with DataDrivenDBInputFormat.
 * DataDrivenDBInputFormat needs to interpolate between two values that
 * represent the lowest and highest valued records to import. Depending
 * on the data-type of the column, this requires different behavior.
 * DBSplitter implementations should perform this for a data type or family
 * of data types.
 * DataDrivenDBInputFormat类用于拆分数据库表的数据的接口
 * DataDrivenDBInputFormat需要插入两个值,代表最低和最高的记录序号
 * 依赖属性的数据类型,每一个类型有不同的行为
 */
public interface DBSplitter {

  /**
   * Given a ResultSet containing one record (and already advanced to that
   * record) with two columns (a low value, and a high value, both of the same
   * type), determine a set of splits that span the given values.
   * 对一个结果集包含一个记录,两个列,高值和低值,要求类型必须相同,该结论会决定给定的value的结果集如何拆分
   * @param results 对边界查询执行的结果集,该结果集可以获取两个值,分别是最小值和最大值
   * @param colName 有些例子我看这个属性是order by的属性,即根据该属性选择最终每一个split的结果集,例如colName>=XXX
   */
  List<InputSplit> split(Configuration conf, ResultSet results, String colName)
      throws SQLException;
}
