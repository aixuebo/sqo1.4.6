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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.sqoop.mapreduce.DBWritable;
import org.apache.hadoop.util.ReflectionUtils;

import com.cloudera.sqoop.mapreduce.db.DBConfiguration;
import com.cloudera.sqoop.mapreduce.db.DBInputFormat;
import org.apache.sqoop.util.LoggingUtils;

/**
 * A RecordReader that reads records from a SQL table.
 * Emits LongWritables containing the record number as
 * key and DBWritables as value.
 * 从sql中读取一行数据,转换成DBWritable对象
 * key当前查询limit 100,假设这100个的第1个就是整个数据库的第201条,则这个key就是201,即该key在全部数据库中的序号
 * value就是一行mysql的数据记录
 */
public class DBRecordReader<T extends DBWritable> extends
  RecordReader<LongWritable, T> {

  private static final Log LOG = LogFactory.getLog(DBRecordReader.class);

  private ResultSet results = null;//查询结果集

  private Class<T> inputClass;

  private Configuration conf;

  private DBInputFormat.DBInputSplit split;//获取该sql的limit部分

  private long pos = 0;//当前limit 查询100条记录中,已经执行了第几条记录了

  private LongWritable key = null;//当前查询limit 100,假设这100个的第1个就是整个数据库的第201条,则这个key就是201,即该key在全部数据库中的序号

  private T value = null;//将一行sql数据转换成一个对象

  private Connection connection;//数据库连接器

  protected PreparedStatement statement;//查询sql的预处理器

  private DBConfiguration dbConf;

  private String conditions;//where 条件

  private String [] fieldNames;//导出的属性集合

  private String tableName;//导出哪个表

  /**
   * @param split The InputSplit to read data for
   * @throws SQLException
   */
  // CHECKSTYLE:OFF
  // TODO (aaron): Refactor constructor to take fewer arguments
  public DBRecordReader(DBInputFormat.DBInputSplit split,
      Class<T> inputClass, Configuration conf, Connection conn,
      DBConfiguration dbConfig, String cond, String [] fields, String table)
      throws SQLException {
    this.inputClass = inputClass;
    this.split = split;
    this.conf = conf;
    this.connection = conn;
    this.dbConf = dbConfig;
    this.conditions = cond;
    if (fields != null) {
      this.fieldNames = Arrays.copyOf(fields, fields.length);
    }
    this.tableName = table;
  }
  // CHECKSTYLE:ON

  //执行该sql,返回查询结果集
  protected ResultSet executeQuery(String query) throws SQLException {
    this.statement = connection.prepareStatement(query,
        ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);

    Integer fetchSize = dbConf.getFetchSize();
    if (fetchSize != null) {
      LOG.debug("Using fetchSize for next query: " + fetchSize);
      statement.setFetchSize(fetchSize);
    }

    LOG.info("Executing query: " + query);
    return statement.executeQuery();
  }

  /** Returns the query for selecting the records,
   * subclasses can override this for custom behaviour.*/
  protected String getSelectQuery() {
    StringBuilder query = new StringBuilder();

    // Default codepath for MySQL, HSQLDB, etc.
    // Relies on LIMIT/OFFSET for splits.
    //sql:select column,column,column from tableName as tableName where (conditions) order by orderBy limit n OFFSET m
    if (dbConf.getInputQuery() == null) {
      query.append("SELECT ");

      for (int i = 0; i < fieldNames.length; i++) {
        query.append(fieldNames[i]);
        if (i != fieldNames.length -1) {
          query.append(", ");
        }
      }

      query.append(" FROM ").append(tableName);
      query.append(" AS ").append(tableName); //in hsqldb this is necessary
      if (conditions != null && conditions.length() > 0) {
        query.append(" WHERE (").append(conditions).append(")");
      }

      String orderBy = dbConf.getInputOrderBy();
      if (orderBy != null && orderBy.length() > 0) {
        query.append(" ORDER BY ").append(orderBy);
      }
    } else {
      //PREBUILT QUERY
      query.append(dbConf.getInputQuery());
    }

    try {
      query.append(" LIMIT ").append(split.getLength());
      query.append(" OFFSET ").append(split.getStart());
    } catch (IOException ex) {
      // Ignore, will not throw.
    }

    return query.toString();
  }

  //关闭连接
  @Override
  public void close() throws IOException {
    try {
      if (null != results) {
        results.close();
      }
      // Statement.isClosed() is only available from JDBC 4
      // Some older drivers (like mysql 5.0.x and earlier fail with
      // the check for statement.isClosed()
      if (null != statement) {
        statement.close();
      }
      if (null != connection && !connection.isClosed()) {
        connection.commit();
        connection.close();
      }
    } catch (SQLException e) {
      throw new IOException(e);
    }
  }

  public void initialize(InputSplit inputSplit, TaskAttemptContext context)
      throws IOException, InterruptedException {
    //do nothing
  }

  @Override
  public LongWritable getCurrentKey() {
    return key;
  }

  @Override
  public T getCurrentValue() {
    return value;
  }

  /**
   * @deprecated
   */
  @Deprecated
  public T createValue() {
    return ReflectionUtils.newInstance(inputClass, conf);
  }

  /**
   * @deprecated
   */
  @Deprecated
  public long getPos() throws IOException {
    return pos;
  }

  /**
   * @deprecated Use {@link #nextKeyValue()}
   */
  @Deprecated
  public boolean next(LongWritable k, T v) throws IOException {
    this.key = k;
    this.value = v;
    return nextKeyValue();
  }

  //已经查询了多少条记录的百分比
  @Override
  public float getProgress() throws IOException {
    return pos / (float)split.getLength();
  }

  @Override
  public boolean nextKeyValue() throws IOException {
    try {
      if (key == null) {//初始化long
        key = new LongWritable();
      }
      if (value == null) {
        value = createValue();
      }
      if (null == this.results) {
        // First time into this method, run the query.
        LOG.info("Working on split: " + split);
        this.results = executeQuery(getSelectQuery());//查询sql
      }
      if (!results.next()) {//获取不到数据了,返回false,true表示游标已经到下一行数据了,接下来直接结果集rs.get就可以获取到值填充value
        return false;
      }

      // Set the key field value as the output key value 设置key在数据库的序号
      key.set(pos + split.getStart());

      value.readFields(results);//从结果集中返回数据,生成对应的value对象,即从rs中获取数据田中到value中

      pos++;//序号累加1
    } catch (SQLException e) {
      LoggingUtils.logAll(LOG, e);
      if (this.statement != null) {
        try {
          statement.close();
        } catch (SQLException ex) {
          LoggingUtils.logAll(LOG, "Failed to close statement", ex);
        } finally {
          this.statement = null;
        }
      }
      if (this.connection != null) {
        try {
          connection.close();
        } catch (SQLException ex) {
          LoggingUtils.logAll(LOG, "Failed to close connection", ex);
        } finally {
          this.connection = null;
        }
      }
      if (this.results != null) {
        try {
          results.close();
        } catch (SQLException ex) {
          LoggingUtils.logAll(LOG, "Failed to close ResultsSet", ex);
        } finally {
          this.results = null;
        }
      }

      throw new IOException("SQLException in nextKeyValue", e);
    }
    return true;
  }

  /**
   * @return true if nextKeyValue() would return false.
   */
  protected boolean isDone() {
    try {
      return this.results != null && results.isAfterLast();
    } catch (SQLException sqlE) {
      return true;
    }
  }

  protected DBInputFormat.DBInputSplit getSplit() {
    return split;
  }

  protected String [] getFieldNames() {
    return fieldNames;
  }

  protected String getTableName() {
    return tableName;
  }

  protected String getConditions() {
    return conditions;
  }

  protected DBConfiguration getDBConf() {
    return dbConf;
  }

  protected Connection getConnection() {
    return connection;
  }

  protected void setConnection(Connection conn) {
    connection = conn;
  }

  protected PreparedStatement getStatement() {
    return statement;
  }

  protected void setStatement(PreparedStatement stmt) {
    this.statement = stmt;
  }

  /**
   * @return the configuration. Allows subclasses to access the configuration
   */
  protected Configuration getConf(){
    return conf;
  }
}
