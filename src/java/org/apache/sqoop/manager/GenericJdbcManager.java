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

package org.apache.sqoop.manager;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cloudera.sqoop.SqoopOptions;

/**
 * Database manager that is connects to a generic JDBC-compliant
 * database; its constructor is parameterized on the JDBC Driver
 * class to load.
 * 简单的通用获取连接对象,仅仅获取了一个连接器就可以
 * 该方法就是通过驱动连接数据库,因此纯粹的java接口实现的,不能提供特殊功能,比如insert_update方法
 */
public class GenericJdbcManager
    extends com.cloudera.sqoop.manager.SqlManager {

  public static final Log LOG = LogFactory.getLog(
      GenericJdbcManager.class.getName());

  private String jdbcDriverClass;
  private Connection connection;

  public GenericJdbcManager(final String driverClass, final SqoopOptions opts) {
    super(opts);

    this.jdbcDriverClass = driverClass;
  }

  @Override
  public Connection getConnection() throws SQLException {
    if (null == this.connection) {
      this.connection = makeConnection();//获取一个连接器
    }

    return this.connection;
  }

  protected boolean hasOpenConnection() {
    return this.connection != null;
  }

  /**
   * Any reference to the connection managed by this manager is nulled.
   * If doClose is true, then this method will attempt to close the
   * connection first.
   * @param doClose if true, try to close the connection before forgetting it.
   */
  public void discardConnection(boolean doClose) {
    if (doClose && hasOpenConnection()) {
      try {
        this.connection.close();
      } catch(SQLException sqe) {
      }
    }

    this.connection = null;
  }

  public void close() throws SQLException {
    super.close();
    discardConnection(true);
  }

  public String getDriverClass() {
    return jdbcDriverClass;
  }
}

