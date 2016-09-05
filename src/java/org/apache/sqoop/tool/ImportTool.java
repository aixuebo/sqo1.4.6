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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.List;
import java.util.Map;

import com.cloudera.sqoop.mapreduce.MergeJob;
import com.cloudera.sqoop.orm.TableClassName;
import com.cloudera.sqoop.util.ClassLoaderStack;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.util.StringUtils;

import com.cloudera.sqoop.Sqoop;
import com.cloudera.sqoop.SqoopOptions;
import com.cloudera.sqoop.SqoopOptions.InvalidOptionsException;
import com.cloudera.sqoop.cli.RelatedOptions;
import com.cloudera.sqoop.cli.ToolOptions;
import com.cloudera.sqoop.hive.HiveImport;
import com.cloudera.sqoop.manager.ImportJobContext;
import com.cloudera.sqoop.metastore.JobData;
import com.cloudera.sqoop.metastore.JobStorage;
import com.cloudera.sqoop.metastore.JobStorageFactory;
import com.cloudera.sqoop.util.AppendUtils;
import com.cloudera.sqoop.util.ImportException;

/**
 * Tool that performs database imports to HDFS.

 */
public class ImportTool extends com.cloudera.sqoop.tool.BaseSqoopTool {

  public static final Log LOG = LogFactory.getLog(ImportTool.class.getName());

  private CodeGenTool codeGenerator;

  // true if this is an all-tables import. Set by a subclass which
  // overrides the run() method of this tool (which can only do
  // a single table).
  private boolean allTables;

  // store check column type for incremental option
  //查询该table或者sql中属性与属性对应的类型映射关系
  private int checkColumnType;

  // Set classloader for local job runner
  private ClassLoader prevClassLoader = null;

  public ImportTool() {
    this("import", false);
  }

  public ImportTool(String toolName, boolean allTables) {
    super(toolName);
    this.codeGenerator = new CodeGenTool();
    this.allTables = allTables;
  }

  @Override
  protected boolean init(SqoopOptions sqoopOpts) {
    boolean ret = super.init(sqoopOpts);
    codeGenerator.setManager(manager);
    return ret;
  }

  /**
   * @return a list of jar files generated as part of this import process
   */
  public List<String> getGeneratedJarFiles() {
    return this.codeGenerator.getGeneratedJarFiles();
  }

  /**
   * If jars must be loaded into the local environment, do so here.
   */
  private void loadJars(Configuration conf, String ormJarFile,
                        String tableClassName) throws IOException {

    boolean isLocal = "local".equals(conf.get("mapreduce.jobtracker.address"))
        || "local".equals(conf.get("mapred.job.tracker"));
    if (isLocal) {
      // If we're using the LocalJobRunner, then instead of using the compiled
      // jar file as the job source, we're running in the current thread. Push
      // on another classloader that loads from that jar in addition to
      // everything currently on the classpath.
      this.prevClassLoader = ClassLoaderStack.addJarFile(ormJarFile,
          tableClassName);
    }
  }

  /**
   * If any classloader was invoked by loadJars, free it here.
   * 返回上一个classLoader
   */
  private void unloadJars() {
    if (null != this.prevClassLoader) {
      // unload the special classloader for this jar.
      ClassLoaderStack.setCurrentClassLoader(this.prevClassLoader);
    }
  }

  /**
   * @return true if the supplied options specify an incremental import.
   * true表示该导入是增量模式的导入
   */
  private boolean isIncremental(SqoopOptions options) {
    return !options.getIncrementalMode().equals(
        SqoopOptions.IncrementalMode.None);
  }

  /**
   * If this is an incremental import, then we should save the
   * user's state back to the metastore (if this job was run
   * from the metastore). Otherwise, log to the user what data
   * they need to supply next time.
   * 保存增量导入后的最新状态
   */
  private void saveIncrementalState(SqoopOptions options)
      throws IOException {
    if (!isIncremental(options)) {//说明不是增量导入,因此不需要保存增量状态
      return;
    }

    Map<String, String> descriptor = options.getStorageDescriptor();
    String jobName = options.getJobName();

    if (null != jobName && null != descriptor) {
      // Actually save it back to the metastore.
      LOG.info("Saving incremental import state to the metastore");
      JobStorageFactory ssf = new JobStorageFactory(options.getConf());
      JobStorage storage = ssf.getJobStorage(descriptor);
      storage.open(descriptor);
      try {
        // Save the 'parent' SqoopOptions; this does not contain the mutations
        // to the SqoopOptions state that occurred over the course of this
        // execution, except for the one we specifically want to memorize:
        // the latest value of the check column.
        JobData data = new JobData(options.getParent(), this);
        storage.update(jobName, data);
        LOG.info("Updated data for job: " + jobName);
      } finally {
        storage.close();
      }
    } else {
      // If there wasn't a parent SqoopOptions, then the incremental
      // state data was stored in the current SqoopOptions.
      LOG.info("Incremental import complete! To run another incremental "
          + "import of all data following this import, supply the "
          + "following arguments:");
      SqoopOptions.IncrementalMode incrementalMode =
          options.getIncrementalMode();
      switch (incrementalMode) {
      case AppendRows:
        LOG.info(" --incremental append");
        break;
      case DateLastModified:
        LOG.info(" --incremental lastmodified");
        break;
      default:
        LOG.warn("Undefined incremental mode: " + incrementalMode);
        break;
      }
      LOG.info("  --check-column " + options.getIncrementalTestColumn());//增量的列
      LOG.info("  --last-value " + options.getIncrementalLastValue());//增量的最后值
      LOG.info("(Consider saving this with 'sqoop job --create')");
    }
  }

