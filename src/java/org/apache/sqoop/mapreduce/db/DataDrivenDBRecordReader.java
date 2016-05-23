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


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.sqoop.mapreduce.DBWritable;

import com.cloudera.sqoop.mapreduce.db.DBConfiguration;
import com.cloudera.sqoop.mapreduce.db.DBInputFormat;
import com.cloudera.sqoop.mapreduce.db.DBRecordReader;
import com.cloudera.sqoop.mapreduce.db.DataDrivenDBInputFormat;

/**
 * A RecordReader that reads records from a SQL table,
 * using data-driven WHERE clause splits.
 * Emits LongWritables containing the record number as
 * key and DBWritables as value.
 * 从sql中读取数据,转换成一个java对象
 */
public class DataDrivenDBRecordReader<T extends DBWritable>
    extends DBRecordReader<T> {

  private static final Log LOG =
      LogFactory.getLog(DataDrivenDBRecordReader.class);

  private String dbProductName; // database manufacturer string.数据库名称

  // CHECKSTYLE:OFF
  // TODO(aaron): Refactor constructor to use fewer arguments.
  /**
   * @param split The InputSplit to read data for
   * @throws SQLException
   */
  public DataDrivenDBRecordReader(DBInputFormat.DBInputSplit split,
      Class<T> inputClass, Configuration conf, Connection conn,
      DBConfiguration dbConfig, String cond, String [] fields, String table,
      String dbProduct) throws SQLException {
    super(split, inputClass, conf, conn, dbConfig, cond, fields, table);
    this.dbProductName = dbProduct;
  }
  // CHECKSTYLE:ON

  @Override
  /** {@inheritDoc}
   * 进度只有100% 或者0%
   **/
  public float getProgress() throws IOException {
    return isDone() ? 1.0f : 0.0f;
  }

  /** Returns the query for selecting the records,
   * subclasses can override this for custom behaviour.
   * 运行一个sql查询,可以被子类自定义行为覆盖掉该方法
   **/
  protected String getSelectQuery() {
    DataDrivenDBInputFormat.DataDrivenDBInputSplit dataSplit =
        (DataDrivenDBInputFormat.DataDrivenDBInputSplit) getSplit();
    return getSelectQuery(dataSplit.getLowerClause(),
        dataSplit.getUpperClause());
  }

  /** Returns the query for selecting the records, with lower and upper
   * clause consitions provided as parameters
   * This is needed for recovering from connection failures after some data
   * in the split have been already processed
   * 返回sql:select column,column,column from table as table where (conditions) and (lowerClause) and (upperClause)
   **/
  protected String getSelectQuery(String lowerClause, String upperClause) {
    StringBuilder query = new StringBuilder();
    DBConfiguration dbConf = getDBConf();
    String [] fieldNames = getFieldNames();
    String tableName = getTableName();
    String conditions = getConditions();

    // Build the WHERE clauses associated with the data split first.
    // We need them in both branches of this function.
    StringBuilder conditionClauses = new StringBuilder();
    conditionClauses.append("( ").append(lowerClause);
    conditionClauses.append(" ) AND ( ").append(upperClause);
    conditionClauses.append(" )");

    //select column,column,column from table as table where (conditions) and (lowerClause) and (upperClause)
    if (dbConf.getInputQuery() == null) {
      // We need to generate the entire query.
      query.append("SELECT ");

      for (int i = 0; i < fieldNames.length; i++) {
        query.append(fieldNames[i]);
        if (i != fieldNames.length -1) {
          query.append(", ");
        }
      }

      query.append(" FROM ").append(tableName);
      if (!dbProductName.startsWith("ORACLE")
          && !dbProductName.startsWith("DB2")
          && !dbProductName.startsWith("MICROSOFT SQL SERVER")
          && !dbProductName.startsWith("POSTGRESQL")) {
        // The AS clause is required for hsqldb. Some other databases might have
        // issues with it, so we're skipping some of them.
        query.append(" AS ").append(tableName);
      }
      query.append(" WHERE ");
      if (conditions != null && conditions.length() > 0) {
        // Put the user's conditions first.
        query.append("( ").append(conditions).append(" ) AND ");
      }

      // Now append the conditions associated with our split.
      query.append(conditionClauses.toString());

    } else {//根据提供的查询sql,将$CONDITIONS替换成(lowerClause) and (upperClause)
      // User provided the query. We replace the special token with
      // our WHERE clause.
      String inputQuery = dbConf.getInputQuery();
      if (inputQuery.indexOf(DataDrivenDBInputFormat.SUBSTITUTE_TOKEN) == -1) {
        LOG.error("Could not find the clause substitution token "
            + DataDrivenDBInputFormat.SUBSTITUTE_TOKEN + " in the query: ["
            + inputQuery + "]. Parallel splits may not work correctly.");
      }

      query.append(inputQuery.replace(DataDrivenDBInputFormat.SUBSTITUTE_TOKEN,
          conditionClauses.toString()));
    }

    LOG.debug("Using query: " + query.toString());

    return query.toString();
  }
}
