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

package org.apache.sqoop.util;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Some utilities for parsing JDBC URLs which may not be tolerated
 * by Java's java.net.URL class.
 * java.net.URL does not support multi:part:scheme:// components, which
 * virtually all JDBC connect string URLs have.
 * 例如:jdbc:mysql://ip:port/database?
 */
public final class JdbcUrl {

  public static final Log LOG = LogFactory.getLog(JdbcUrl.class.getName());

  private JdbcUrl() {
  }

  /**
   * @return the database name from the connect string, which is typically the
   * 'path' component, or null if we can't.
   * 返回连接串对应的数据库名称
   */
  public static String getDatabaseName(String connectString) {
    try {
      String sanitizedString = null;//将字符串转换成http的标准url,方便提取数据
      int schemeEndOffset = connectString.indexOf("://");
      if (-1 == schemeEndOffset) {
        // couldn't find one? try our best here.
        sanitizedString = "http://" + connectString;
        LOG.warn("Could not find database access scheme in connect string "
            + connectString);
      } else {
        sanitizedString = "http" + connectString.substring(schemeEndOffset);
      }

      URL connectUrl = new URL(sanitizedString);//组装成url对象
      String databaseName = connectUrl.getPath();//数据库名称
      if (null == databaseName) {
        return null;
      }

      // This is taken from a 'path' part of a URL, which may have leading '/'
      // characters; trim them off.
      while (databaseName.startsWith("/")) {
        databaseName = databaseName.substring(1);
      }

      return databaseName;
    } catch (MalformedURLException mue) {
      LOG.error("Malformed connect string URL: " + connectString
          + "; reason is " + mue.toString());
      return null;
    }
  }

  /**
   * @return the hostname from the connect string, or null if we can't.
   * 返回连接串对应的host
   */
  public static String getHostName(String connectString) {
    try {
      String sanitizedString = null;
      int schemeEndOffset = connectString.indexOf("://");
      if (-1 == schemeEndOffset) {
        // Couldn't find one? ok, then there's no problem, it should work as a
        // URL.
        sanitizedString = connectString;
      } else {
        sanitizedString = "http" + connectString.substring(schemeEndOffset);
      }

      URL connectUrl = new URL(sanitizedString);
      return connectUrl.getHost();
    } catch (MalformedURLException mue) {
      LOG.error("Malformed connect string URL: " + connectString
          + "; reason is " + mue.toString());
      return null;
    }
  }

  /**
   * @return the port from the connect string, or -1 if we can't.
   * 返回连接串对应的port
   */
  public static int getPort(String connectString) {
    try {
      String sanitizedString = null;
      int schemeEndOffset = connectString.indexOf("://");
      if (-1 == schemeEndOffset) {
        // Couldn't find one? ok, then there's no problem, it should work as a
        // URL.
        sanitizedString = connectString;
      } else {
        sanitizedString = "http" + connectString.substring(schemeEndOffset);
      }

      URL connectUrl = new URL(sanitizedString);
      return connectUrl.getPort();
    } catch (MalformedURLException mue) {
      LOG.error("Malformed connect string URL: " + connectString
          + "; reason is " + mue.toString());
      return -1;
    }
  }

}
