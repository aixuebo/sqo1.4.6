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
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.InputSplit;

import com.cloudera.sqoop.mapreduce.db.DBSplitter;
import com.cloudera.sqoop.mapreduce.db.DataDrivenDBInputFormat;

/**
 * Implement DBSplitter over boolean values.
 * 详细解释查看IntegerSplitter类和DBSplitter类注释
 *
 * boolean类型的查询,只能使用一个split或者两个split,因此这种情况作多map加载的可能性不是特别大
 */
public class BooleanSplitter implements DBSplitter {
  public List<InputSplit> split(Configuration conf, ResultSet results,
      String colName) throws SQLException {

    List<InputSplit> splits = new ArrayList<InputSplit>();

    if (results.getString(1) == null && results.getString(2) == null) {//查询is null的情况
      // Range is null to null. Return a null split accordingly.
      splits.add(new DataDrivenDBInputFormat.DataDrivenDBInputSplit(
          colName + " IS NULL", colName + " IS NULL"));
      return splits;
    }

    boolean minVal = results.getBoolean(1); //最小值是true还是false
    boolean maxVal = results.getBoolean(2); //最大值是true还是false

    // Use one or two splits.boolean类型的查询,只能使用一个split或者两个split,因此这种情况作多map加载的可能性不是特别大
    if (!minVal) {//查询该属性为false的情况
      splits.add(new DataDrivenDBInputFormat.DataDrivenDBInputSplit(
          colName + " = FALSE", colName + " = FALSE"));
    }

    if (maxVal) {//查询该属性为true的情况
      splits.add(new DataDrivenDBInputFormat.DataDrivenDBInputSplit(
          colName + " = TRUE", colName + " = TRUE"));
    }

    if (results.getString(1) == null || results.getString(2) == null) {//考虑极限情况,针对他加入is null的查询
      // Include a null value.
      splits.add(new DataDrivenDBInputFormat.DataDrivenDBInputSplit(
          colName + " IS NULL", colName + " IS NULL"));
    }

    return splits;
  }
}