  /**
   * Return the max value in the incremental-import test column. This
   * value must be numeric.
   *
   * 组织sql
   * select max(column) from table where xxx
   * 获取给定sql的最大的数据,该返回值就是一个值
   */
  private Object getMaxColumnId(SqoopOptions options) throws SQLException {
    StringBuilder sb = new StringBuilder();
    String query;

    sb.append("SELECT MAX(");
    sb.append(manager.escapeColName(options.getIncrementalTestColumn()));
    sb.append(") FROM ");

    if (options.getTableName() != null) {//存在表名
      // Table import
      sb.append(manager.escapeTableName(options.getTableName()));

      String where = options.getWhereClause();
      if (null != where) {
        sb.append(" WHERE ");
        sb.append(where);
      }
      query = sb.toString();
    } else {//就是一条纯粹的sql
      // Free form table based import
      sb.append("(");
      sb.append(options.getSqlQuery());
      sb.append(") sqoop_import_query_alias");

      query = sb.toString().replaceAll("\\$CONDITIONS", "(1 = 1)");
    }

    Connection conn = manager.getConnection();
    Statement s = null;
    ResultSet rs = null;
    try {
      LOG.info("Maximal id query for free form incremental import: " + query);
      s = conn.createStatement();
      rs = s.executeQuery(query);
      if (!rs.next()) {
        // This probably means the table is empty.
        LOG.warn("Unexpected: empty results for max value query?");
        return null;
      }

      ResultSetMetaData rsmd = rs.getMetaData();
      checkColumnType = rsmd.getColumnType(1);
      if (checkColumnType == Types.TIMESTAMP) {
        return rs.getTimestamp(1);
      } else if (checkColumnType == Types.DATE) {
        return rs.getDate(1);
      } else if (checkColumnType == Types.TIME) {
        return rs.getTime(1);
      } else {
        return rs.getObject(1);
      }
    } finally {
      try {
        if (null != rs) {
          rs.close();
        }
      } catch (SQLException sqlE) {
        LOG.warn("SQL Exception closing resultset: " + sqlE);
      }

      try {
        if (null != s) {
          s.close();
        }
      } catch (SQLException sqlE) {
        LOG.warn("SQL Exception closing statement: " + sqlE);
      }
    }
  }

  /**
   * Determine if a column is date/time.
   * @return true if column type is TIMESTAMP, DATE, or TIME.
   * true表示该属性是时间类型属性
   */
  private boolean isDateTimeColumn(int columnType) {
    return (columnType == Types.TIMESTAMP)
        || (columnType == Types.DATE)
        || (columnType == Types.TIME);
  }

