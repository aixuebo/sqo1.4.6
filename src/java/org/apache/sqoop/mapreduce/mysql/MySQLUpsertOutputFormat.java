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
package org.apache.sqoop.mapreduce.mysql;

import com.cloudera.sqoop.lib.SqoopRecord;
import com.cloudera.sqoop.mapreduce.UpdateOutputFormat;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Output format for MySQL Update/insert functionality. We will use MySQL
 * clause INSERT INTO ... ON DUPLICATE KEY UPDATE, for more info please
 * see official MySQL documentation.
 */
public class MySQLUpsertOutputFormat<K extends SqoopRecord, V>
    extends UpdateOutputFormat<K, V> {

  private final Log log  =
      LogFactory.getLog(getClass());

  @Override
  /** {@inheritDoc} */
  public RecordWriter<K, V> getRecordWriter(TaskAttemptContext context)
      throws IOException {
    try {
      return new MySQLUpsertRecordWriter(context);
    } catch (Exception e) {
      throw new IOException(e);
    }
  }

  /**
   * RecordWriter to write the output to UPDATE/INSERT statements.
   * 将sql组装成update-insert形式的sql
   */
  public class MySQLUpsertRecordWriter extends UpdateRecordWriter {

    public MySQLUpsertRecordWriter(TaskAttemptContext context)
        throws ClassNotFoundException, SQLException {
      super(context);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected PreparedStatement getPreparedStatement(
        List<SqoopRecord> userRecords) throws SQLException {

      PreparedStatement stmt = null;

      // Synchronize on connection to ensure this does not conflict
      // with the operations in the update thread.
      Connection conn = getConnection();
      synchronized (conn) {
	  stmt = conn.prepareStatement(getUpdateStatement(userRecords.size()));//组装成预编译sql
      }

      // Inject the record parameters into the UPDATE and WHERE clauses.  This
      // assumes that the update key column is the last column serialized in
      // by the underlying record. Our code auto-gen process for exports was
      // responsible for taking care of this constraint.
      //注入各种参数具体值,我们假设更新的关键key是最后一列,自带的sqoop自动生成器为export导出就是这样约束的
      int i = 0;
      for (SqoopRecord record : userRecords) {
        record.write(stmt, i);//从i偏移量开始设置值
        i += columnNames.length;//增加i的数量
      }
      stmt.addBatch();

      return stmt;
    }

    /**
     * 不存在则insert 存在则update的mysql特殊语法
     * 输出sql
     * INSERT INTO tableName (column,column,column) value(?,?,?),(?,?,?),(?,?,?)
     * ON DUPLICATE KEY UPDATE column=values(column),column=values(column),column=values(column) 即更新内容就是替换到value的内容即可
     * @param numRows 要更新多少条数据,比如该值为4,则value就有了4组待插入的值
       */
    protected String getUpdateStatement(int numRows) {
      boolean first;
      StringBuilder sb = new StringBuilder();
      sb.append("INSERT INTO ");
      sb.append(tableName);
      sb.append("(");
      first = true;
      for (String column : columnNames) {
        if (first) {
          first = false;
        } else {
          sb.append(", ");
        }
        sb.append(column);
      }

      sb.append(") VALUES(");
      for (int i = 0; i < numRows; i++) {
        if (i > 0) {
          sb.append("),(");
        }
	    for (int j = 0; j < columnNames.length; j++) {
          if (j > 0) {
            sb.append(", ");
          }
          sb.append("?");
        }
      }

      sb.append(") ON DUPLICATE KEY UPDATE ");

      first = true;
      for (String column : columnNames) {
        if (first) {
          first = false;
        } else {
          sb.append(", ");
        }

        sb.append(column).append("=VALUES(").append(column).append(")");
      }

      String query = sb.toString();
      log.debug("Using upsert query: " + query);
      return query;
    }
  }
}
