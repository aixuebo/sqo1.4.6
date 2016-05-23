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

/**
 * A failure handler which uses basic retry mechanism for handling
 * SQL failures. Retry settings are embedded in job configuration
 * 一个处理失败的类
 * 使用尝试机制,去处理sql的异常情况
 */
public class BasicRetrySQLFailureHandler
    extends SQLFailureHandler {

  private static final Log LOG =
      LogFactory.getLog(BasicRetrySQLFailureHandler.class);

  // Configuration name for retry attempts
  public static final String CONNECTION_RETRY_WAIT_MAX =
      "connection.recover.wait.max";//最大尝试等待的最大时间

  // Configuration name for retry interval 每一次尝试后停留时间
  public static final String CONNECTION_RETRY_WAIT_INTERVAL =
      "connection.recover.wait.interval";

  // Default values for retry settings
  public static final int DEFAULT_RETRY_WAIT_MAX = 2 * 60 * 1000;
  public static final int DEFAULT_RETRY_WAIT_INTERVAL = 500;

  protected int retryWaitMax = 0;
  protected int retryWaitInterval = 0;

  public BasicRetrySQLFailureHandler() {
  }

  /**
   * Initialize the the handler with job configuration.
   */
  public void initialize(Configuration conf) throws IOException {
    super.initialize(conf);

    //初始化属性
    // Retrieve retry settings from job-configuration
    retryWaitMax = conf.getInt(CONNECTION_RETRY_WAIT_MAX,
        DEFAULT_RETRY_WAIT_MAX);
    retryWaitInterval = conf.getInt(CONNECTION_RETRY_WAIT_INTERVAL,
        DEFAULT_RETRY_WAIT_INTERVAL);

    if (retryWaitMax <= retryWaitInterval || retryWaitInterval <= 0) {
      LOG.error("Failed to initialize handler");
      throw new IOException("Invalid retry paramers. Wait Max:  "
        + retryWaitMax + ". wait interval: " + retryWaitInterval);
    }
    LOG.trace("Retry Handler initialized successfully");
  }

  /**
   * Check whether the given failure is supported by this failure handler
   *
   * This is a generic handler for all SQLException failures. Subclasses
   * should override this method for specific error handling
   * true表示异常是sql异常
   */
  public boolean canHandleFailure(Throwable failureCause) {
    return failureCause != null
      && SQLException.class.isAssignableFrom(failureCause.getClass());
  }

  /**
   * Provide specific handling for the failure and return a new valid
   * connection.
   * 在sql失败的时候,重新创建新的数据库连接
   */
  public Connection recover() throws IOException {
    long nextRetryWait = 0;//下一次重试连接的等候时间
    int retryAttempts = 0;//尝试次数
    boolean doRetry = true;//true表示还可以继续循环处理
    boolean validConnection = false;
    Connection conn = null;

    do {
      validConnection = false;

      // Use increasing wait interval下次尝试等待的时间
      nextRetryWait = (long) Math.pow(retryAttempts, 2) * retryWaitInterval;

      // Increase the number of retry attempts
      ++retryAttempts;

      // If we exceeded max retry attempts, try one last time with max value
      if (nextRetryWait > retryWaitMax) {//超过最大值,
        nextRetryWait = retryWaitMax;
        doRetry = false;//不允许在尝试了
      }

      try {
        // Wait before trying to recover the connection
        Thread.sleep(nextRetryWait);

        //每一次都重新建立连接
        // Discard the connection
        discardConnection(conn);

        // Try to get a new connection
        conn = super.getConnection();//重新建立连接
        if (!validateConnection(conn)) {//对刚刚建立的连接,确保有效
          // Log failure and continue
          LOG.warn("Connection not valid");
        } else {//说明连接有效
          LOG.info("A new connection has been established");

          // ConnectionConnection has been recovered so stop recovery retries
          doRetry = false;
          validConnection = true;
        }
      } catch (SQLException sqlEx) {
        LOG.warn("Connection recovery attempt [" + retryAttempts + "] failed."
            + "Exception details: " + sqlEx.toString());
      } catch (Exception ex) {
        // Handle unexpected exceptions
        LOG.error("Failed while recovering the connection. Exception details:"
            + ex.toString());
        throw new IOException(ex);
      }
    } while (doRetry);

    if (!validConnection) {//链接无效
      throw new IOException("Failed to recover connection after " +
          retryAttempts + " retries. Giving up");
    }
    return conn;
  }

  /**
   * Verify the provided connection is valid.
   * true表示连接有效
   */
  protected boolean validateConnection(Connection connection)
      throws SQLException {
    return connection != null && !connection.isClosed()
      && connection.isValid(DEFAULT_RETRY_WAIT_INTERVAL);
  }

  /**
   * Close the given connection.
   * 将连接销毁
   */
  protected void discardConnection(Connection connection) throws IOException {
    try {
      if (connection != null) {
        connection.close();
      }
    } catch(SQLException sqlEx) {
      LOG.warn("Could not close connection. Exception details: " + sqlEx);
    }
  }
}
