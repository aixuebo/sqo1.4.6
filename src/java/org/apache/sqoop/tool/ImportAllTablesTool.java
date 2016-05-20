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

package org.apache.sqoop.tool;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cloudera.sqoop.Sqoop;
import com.cloudera.sqoop.SqoopOptions;
import com.cloudera.sqoop.SqoopOptions.InvalidOptionsException;
import com.cloudera.sqoop.cli.RelatedOptions;
import com.cloudera.sqoop.hive.HiveImport;
import com.cloudera.sqoop.util.ImportException;

/**
 * Tool that performs database imports of all tables in a database to HDFS.
 * 导出一个数据库的全部表到HDFS上
 * 其实就是一个table,一个table的调用ImportTool方法即可,只是可以设置一个排他table集合,用逗号拆分而已
 */
public class ImportAllTablesTool extends com.cloudera.sqoop.tool.ImportTool {

  public static final Log LOG = LogFactory.getLog(
      ImportAllTablesTool.class.getName());

  //命令是import-all-tables
  public ImportAllTablesTool() {
    super("import-all-tables", true);
  }

  @Override
  @SuppressWarnings("static-access")
  /** {@inheritDoc} */
  protected RelatedOptions getImportOptions() {
    // Imports
    RelatedOptions importOpts = super.getImportOptions();

    importOpts.addOption(OptionBuilder.withArgName("tables")
        .hasArg().withDescription("Tables to exclude when importing all tables")
        .withLongOpt(ALL_TABLE_EXCLUDES_ARG)//将一个数据库所有表都导入的时候,要排除一些表的时候使用该字段,table用逗号拆分
        .create());

    return importOpts;
  }

  @Override
  /** {@inheritDoc} */
  public void applyOptions(CommandLine in, SqoopOptions out)
      throws InvalidOptionsException {
    super.applyOptions(in, out);

    if (in.hasOption(ALL_TABLE_EXCLUDES_ARG)) {
      out.setAllTablesExclude(in.getOptionValue(ALL_TABLE_EXCLUDES_ARG));
    }
  }

  @Override
  /** {@inheritDoc} */
  public int run(SqoopOptions options) {
    HiveImport hiveImport = null;
    Set<String> excludes = new HashSet<String>();

    if (!init(options)) {
      return 1;
    }

    try {
      if (options.doHiveImport()) {
        hiveImport = new HiveImport(options, manager, options.getConf(), false);
      }

      if (options.getAllTablesExclude() != null) {//解析要排除的table集合
        excludes.addAll(Arrays.asList(options.getAllTablesExclude().split(",")));
      }

      String [] tables = manager.listTables();//获取该数据库的所有table
      if (null == tables) {
        System.err.println("Could not retrieve tables list from server");
        LOG.error("manager.listTables() returned null");
        return 1;
      } else {
        int numMappers = options.getNumMappers();//mapper数量
        for (String tableName : tables) {
          if (excludes.contains(tableName)) {//跳过该表,不进行导入
            System.out.println("Skipping table: " + tableName);
          } else {
            /*
             * Number of mappers could be potentially reset in imports.  So
             * we set it to the configured number before each import.
             */
            options.setNumMappers(numMappers);//对表进行导入
            importTable(options, tableName, hiveImport);
          }
        }
      }
    } catch (IOException ioe) {
      LOG.error("Encountered IOException running import job: "
          + ioe.toString());
      if (System.getProperty(Sqoop.SQOOP_RETHROW_PROPERTY) != null) {
        throw new RuntimeException(ioe);
      } else {
        return 1;
      }
    } catch (ImportException ie) {
      LOG.error("Error during import: " + ie.toString());
      if (System.getProperty(Sqoop.SQOOP_RETHROW_PROPERTY) != null) {
        throw new RuntimeException(ie);
      } else {
        return 1;
      }
    } finally {
      destroy(options);
    }

    return 0;
  }

}