    /**
   * Initialize the constraints which set the incremental import range.
   * @return false if an import is not necessary, because the dataset has not
   * changed.
   * 对增量的导入进行初始化操作,如果初始化失败,则返回false,停止导入
   * 过程中对增量的信息进行了初始化,比如将sql进行了初始化,只是查询增量部分的sql,同时查询最大值,将本次增量导入后到什么程度,写进参数里面
   */
  private boolean initIncrementalConstraints(SqoopOptions options,
      ImportJobContext context) throws ImportException, IOException {

    // If this is an incremental import, determine the constraints
    // to inject in the WHERE clause or $CONDITIONS for a query.
    // Also modify the 'last value' field of the SqoopOptions to
    // specify the current job start time / start row.
    if (!isIncremental(options)) {//false说明不是增量导入模式,因此直接返回true
      return true;
    }

    FileSystem fs = FileSystem.get(options.getConf());
    //增量导入模式,AppendRows 按照行导入,DateLastModified按照最后修改日期增量导入
    SqoopOptions.IncrementalMode incrementalMode = options.getIncrementalMode();
    String nextIncrementalValue = null;//目前该属性的最大值或者当前的时间字符串

    Object nextVal;
    switch (incrementalMode) {
    case AppendRows://按照行模式进行增量导入
      try {
        nextVal = getMaxColumnId(options);//返回该属性的最大值
        if (isDateTimeColumn(checkColumnType)) {//判断是否是时间类型
          nextIncrementalValue = (nextVal == null) ? null
            : manager.datetimeToQueryString(nextVal.toString(),
                                            checkColumnType);//将sql的时间类型的结果转换成字符串
        } else if (manager.isCharColumn(checkColumnType)) {
          throw new ImportException("Character column "
            + "(" + options.getIncrementalTestColumn() + ") can not be used "
            + "to determine which rows to incrementally import.");//不是整形和时间的,目前是不支持增量的
        } else {
          nextIncrementalValue = (nextVal == null) ? null : nextVal.toString();
        }
      } catch (SQLException sqlE) {
        throw new IOException(sqlE);
      }
      break;
    case DateLastModified://如果按照最后修改时间增量
      if (options.getMergeKeyCol() == null && !options.isAppendMode()
          && fs.exists(getOutputPath(options, context.getTableName(), false))) {
        throw new ImportException("--" + MERGE_KEY_ARG + " or " + "--" + APPEND_ARG
          + " is required when using --" + this.INCREMENT_TYPE_ARG
          + " lastmodified and the output directory exists.");
      }
      //查询该table或者sql中属性与属性对应的类型映射关系
      checkColumnType = manager.getColumnTypes(options.getTableName(),
        options.getSqlQuery()).get(options.getIncrementalTestColumn());
      nextVal = manager.getCurrentDbTimestamp();//获取当前数据库的时间戳
      if (null == nextVal) {
        throw new IOException("Could not get current time from database");
      }
      nextIncrementalValue = manager.datetimeToQueryString(nextVal.toString(),
          checkColumnType);
      break;
    default:
      throw new ImportException("Undefined incremental import type: "
          + incrementalMode);
    }

    // Build the WHERE clause components that are used to import
    // only this incremental section.
    StringBuilder sb = new StringBuilder();
    String prevEndpoint = options.getIncrementalLastValue();//上一次增量更新的属性值

      //该属性是时间类型属性,并且以前是存储了该值,并且存储的值没有用''包裹
    if (isDateTimeColumn(checkColumnType) && null != prevEndpoint
        && !prevEndpoint.startsWith("\'") && !prevEndpoint.endsWith("\'")) {
      // Incremental imports based on date/time should be 'quoted' in
      // ANSI SQL. If the user didn't specify single-quotes, put them
      // around, here.
      prevEndpoint = manager.datetimeToQueryString(prevEndpoint,
          checkColumnType);//对以前存储的时间值用''进行包裹起来
    }

    String checkColName = manager.escapeColName(
        options.getIncrementalTestColumn());//增量的列

      /**
       * 组装sql: column > prevEndpoint and  column < nextIncrementalValue AND $CONDITIONS
       * 如果有where条件,则 and (where参数)
       */
    LOG.info("Incremental import based on column " + checkColName);
    if (null != prevEndpoint) {//增量以前有值
      if (prevEndpoint.equals(nextIncrementalValue)) {//两个值相同,说明没有新数据
        LOG.info("No new rows detected since last import.");
        return false;
      }
      LOG.info("Lower bound value: " + prevEndpoint);
      sb.append(checkColName);
      switch (incrementalMode) {
      case AppendRows:
        sb.append(" > ");
        break;
      case DateLastModified:
        sb.append(" >= ");
        break;
      default:
        throw new ImportException("Undefined comparison");
      }
      sb.append(prevEndpoint);
      sb.append(" AND ");
    }

    if (null != nextIncrementalValue) {
      sb.append(checkColName);
      switch (incrementalMode) {
      case AppendRows:
        sb.append(" <= ");
        break;
      case DateLastModified:
        sb.append(" < ");
        break;
      default:
        throw new ImportException("Undefined comparison");
      }
      sb.append(nextIncrementalValue);
    } else {
      sb.append(checkColName);
      sb.append(" IS NULL ");
    }

    LOG.info("Upper bound value: " + nextIncrementalValue);

    if (options.getTableName() != null) {
      // Table based import
      //如果有where条件,则 and (where参数)
      String prevWhereClause = options.getWhereClause();
      if (null != prevWhereClause) {
        sb.append(" AND (");
        sb.append(prevWhereClause);
        sb.append(")");
      }

      String newConstraints = sb.toString();
      //将最终的where条件重新覆盖掉
      options.setWhereClause(newConstraints);
    } else {
      // Incremental based import
      sb.append(" AND $CONDITIONS");
      String newQuery = options.getSqlQuery().replace(
        "$CONDITIONS", sb.toString());
      options.setSqlQuery(newQuery);
    }
    // Save this state for next time.
    SqoopOptions recordOptions = options.getParent();
    if (null == recordOptions) {
      recordOptions = options;
    }

    //设置最后增量的值
    recordOptions.setIncrementalLastValue(
        (nextVal == null) ? null : nextVal.toString());

    return true;
  }

  /**
   * Merge HDFS output directories
   * 如果是按照update时间抓去的数据,则要对数据进行合并,因为说明此时是修改操作
   */
  protected void lastModifiedMerge(SqoopOptions options, ImportJobContext context) throws IOException {
    FileSystem fs = FileSystem.get(options.getConf());
    if (context.getDestination() != null && fs.exists(context.getDestination())) {//如果目标目录存在
      Path userDestDir = getOutputPath(options, context.getTableName(), false);//最终目录应该存储在哪里
      if (fs.exists(userDestDir)) {//如果最终目标存在,则要合并
        String tableClassName = null;
        if (!context.getConnManager().isORMFacilitySelfManaged()) {
          tableClassName =
              new TableClassName(options).getClassForTable(context.getTableName());
        }

        //调用merge合并job,去做合并操作
        Path destDir = getOutputPath(options, context.getTableName());
        options.setExistingJarName(context.getJarFile());//设置jar包
        options.setClassName(tableClassName);//设置执行主类
        options.setMergeOldPath(userDestDir.toString());//老的路径
        options.setMergeNewPath(context.getDestination().toString());//新的路径
        // Merge to temporary directory so that original directory remains intact.
        options.setTargetDir(destDir.toString());//目标路径

        // Local job tracker needs jars in the classpath.加载jar包
        loadJars(options.getConf(), context.getJarFile(), context.getTableName());

        //执行合并操作
        MergeJob mergeJob = new MergeJob(options);
        if (mergeJob.runMergeJob()) {
          // Rename destination directory to proper location.
          Path tmpDir = getOutputPath(options, context.getTableName());
          fs.rename(userDestDir, tmpDir);//将原有老的目录替换到temp目录下
          fs.rename(destDir, userDestDir);//替换最终新的目录
          fs.delete(tmpDir, true);//删除老的temp版本目录
        } else {
          LOG.error("Merge MapReduce job failed!");
        }

        unloadJars();
      } else {//如果最终目标不存在,则直接剪切就可以了,不需要合并
        fs.rename(context.getDestination(), userDestDir);
      }
    }
  }

