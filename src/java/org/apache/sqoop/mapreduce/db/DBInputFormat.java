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

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configurable;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.InputFormat;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.JobContext;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.sqoop.mapreduce.DBWritable;

import com.cloudera.sqoop.config.ConfigurationHelper;
import com.cloudera.sqoop.mapreduce.db.DBConfiguration;
import com.cloudera.sqoop.mapreduce.db.DBRecordReader;
import com.cloudera.sqoop.mapreduce.db.OracleDBRecordReader;

/**
 * A InputFormat that reads input data from an SQL table.
 * <p>
 * DBInputFormat emits LongWritables containing the record number as
 * key and DBWritables as value.
 *
 * The SQL query, and input class can be using one of the two
 * setInput methods.
 * 如何从sql中读取一行行记录,即一行mysql信息传输给他之后,会转换成什么对象
 * 真正将sql数据转换成对象的,其实是对应的每一个table的java序列化类实现的
 *
 * 这种方式查询的sql,不是使用>= <=等方式进行查询,而是使用limit方式查询,因此效率上会稍微有一些问题
 * 如果使用效率高的>= 或者 <=方式查询,请查看DataDrivenDBInputFormat类实现
 */
public class DBInputFormat<T extends DBWritable>
extends InputFormat<LongWritable, T> implements Configurable  {

  public static final Log LOG = LogFactory.getLog(
    DBInputFormat.class.getName());
  private String dbProductName = "DEFAULT";//查询哪个数据库

  /**
   * A Class that does nothing, implementing DBWritable.
   * 实现数据库操作的序列化以及hadoop的序列化
   */
  public static class NullDBWritable implements DBWritable, Writable {
    @Override
    public void readFields(DataInput in) throws IOException { }

    //不会将数据库结果集的一行数据转换成任意对象
    @Override
    public void readFields(ResultSet arg0) throws SQLException { }
    @Override
    public void write(DataOutput out) throws IOException { }

    //不会向该数据库预处理对象中添加任何值,即不会向数据库中写入任何数据
    @Override
    public void write(PreparedStatement arg0) throws SQLException { }
  }

  /**
   * A InputSplit that spans a set of rows.
   * 如何拆分一个数据库的limit
   */
  public static class DBInputSplit extends InputSplit implements Writable {

    private long end = 0;//该数据库截止到什么序号为止
    private long start = 0;//从什么序号开始查询
    //eng-start 就是limit length,而offset偏移量就是start

    /**
     * Default Constructor.
     */
    public DBInputSplit() {
    }

    /**
     * Convenience Constructor.
     * @param start the index of the first row to select
     * @param end the index of the last row to select
     */
    public DBInputSplit(long start, long end) {
      this.start = start;
      this.end = end;
    }

    @Override
    /** {@inheritDoc} */
    public String[] getLocations() throws IOException {
      // TODO Add a layer to enable SQL "sharding" and support locality
      return new String[] {};
    }

    /**
     * @return The index of the first row to select
     */
    public long getStart() {
      return start;
    }

    /**
     * @return The index of the last row to select
     */
    public long getEnd() {
      return end;
    }

    /**
     * @return The total row count in this split
     */
    public long getLength() throws IOException {
      return end - start;
    }

    @Override
    /** {@inheritDoc} */
    public void readFields(DataInput input) throws IOException {
      start = input.readLong();
      end = input.readLong();
    }

    @Override
    /** {@inheritDoc} */
    public void write(DataOutput output) throws IOException {
      output.writeLong(start);
      output.writeLong(end);
    }
  }

  private String conditions;//where条件

  private Connection connection;

  private String tableName;//数据库表名字

  private String[] fieldNames;//要查询哪些属性

  private DBConfiguration dbConf;

  @Override
  /** {@inheritDoc} */
  public void setConf(Configuration conf) {

    //初始化数据库的连接和表、属性等信息
    dbConf = new DBConfiguration(conf);

    try {
      getConnection();
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }

    tableName = dbConf.getInputTableName();
    fieldNames = dbConf.getInputFieldNames();
    conditions = dbConf.getInputConditions();
  }


  //设置隔离级别
  private void setTxIsolation(Connection conn) {
    try {

      if (getConf()
        .getBoolean(DBConfiguration.PROP_RELAXED_ISOLATION, false)) {
        if (dbProductName.startsWith("ORACLE")) {
          LOG.info("Using read committed transaction isolation for Oracle"
            + " as read uncommitted is not supported");
          this.connection.setTransactionIsolation(
            Connection.TRANSACTION_READ_COMMITTED);
        } else {
          LOG.info("Using read uncommited transaction isolation");
          this.connection.setTransactionIsolation(
            Connection.TRANSACTION_READ_UNCOMMITTED);
        }
      }
      else {
        LOG.info("Using read commited transaction isolation");
        this.connection.setTransactionIsolation(
          Connection.TRANSACTION_READ_COMMITTED);
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
  public Configuration getConf() {
    return dbConf.getConf();
  }

  public DBConfiguration getDBConf() {
    return dbConf;
  }

  public Connection getConnection() {
    try {

      if (null == this.connection) {
        // The connection was closed; reinstantiate it.
        this.connection = dbConf.getConnection();
        this.connection.setAutoCommit(false);
        DatabaseMetaData dbMeta = connection.getMetaData();
        this.dbProductName = dbMeta.getDatabaseProductName().toUpperCase();//设置数据库
        setTxIsolation(connection);//设置隔离级别
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return connection;
  }

  public String getDBProductName() {
    return dbProductName;
  }

  //创建一个reader,去读取数据库信息,将其转换成<LongWritable, T>对象,读取某一个limit范围内的数据
  protected RecordReader<LongWritable, T> createDBRecordReader(
      com.cloudera.sqoop.mapreduce.db.DBInputFormat.DBInputSplit split,
      Configuration conf) throws IOException {

    @SuppressWarnings("unchecked")
    Class<T> inputClass = (Class<T>) (dbConf.getInputClass());
    try {
      // use database product name to determine appropriate record reader.
      if (dbProductName.startsWith("ORACLE")) {
        // use Oracle-specific db reader.
        return new OracleDBRecordReader<T>(split, inputClass,
            conf, getConnection(), getDBConf(), conditions, fieldNames,
            tableName);
      } else if (dbProductName.startsWith("DB2")) {
        // use DB2-specific db reader.
        return new Db2DBRecordReader<T>(split, inputClass,
            conf, getConnection(), getDBConf(), conditions, fieldNames,
            tableName);
      } else {//使用DBRecordReader去读取数据库信息
        // Generic reader.
        return new DBRecordReader<T>(split, inputClass,
            conf, getConnection(), getDBConf(), conditions, fieldNames,
            tableName);
      }
    } catch (SQLException ex) {
      throw new IOException(ex);
    }
  }

  //创建一个reader对象
  @Override
  /** {@inheritDoc} */
  public RecordReader<LongWritable, T> createRecordReader(InputSplit split,
      TaskAttemptContext context) throws IOException, InterruptedException {

    return createDBRecordReader(
        (com.cloudera.sqoop.mapreduce.db.DBInputFormat.DBInputSplit) split,
        context.getConfiguration());
  }

  //对数据库整体表进行拆分,即按照map数量拆分成多个任务去执行
  /** {@inheritDoc} */
  @Override
  public List<InputSplit> getSplits(JobContext job) throws IOException {

    ResultSet results = null;
    Statement statement = null;
    try {
      statement = connection.createStatement();

      results = statement.executeQuery(getCountQuery());//计算该sql有多少条数据的sql
      results.next();

      long count = results.getLong(1);//计算该sql有多少条数据
      int chunks = ConfigurationHelper.getJobNumMaps(job);//获取多少个map执行该数据
      long chunkSize = (count / chunks);//平均每一个map要执行多少条数据

      results.close();
      statement.close();

      List<InputSplit> splits = new ArrayList<InputSplit>();

      // Split the rows into n-number of chunks and adjust the last chunk
      // accordingly
      for (int i = 0; i < chunks; i++) {
        DBInputSplit split;

        if ((i + 1) == chunks) {//最后一个数据块,要一直查询到最终结束
          split = new DBInputSplit(i * chunkSize, count);
        } else {
          split = new DBInputSplit(i * chunkSize, (i * chunkSize)
              + chunkSize);
        }

        splits.add(split);
      }

      connection.commit();
      return splits;
    } catch (SQLException e) {
      throw new IOException("Got SQLException", e);
    } finally {
      try {
        if (results != null) { results.close(); }
      } catch (SQLException e1) { /* ignored */ }
      try {
        if (statement != null) { statement.close(); }
      } catch (SQLException e1) { /* ignored */ }

      closeConnection();
    }
  }

  /** Returns the query for getting the total number of rows,
   * subclasses can override this for custom behaviour.
   * 计算总数的count的sql
   * select count(*) from biao where conditions
   **/
  protected String getCountQuery() {

    if (dbConf.getInputCountQuery() != null) {//直接使用设置的sql查询
      return dbConf.getInputCountQuery();
    }

    StringBuilder query = new StringBuilder();
    query.append("SELECT COUNT(*) FROM " + tableName);

    if (conditions != null && conditions.length() > 0) {
      query.append(" WHERE " + conditions);
    }
    return query.toString();
  }

  /**
   * Initializes the map-part of the job with the appropriate input settings.
   * 初始化任务
   * @param job The map-reduce job 设置job作业
   * @param inputClass the class object implementing DBWritable, which is the
   * Java object holding tuple fields.一个table表序列化的对象,是sqoop自动生成的代码
   * @param tableName The table to read data from
   * @param conditions The condition which to select data with,
   * eg. '(updated &gt; 20070101 AND length &gt; 0)'
   * @param orderBy the fieldNames in the orderBy clause.
   * @param fieldNames The field names in the table
   * @see #setInput(Job, Class, String, String)
   */
  public static void setInput(Job job,
      Class<? extends DBWritable> inputClass,
      String tableName, String conditions,
      String orderBy, String... fieldNames) {
    job.setInputFormatClass(DBInputFormat.class);
    DBConfiguration dbConf = new DBConfiguration(job.getConfiguration());
    dbConf.setInputClass(inputClass);
    dbConf.setInputTableName(tableName);
    dbConf.setInputFieldNames(fieldNames);
    dbConf.setInputConditions(conditions);
    dbConf.setInputOrderBy(orderBy);
  }

  /**
   * Initializes the map-part of the job with the appropriate input settings.
   *
   * @param job The map-reduce job
   * @param inputClass the class object implementing DBWritable, which is the
   * Java object holding tuple fields.
   * @param inputQuery the input query to select fields. Example :
   * "SELECT f1, f2, f3 FROM Mytable ORDER BY f1" 查询的sql
   * @param inputCountQuery the input query that returns
   * the number of records in the table. 计算count的sql
   * Example : "SELECT COUNT(f1) FROM Mytable"
   * @see #setInput(Job, Class, String, String, String, String...)
   */
  public static void setInput(Job job,
      Class<? extends DBWritable> inputClass,
      String inputQuery, String inputCountQuery) {
    job.setInputFormatClass(DBInputFormat.class);
    DBConfiguration dbConf = new DBConfiguration(job.getConfiguration());
    dbConf.setInputClass(inputClass);
    dbConf.setInputQuery(inputQuery);
    dbConf.setInputCountQuery(inputCountQuery);
  }

  protected void closeConnection() {
    try {
      if (null != this.connection) {
        this.connection.close();
        this.connection = null;
      }
    } catch (SQLException sqlE) { /* ignore exception on close. */ }
  }

}
