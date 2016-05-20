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

import org.apache.hadoop.conf.Configuration;
import org.apache.sqoop.util.Jars;

import com.cloudera.sqoop.SqoopOptions;

/**
 * A set of parameters describing an export operation; this is passed to
 * ConnManager.exportTable() as its argument.
 *
 * export导出到数据库的任务上下文
 */
public class ExportJobContext {

  private String tableName;//导出到哪个表中
  private String jarFile;//执行的jar包
  private SqoopOptions options;
  private ConnManager manager;//数据库连接器

  public ExportJobContext(final String table, final String jar,
      final SqoopOptions opts) {
    this.tableName = table;
    this.jarFile = jar;
    if (this.jarFile == null) {
      // Set the jarFile to the hadoop core jar file.
      this.jarFile = Jars.getJarPathForClass(Configuration.class);
    }
    this.options = opts;
  }

  /** @return the name of the table to export. */
  public String getTableName() {
    return tableName;
  }

  /** @return the name of the jar file containing the user's compiled
   * ORM classes to use during the export.
   */
  public String getJarFile() {
    return jarFile;
  }

  /** @return the SqoopOptions configured by the user */
  public SqoopOptions getOptions() {
    return options;
  }

  /**
   * Set the ConnManager instance to be used during the export's
   * configuration.
   */
  public void setConnManager(ConnManager mgr) {
    this.manager = mgr;
  }

  /**
   * Get the ConnManager instance to use during an export's
   * configuration stage.
   */
  public ConnManager getConnManager() {
    return this.manager;
  }

}