  /**
   * Import a table or query.
   * @return true if an import was performed, false otherwise.
   */
  protected boolean importTable(SqoopOptions options, String tableName,
      HiveImport hiveImport) throws IOException, ImportException {
    String jarFile = null;

    // Generate the ORM code for the tables.
    jarFile = codeGenerator.generateORM(options, tableName);

      //获取输出目录
    Path outputPath = getOutputPath(options, tableName);

    // Do the actual import.做成导入的上下文对象
    ImportJobContext context = new ImportJobContext(tableName, jarFile,
        options, outputPath);

    // If we're doing an incremental import, set up the
    // filtering conditions used to get the latest records.
    //对增量的导入进行初始化操作,如果初始化失败,则返回false,停止导入
    //过程中对增量的信息进行了初始化,比如将sql进行了初始化,只是查询增量部分的sql,同时查询最大值,将本次增量导入后到什么程度,写进参数里面
    if (!initIncrementalConstraints(options, context)) {
      return false;
    }

    if (options.isDeleteMode()) {//先删除目录
      deleteTargetDir(context);
    }

    //查看是通过表名字导入 还是通过sql导入,已经导入到HDFS上了
    if (null != tableName) {
      manager.importTable(context);
    } else {
      manager.importQuery(context);
    }

    if (options.isAppendMode()) {
      AppendUtils app = new AppendUtils(context);
      app.append();//移动导入文件从临时目录到规定的目录中
    } else if (options.getIncrementalMode() == SqoopOptions.IncrementalMode.DateLastModified) {//如果是按照update时间抓去的数据,则要对数据进行合并,因为说明此时是修改操作
      lastModifiedMerge(options, context);
    }

    // If the user wants this table to be in Hive, perform that post-load.
    if (options.doHiveImport()) {//要把结果导入到hive中
      // For Parquet file, the import action will create hive table directly via
      // kite. So there is no need to do hive import as a post step again.
      if (options.getFileLayout() != SqoopOptions.FileLayout.ParquetFile) {
        hiveImport.importTable(tableName, options.getHiveTableName(), false);
      }
    }

    //保存此时的增量快照信息
    saveIncrementalState(options);

    return true;
  }

  //删除目录
  private void deleteTargetDir(ImportJobContext context) throws IOException {

    SqoopOptions options = context.getOptions();
    FileSystem fs = FileSystem.get(options.getConf());
    Path destDir = context.getDestination();

    if (fs.exists(destDir)) {
      fs.delete(destDir, true);
      LOG.info("Destination directory " + destDir + " deleted.");
      return;
    } else {
      LOG.info("Destination directory " + destDir + " is not present, "
        + "hence not deleting.");
    }
  }

  /**
   * @return the output path for the imported files;
   * in append mode this will point to a temporary folder.
   * if importing to hbase, this may return null.
   */
  private Path getOutputPath(SqoopOptions options, String tableName) {
    return getOutputPath(options, tableName, options.isAppendMode()
        || options.getIncrementalMode().equals(SqoopOptions.IncrementalMode.DateLastModified));
  }

  /**
   * @return the output path for the imported files;
   * if importing to hbase, this may return null.
   * 根据表名,获取输出目录
   */
  private Path getOutputPath(SqoopOptions options, String tableName, boolean temp) {
    // Get output directory
    String hdfsWarehouseDir = options.getWarehouseDir();//其次在该属性对应的路径下输出文件
    String hdfsTargetDir = options.getTargetDir();//优先在该属性输出目录
    Path outputPath = null;
    if (temp) {
      // Use temporary path, later removed when appending
      String salt = tableName;//设置临时结果存储目录
      if(salt == null && options.getSqlQuery() != null) {
        salt = Integer.toHexString(options.getSqlQuery().hashCode());
      }
      outputPath = AppendUtils.getTempAppendDir(salt);
      LOG.debug("Using temporary folder: " + outputPath.getName());
    } else {
      // Try in this order: target-dir or warehouse-dir
      if (hdfsTargetDir != null) {
        outputPath = new Path(hdfsTargetDir);
      } else if (hdfsWarehouseDir != null) {
        outputPath = new Path(hdfsWarehouseDir, tableName);
      } else if (null != tableName) {
        outputPath = new Path(tableName);
      }
    }
    return outputPath;
  }

