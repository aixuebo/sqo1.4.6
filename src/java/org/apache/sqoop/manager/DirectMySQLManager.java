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

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.cloudera.sqoop.SqoopOptions;
import com.cloudera.sqoop.mapreduce.MySQLDumpImportJob;
import com.cloudera.sqoop.mapreduce.MySQLExportJob;
import com.cloudera.sqoop.util.ImportException;
import com.cloudera.sqoop.util.ExportException;

/**
 * Manages direct connections to MySQL databases
 * so we can use mysqldump to get really fast dumps.
 * 利用mysql的直接导出功能,进行导出数据,这个方式速度更快
 */
public class DirectMySQLManager
    extends com.cloudera.sqoop.manager.MySQLManager {

  public static final Log LOG = LogFactory.getLog(
      DirectMySQLManager.class.getName());

  public DirectMySQLManager(final SqoopOptions options) {
    super(options);
  }

  /**
   * Import the table into HDFS by using mysqldump to pull out the data from
   * the database and upload the files directly to HDFS.
   * 使用mysqldump命令拉去数据到HDFS上
   */
  @Override
  public void importTable(com.cloudera.sqoop.manager.ImportJobContext context)
      throws IOException, ImportException {
      context.setConnManager(this);
    if (context.getOptions().getColumns() != null) {//使用mysqldump命令导入是不支持属性的,因此只能用默认的导出方式,不能使用mysqldump命令了,因此打印了一个提示信息
      LOG.warn("Direct-mode import from MySQL does not support column");
      LOG.warn("selection. Falling back to JDBC-based import.");
      // Don't warn them "This could go faster..."
      MySQLManager.markWarningPrinted();
      // Use JDBC-based importTable() method.
      super.importTable(context);
      return;
    }
    //使用mysqldump命令逻辑
    String tableName = context.getTableName();
    String jarFile = context.getJarFile();
    SqoopOptions options = context.getOptions();

    //使用mysql的dump命令进行数据导出
    MySQLDumpImportJob importer = null;
    try {
      importer = new MySQLDumpImportJob(options, context);
    } catch (ClassNotFoundException cnfe) {
      throw new IOException("Could not load required classes", cnfe);
    }

    //导出的拆分属性
    String splitCol = getSplitColumn(options, tableName);
    if (null == splitCol && options.getNumMappers() > 1) {//如果map数量大于1,又没有拆分属性,则抛异常
      // Can't infer a primary key.
      throw new ImportException("No primary key could be found for table "
          + tableName + ". Please specify one with --split-by or perform "
          + "a sequential import with '-m 1'.");
    }

    //开始执行mysql dump导出
    LOG.info("Beginning mysqldump fast path import");

    if (options.getFileLayout() != SqoopOptions.FileLayout.TextFile) {//只支持文本导出,不支持其他可是导出
      // TODO(aaron): Support SequenceFile-based load-in.
      LOG.warn("File import layout " + options.getFileLayout()
          + " is not supported by");
      LOG.warn("MySQL direct import; import will proceed as text files.");
    }

    importer.runImport(tableName, jarFile, splitCol, options.getConf());
  }

  /**
   * Export the table from HDFS by using mysqlimport to insert the data
   * back into the database.
   * 使用mysqlimport方式向数据库写入数据
   */
  @Override
  public void exportTable(com.cloudera.sqoop.manager.ExportJobContext context)
      throws IOException, ExportException {
    context.setConnManager(this);
    MySQLExportJob exportJob = new MySQLExportJob(context);
    exportJob.runExport();
  }

  public void upsertTable(com.cloudera.sqoop.manager.ExportJobContext context)
      throws IOException, ExportException {
    throw new ExportException("MySQL direct connector does not support upsert"
      + " mode. Please use JDBC based connector (remove --direct parameter)");
  }

  @Override
  public boolean supportsStagingForExport() {
    return false;
  }
}

