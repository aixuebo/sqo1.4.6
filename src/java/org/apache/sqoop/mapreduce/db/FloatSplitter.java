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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.InputSplit;

import com.cloudera.sqoop.config.ConfigurationHelper;
import com.cloudera.sqoop.mapreduce.db.DBSplitter;
import com.cloudera.sqoop.mapreduce.db.DataDrivenDBInputFormat;

/**
 * Implement DBSplitter over floating-point values.
 * 详细解释查看IntegerSplitter类和DBSplitter类注释
 */
public class FloatSplitter implements DBSplitter  {

  private static final Log LOG = LogFactory.getLog(FloatSplitter.class);

  private static final double MIN_INCREMENT = 10000 * Double.MIN_VALUE;

  /**
   *
   * @param results 对边界查询执行的结果集,该结果集可以获取两个值,分别是最小值和最大值
   * @param colName 有些例子我看这个属性是order by的属性,即根据该属性选择最终每一个split的结果集,例如colName>=XXX
     */
  public List<InputSplit> split(Configuration conf, ResultSet results,
      String colName) throws SQLException {

    LOG.warn("Generating splits for a floating-point index column. Due to the");
    LOG.warn("imprecise representation of floating-point values in Java, this");
    LOG.warn("may result in an incomplete import.");
    LOG.warn("You are strongly encouraged to choose an integral split column.");

    List<InputSplit> splits = new ArrayList<InputSplit>();

    if (results.getString(1) == null && results.getString(2) == null) {//设置一个is null的查询条件
      // Range is null to null. Return a null split accordingly.
      splits.add(new DataDrivenDBInputFormat.DataDrivenDBInputSplit(
          colName + " IS NULL", colName + " IS NULL"));
      return splits;
    }

    double minVal = results.getDouble(1);//边界最小值
    double maxVal = results.getDouble(2);//边界最大值

    // Use this as a hint. May need an extra task if the size doesn't
    // divide cleanly.
    int numSplits = ConfigurationHelper.getConfNumMaps(conf);//获取map数
    double splitSize = (maxVal - minVal) / (double) numSplits;//每一个map大概拆分大小

    if (splitSize < MIN_INCREMENT) {
      splitSize = MIN_INCREMENT;
    }

    String lowClausePrefix = colName + " >= ";
    String highClausePrefix = colName + " < ";

    double curLower = minVal;
    double curUpper = curLower + splitSize;

    while (curUpper < maxVal) {
      splits.add(new DataDrivenDBInputFormat.DataDrivenDBInputSplit(
          lowClausePrefix + Double.toString(curLower),
          highClausePrefix + Double.toString(curUpper)));

      curLower = curUpper;
      curUpper += splitSize;
    }

    // Catch any overage and create the closed interval for the last split.
    if (curLower <= maxVal || splits.size() == 1) {
      splits.add(new DataDrivenDBInputFormat.DataDrivenDBInputSplit(
          lowClausePrefix + Double.toString(curUpper),
          colName + " <= " + Double.toString(maxVal)));
    }

    if (results.getString(1) == null || results.getString(2) == null) {//对于极限情况的考虑,要查询is null的情况
      // At least one extrema is null; add a null split.
      splits.add(new DataDrivenDBInputFormat.DataDrivenDBInputSplit(
          colName + " IS NULL", colName + " IS NULL"));
    }

    return splits;
  }
}