  @Override
  /** {@inheritDoc} */
  public int run(SqoopOptions options) {
    HiveImport hiveImport = null;

    if (allTables) {
      // We got into this method, but we should be in a subclass.
      // (This method only handles a single table)
      // This should not be reached, but for sanity's sake, test here.
      LOG.error("ImportTool.run() can only handle a single table.");
      return 1;
    }

    if (!init(options)) {
      return 1;
    }

    codeGenerator.setManager(manager);

    try {
      if (options.doHiveImport()) {
        hiveImport = new HiveImport(options, manager, options.getConf(), false);
      }

      // Import a single table (or query) the user specified.
      importTable(options, options.getTableName(), hiveImport);
    } catch (IllegalArgumentException iea) {
        LOG.error("Imported Failed: " + iea.getMessage());
        if (System.getProperty(Sqoop.SQOOP_RETHROW_PROPERTY) != null) {
          throw iea;
        }
        return 1;
    } catch (IOException ioe) {
      LOG.error("Encountered IOException running import job: "
          + StringUtils.stringifyException(ioe));
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

  /**
   * Construct the set of options that control imports, either of one
   * table or a batch of tables.
   * @return the RelatedOptions that can be used to parse the import
   * arguments.
   *
   */
  @SuppressWarnings("static-access")
  protected RelatedOptions getImportOptions() {
    // Imports
    RelatedOptions importOpts = new RelatedOptions("Import control arguments");

    importOpts.addOption(OptionBuilder
        .withDescription("Use direct import fast path")
        .withLongOpt(DIRECT_ARG)
        .create());//是否使用类似mysql的快速直接导入功能

    if (!allTables) {
      importOpts.addOption(OptionBuilder.withArgName("table-name")
          .hasArg().withDescription("Table to read")
          .withLongOpt(TABLE_ARG)
          .create());//导入什么表
      importOpts.addOption(OptionBuilder.withArgName("col,col,col...")
          .hasArg().withDescription("Columns to import from table")
          .withLongOpt(COLUMNS_ARG)
          .create());//导入该表的哪些列
      importOpts.addOption(OptionBuilder.withArgName("column-name")
          .hasArg()
          .withDescription("Column of the table used to split work units")
          .withLongOpt(SPLIT_BY_ARG)//按照什么列进行拆分map任务,默认是按照主键拆分
          .create());
      importOpts.addOption(OptionBuilder.withArgName("where clause")
          .hasArg().withDescription("WHERE clause to use during import")
          .withLongOpt(WHERE_ARG) //where查询条件
          .create());
      importOpts.addOption(OptionBuilder
          .withDescription("Imports data in append mode")
          .withLongOpt(APPEND_ARG)
          .create());//增量导入的追加模式
      importOpts.addOption(OptionBuilder
          .withDescription("Imports data in delete mode")
          .withLongOpt(DELETE_ARG)
          .create());//是否删除目标数据
      importOpts.addOption(OptionBuilder.withArgName("dir")
          .hasArg().withDescription("HDFS plain table destination")
          .withLongOpt(TARGET_DIR_ARG)
          .create());//存储在hdfs上哪里
      importOpts.addOption(OptionBuilder.withArgName("statement")
          .hasArg()
          .withDescription("Import results of SQL 'statement'")
          .withLongOpt(SQL_QUERY_ARG)//导入的sql
          .create(SQL_QUERY_SHORT_ARG));//导入的sql缩写命令
      importOpts.addOption(OptionBuilder.withArgName("statement")
          .hasArg()
          .withDescription("Set boundary query for retrieving max and min"
              + " value of the primary key")
          .withLongOpt(SQL_QUERY_BOUNDARY) //如果是根据sql导入的,则要设置查询边界sql或者设置SplitColumn,如果map=1,则必须要设置查询边界,如果设置多个map,必须要有split拆分列, 查询边界demo:select min(<split-by>), max(<split-by>) from <table name>
          .create());
      importOpts.addOption(OptionBuilder.withArgName("column")
          .hasArg().withDescription("Key column to use to join results")
          .withLongOpt(MERGE_KEY_ARG)//根据哪个属性进行合并
          .create());

      addValidationOpts(importOpts);
    }

    importOpts.addOption(OptionBuilder.withArgName("dir")
        .hasArg().withDescription("HDFS parent for table destination")
        .withLongOpt(WAREHOUSE_DIR_ARG) //导入HDFS哪个父目录下
        .create());
    importOpts.addOption(OptionBuilder
        .withDescription("Imports data to SequenceFiles")
        .withLongOpt(FMT_SEQUENCEFILE_ARG) //导入数据最后是序列化文件
        .create());
    importOpts.addOption(OptionBuilder
        .withDescription("Imports data as plain text (default)")
        .withLongOpt(FMT_TEXTFILE_ARG) //导入数据最后是text文件
        .create());
    importOpts.addOption(OptionBuilder
        .withDescription("Imports data to Avro data files")
        .withLongOpt(FMT_AVRODATAFILE_ARG) //导入数据最后是avro文件
        .create());
    importOpts.addOption(OptionBuilder
        .withDescription("Imports data to Parquet files")
        .withLongOpt(BaseSqoopTool.FMT_PARQUETFILE_ARG) //导入数据最后是Parquet文件
        .create());
    importOpts.addOption(OptionBuilder.withArgName("n")
        .hasArg().withDescription("Use 'n' map tasks to import in parallel")
        .withLongOpt(NUM_MAPPERS_ARG)//多少个map任务去执行该job
        .create(NUM_MAPPERS_SHORT_ARG));//多少个map任务去执行该job
    importOpts.addOption(OptionBuilder.withArgName("name")
        .hasArg().withDescription("Set name for generated mapreduce job")
        .withLongOpt(MAPREDUCE_JOB_NAME)//该job的name
        .create());
    importOpts.addOption(OptionBuilder
        .withDescription("Enable compression")
        .withLongOpt(COMPRESS_ARG) //是否支持压缩
        .create(COMPRESS_SHORT_ARG));
    importOpts.addOption(OptionBuilder.withArgName("codec")
        .hasArg()
        .withDescription("Compression codec to use for import")
        .withLongOpt(COMPRESSION_CODEC_ARG) //压缩方式
        .create());
    importOpts.addOption(OptionBuilder.withArgName("n")
        .hasArg()
        .withDescription("Split the input stream every 'n' bytes "
        + "when importing in direct mode")
        .withLongOpt(DIRECT_SPLIT_SIZE_ARG) //当direct模式进行导入的时候,每多少个字节进行拆分一次,单位是字节
        .create());
    importOpts.addOption(OptionBuilder.withArgName("n")
        .hasArg()
        .withDescription("Set the maximum size for an inline LOB")
        .withLongOpt(INLINE_LOB_LIMIT_ARG)
        .create());
    importOpts.addOption(OptionBuilder.withArgName("n")
        .hasArg()
        .withDescription("Set number 'n' of rows to fetch from the "
        + "database when more rows are needed")
        .withLongOpt(FETCH_SIZE_ARG)//设置 statement.setFetchSize(fetchSize);
        .create());
    importOpts.addOption(OptionBuilder.withArgName("reset-mappers")
      .withDescription("Reset the number of mappers to one mapper if no split key available")
      .withLongOpt(AUTORESET_TO_ONE_MAPPER)//true表示重新设置map的数量,当没有拆分列的时候,不能被拆分了,则如果该属性为true,可以将map设置为1个
      .create());
    return importOpts;
  }

  /**
   * Return options for incremental import.
   * 增量导入cli
   */
  protected RelatedOptions getIncrementalOptions() {
    RelatedOptions incrementalOpts =
        new RelatedOptions("Incremental import arguments");

    incrementalOpts.addOption(OptionBuilder.withArgName("import-type")
        .hasArg()
        .withDescription(
        "Define an incremental import of type 'append' or 'lastmodified'")
        .withLongOpt(INCREMENT_TYPE_ARG) //append' or 'lastmodified 增量导入类型
        .create());
    incrementalOpts.addOption(OptionBuilder.withArgName("column")
        .hasArg()
        .withDescription("Source column to check for incremental change")
        .withLongOpt(INCREMENT_COL_ARG) //在什么属性上进行增量处理
        .create());
    incrementalOpts.addOption(OptionBuilder.withArgName("value")
        .hasArg()
        .withDescription("Last imported value in the incremental check column")
        .withLongOpt(INCREMENT_LAST_VAL_ARG) //记录增量最后一个值
        .create());

    return incrementalOpts;
  }

  @Override
  /** Configure the command-line arguments we expect to receive */
  public void configureOptions(ToolOptions toolOptions) {

    toolOptions.addUniqueOptions(getCommonOptions());//设置公共的配置信息
    toolOptions.addUniqueOptions(getImportOptions());//设置import导入的配置信息
    if (!allTables) {
      toolOptions.addUniqueOptions(getIncrementalOptions());//设置增量的导入信息
    }
    toolOptions.addUniqueOptions(getOutputFormatOptions());
    toolOptions.addUniqueOptions(getInputFormatOptions());
    toolOptions.addUniqueOptions(getHiveOptions(true));
    toolOptions.addUniqueOptions(getHBaseOptions());
    toolOptions.addUniqueOptions(getHCatalogOptions());
    toolOptions.addUniqueOptions(getHCatImportOnlyOptions());
    toolOptions.addUniqueOptions(getAccumuloOptions());

    // get common codegen opts.
    RelatedOptions codeGenOpts = getCodeGenOpts(allTables);

    // add import-specific codegen opts:
    codeGenOpts.addOption(OptionBuilder.withArgName("file")
        .hasArg()
        .withDescription("Disable code generation; use specified jar")
        .withLongOpt(JAR_FILE_NAME_ARG)
        .create());

    toolOptions.addUniqueOptions(codeGenOpts);
  }

  @Override
  /** {@inheritDoc} */
  public void printHelp(ToolOptions toolOptions) {
    super.printHelp(toolOptions);
    System.out.println("");
    if (allTables) {
      System.out.println("At minimum, you must specify --connect");
    } else {
      System.out.println(
        "At minimum, you must specify --connect and --table");
    }

    System.out.println(
        "Arguments to mysqldump and other subprograms may be supplied");
    System.out.println(
        "after a '--' on the command line.");
  }

  private void applyIncrementalOptions(CommandLine in, SqoopOptions out)
      throws InvalidOptionsException  {
    if (in.hasOption(INCREMENT_TYPE_ARG)) {//是否有增量配置
      String incrementalTypeStr = in.getOptionValue(INCREMENT_TYPE_ARG);//增量类型
      if ("append".equals(incrementalTypeStr)) {
        out.setIncrementalMode(SqoopOptions.IncrementalMode.AppendRows);
        // This argument implies ability to append to the same directory.
        out.setAppendMode(true);
      } else if ("lastmodified".equals(incrementalTypeStr)) {
        out.setIncrementalMode(SqoopOptions.IncrementalMode.DateLastModified);
      } else {
        throw new InvalidOptionsException("Unknown incremental import mode: "
            + incrementalTypeStr + ". Use 'append' or 'lastmodified'."
            + HELP_STR);
      }
    }

      //设置增量列
    if (in.hasOption(INCREMENT_COL_ARG)) {
      out.setIncrementalTestColumn(in.getOptionValue(INCREMENT_COL_ARG));
    }

      //设置增量属性的value值
    if (in.hasOption(INCREMENT_LAST_VAL_ARG)) {
      out.setIncrementalLastValue(in.getOptionValue(INCREMENT_LAST_VAL_ARG));
    }
  }

  @Override
  /** {@inheritDoc} */
  public void applyOptions(CommandLine in, SqoopOptions out)
      throws InvalidOptionsException {

    try {
      applyCommonOptions(in, out);

      if (in.hasOption(DIRECT_ARG)) {
        out.setDirectMode(true);
      }

      if (!allTables) {
        if (in.hasOption(TABLE_ARG)) {
          out.setTableName(in.getOptionValue(TABLE_ARG));
        }

        if (in.hasOption(COLUMNS_ARG)) {//columns参数 按照逗号拆分的集合
          String[] cols= in.getOptionValue(COLUMNS_ARG).split(",");
          for (int i=0; i<cols.length; i++) {
            cols[i] = cols[i].trim();
          }
          out.setColumns(cols);
        }

        if (in.hasOption(SPLIT_BY_ARG)) {
          out.setSplitByCol(in.getOptionValue(SPLIT_BY_ARG));
        }

        if (in.hasOption(WHERE_ARG)) {
          out.setWhereClause(in.getOptionValue(WHERE_ARG));
        }

        if (in.hasOption(TARGET_DIR_ARG)) {//target-dir参数内容
          out.setTargetDir(in.getOptionValue(TARGET_DIR_ARG));
        }

        if (in.hasOption(APPEND_ARG)) {
          out.setAppendMode(true);
        }

        if (in.hasOption(DELETE_ARG)) {
          out.setDeleteMode(true);
        }

        if (in.hasOption(SQL_QUERY_ARG)) { //query
          out.setSqlQuery(in.getOptionValue(SQL_QUERY_ARG));
        }

        if (in.hasOption(SQL_QUERY_BOUNDARY)) {
          out.setBoundaryQuery(in.getOptionValue(SQL_QUERY_BOUNDARY));
        }

        if (in.hasOption(MERGE_KEY_ARG)) {
          out.setMergeKeyCol(in.getOptionValue(MERGE_KEY_ARG));
        }

        applyValidationOptions(in, out);
      }

      if (in.hasOption(WAREHOUSE_DIR_ARG)) {//warehouse-dir参数内容
        out.setWarehouseDir(in.getOptionValue(WAREHOUSE_DIR_ARG));
      }

      if (in.hasOption(FMT_SEQUENCEFILE_ARG)) {
        out.setFileLayout(SqoopOptions.FileLayout.SequenceFile);
      }

      if (in.hasOption(FMT_TEXTFILE_ARG)) {
        out.setFileLayout(SqoopOptions.FileLayout.TextFile);
      }

      if (in.hasOption(FMT_AVRODATAFILE_ARG)) {
        out.setFileLayout(SqoopOptions.FileLayout.AvroDataFile);
      }

      if (in.hasOption(FMT_PARQUETFILE_ARG)) {
        out.setFileLayout(SqoopOptions.FileLayout.ParquetFile);
      }

      if (in.hasOption(NUM_MAPPERS_ARG)) {
        out.setNumMappers(Integer.parseInt(in.getOptionValue(NUM_MAPPERS_ARG)));
      }

      if (in.hasOption(MAPREDUCE_JOB_NAME)) {
        out.setMapreduceJobName(in.getOptionValue(MAPREDUCE_JOB_NAME));
      }

      if (in.hasOption(COMPRESS_ARG)) {
        out.setUseCompression(true);
      }

      if (in.hasOption(COMPRESSION_CODEC_ARG)) {//参数compression-codec的内容
        out.setCompressionCodec(in.getOptionValue(COMPRESSION_CODEC_ARG));
      }

      if (in.hasOption(DIRECT_SPLIT_SIZE_ARG)) {
        out.setDirectSplitSize(Long.parseLong(in.getOptionValue(
            DIRECT_SPLIT_SIZE_ARG)));
      }

      if (in.hasOption(INLINE_LOB_LIMIT_ARG)) {
        out.setInlineLobLimit(Long.parseLong(in.getOptionValue(
            INLINE_LOB_LIMIT_ARG)));
      }

      if (in.hasOption(FETCH_SIZE_ARG)) {
        out.setFetchSize(new Integer(in.getOptionValue(FETCH_SIZE_ARG)));
      }

      if (in.hasOption(JAR_FILE_NAME_ARG)) {
        out.setExistingJarName(in.getOptionValue(JAR_FILE_NAME_ARG));
      }

      if (in.hasOption(AUTORESET_TO_ONE_MAPPER)) {
        out.setAutoResetToOneMapper(true);
      }

      applyIncrementalOptions(in, out);
      applyHiveOptions(in, out);
      applyOutputFormatOptions(in, out);
      applyInputFormatOptions(in, out);
      applyCodeGenOptions(in, out, allTables);
      applyHBaseOptions(in, out);
      applyHCatalogOptions(in, out);
      applyAccumuloOptions(in, out);

    } catch (NumberFormatException nfe) {
      throw new InvalidOptionsException("Error: expected numeric argument.\n"
          + "Try --help for usage.");
    }
  }

  /**
   * Validate import-specific arguments.
   * @param options the configured SqoopOptions to check
   */
  protected void validateImportOptions(SqoopOptions options)
      throws InvalidOptionsException {
    if (!allTables && options.getTableName() == null
        && options.getSqlQuery() == null) {
      throw new InvalidOptionsException(
          "--table or --" + SQL_QUERY_ARG + " is required for import. "
          + "(Or use sqoop import-all-tables.)"
          + HELP_STR);
    } else if (options.getExistingJarName() != null
        && options.getClassName() == null) {
      throw new InvalidOptionsException("Jar specified with --jar-file, but no "
          + "class specified with --class-name." + HELP_STR);
    } else if (options.getTargetDir() != null
        && options.getWarehouseDir() != null) {
      throw new InvalidOptionsException(
          "--target-dir with --warehouse-dir are incompatible options."
          + HELP_STR);
    } else if (options.getTableName() != null
        && options.getSqlQuery() != null) {
      throw new InvalidOptionsException(
          "Cannot specify --" + SQL_QUERY_ARG + " and --table together."
          + HELP_STR);
    } else if (options.getSqlQuery() != null
        && options.getTargetDir() == null
        && options.getHBaseTable() == null
        && options.getHCatTableName() == null
        && options.getAccumuloTable() == null) {
      throw new InvalidOptionsException(
          "Must specify destination with --target-dir. "
          + HELP_STR);
    } else if (options.getSqlQuery() != null && options.doHiveImport()
        && options.getHiveTableName() == null) {
      throw new InvalidOptionsException(
          "When importing a query to Hive, you must specify --"
          + HIVE_TABLE_ARG + "." + HELP_STR);
    } else if (options.getSqlQuery() != null && options.getNumMappers() > 1
        && options.getSplitByCol() == null) {
      throw new InvalidOptionsException(
          "When importing query results in parallel, you must specify --"
          + SPLIT_BY_ARG + "." + HELP_STR);
    } else if (options.isDirect()
            && options.getFileLayout() != SqoopOptions.FileLayout.TextFile
            && options.getConnectString().contains("jdbc:mysql://")) {
      throw new InvalidOptionsException(
            "MySQL direct import currently supports only text output format. "
             + "Parameters --as-sequencefile --as-avrodatafile and --as-parquetfile are not "
             + "supported with --direct params in MySQL case.");
    } else if (options.isDirect()
            && options.doHiveDropDelims()) {
      throw new InvalidOptionsException(
            "Direct import currently do not support dropping hive delimiters,"
            + " please remove parameter --hive-drop-import-delims.");
    } else if (allTables && options.isValidationEnabled()) {
      throw new InvalidOptionsException("Validation is not supported for "
            + "all tables but single table only.");
    } else if (options.getSqlQuery() != null && options.isValidationEnabled()) {
      throw new InvalidOptionsException("Validation is not supported for "
            + "free from query but single table only.");
    } else if (options.getWhereClause() != null
            && options.isValidationEnabled()) {
      throw new InvalidOptionsException("Validation is not supported for "
            + "where clause but single table only.");
    } else if (options.getIncrementalMode()
        != SqoopOptions.IncrementalMode.None && options.isValidationEnabled()) {
      throw new InvalidOptionsException("Validation is not supported for "
        + "incremental imports but single table only.");
    } else if ((options.getTargetDir() != null
      || options.getWarehouseDir() != null)
      && options.getHCatTableName() != null) {
      throw new InvalidOptionsException("--hcatalog-table cannot be used "
        + " --warehouse-dir or --target-dir options");
    } else if (options.isDeleteMode() && options.isAppendMode()) {
       throw new InvalidOptionsException("--append and --delete-target-dir can"
         + " not be used together.");
    } else if (options.isDeleteMode() && options.getIncrementalMode()
         != SqoopOptions.IncrementalMode.None) {
       throw new InvalidOptionsException("--delete-target-dir can not be used"
         + " with incremental imports.");
    } else if (options.getAutoResetToOneMapper()
        && (options.getSplitByCol() != null)) {
        throw new InvalidOptionsException("--autoreset-to-one-mapper and"
          + " --split-by cannot be used together.");
    }
  }

  /**
   * Validate the incremental import options.
   */
  private void validateIncrementalOptions(SqoopOptions options)
      throws InvalidOptionsException {
    if (options.getIncrementalMode() != SqoopOptions.IncrementalMode.None
        && options.getIncrementalTestColumn() == null) {
      throw new InvalidOptionsException(
          "For an incremental import, the check column must be specified "
          + "with --" + INCREMENT_COL_ARG + ". " + HELP_STR);
    }

    if (options.getIncrementalMode() == SqoopOptions.IncrementalMode.None
        && options.getIncrementalTestColumn() != null) {
      throw new InvalidOptionsException(
          "You must specify an incremental import mode with --"
          + INCREMENT_TYPE_ARG + ". " + HELP_STR);
    }

    if (options.getIncrementalMode() == SqoopOptions.IncrementalMode.DateLastModified
        && options.getFileLayout() == SqoopOptions.FileLayout.AvroDataFile) {
      throw new InvalidOptionsException("--"
          + INCREMENT_TYPE_ARG + " lastmodified cannot be used in conjunction with --"
          + FMT_AVRODATAFILE_ARG + "." + HELP_STR);
    }
  }

  @Override
  /** {@inheritDoc} */
  public void validateOptions(SqoopOptions options)
      throws InvalidOptionsException {

    // If extraArguments is full, check for '--' followed by args for
    // mysqldump or other commands we rely on.
    options.setExtraArgs(getSubcommandArgs(extraArguments));
    int dashPos = getDashPosition(extraArguments);

    if (hasUnrecognizedArgs(extraArguments, 0, dashPos)) {
      throw new InvalidOptionsException(HELP_STR);
    }

    validateImportOptions(options);
    validateIncrementalOptions(options);
    validateCommonOptions(options);
    validateCodeGenOptions(options);
    validateOutputFormatOptions(options);
    validateHBaseOptions(options);
    validateHiveOptions(options);
    validateHCatalogOptions(options);
    validateAccumuloOptions(options);
  }
}

