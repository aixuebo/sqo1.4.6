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

import java.io.IOException;
import java.text.NumberFormat;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import com.cloudera.sqoop.manager.ImportJobContext;
import com.cloudera.sqoop.SqoopOptions;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Utilities used when appending imported files to an existing dir.
 */
public class AppendUtils {

  public static final Log LOG = LogFactory.getLog(AppendUtils.class.getName());

  private static final String TEMP_IMPORT_ROOT =
          System.getProperty("sqoop.test.import.rootDir", "_sqoop");//导出的临时目录

  private static final int PARTITION_DIGITS = 5;
  private static final String FILEPART_SEPARATOR = "-";
  private static final String FILEEXT_SEPARATOR = ".";

  //匹配part开头的文件
  private static final Pattern DATA_PART_PATTERN = Pattern.compile("part.*-([0-9]{" + PARTITION_DIGITS + "}+).*");

  private ImportJobContext context = null;

  //导入job的上下文对象
  public AppendUtils(ImportJobContext context) {
    this.context = context;
  }

  /**
   * Moves the imported files from temporary directory to specified target-dir,
   * renaming partition number if appending file exists.
   * 移动导入文件从临时目录到规定的目录中
   */
  public void append() throws IOException {

    SqoopOptions options = context.getOptions();
    Path tempDir = context.getDestination();//目标目录,目标目录就是临时目录

    // Try in this order: target-dir or warehouse-dir
    //按照顺序,确定输出目录是什么
    Path userDestDir = null;
    if (options.getTargetDir() != null) {
      userDestDir = new Path(options.getTargetDir());
    } else if (options.getWarehouseDir() != null) {
      userDestDir = new Path(options.getWarehouseDir(),
          context.getTableName());
    } else {
      userDestDir = new Path(context.getTableName());
    }
    FileSystem fs = userDestDir.getFileSystem(options.getConf());

    int nextPartition = 0;

    if (!fs.exists(tempDir)) {//如果临时目录不存在,则说明有异常,因此return
      // This occurs if there was no source (tmp) dir. This might happen
      // if the import was an HBase-target import, but the user specified
      // --append anyway. This is a warning, not an error.
      LOG.warn("Cannot append files to target dir; no such directory: "
          + tempDir);
      return;
    }

    // Create target directory.
    if (!fs.exists(userDestDir)) {//如果目标目录不存在,则创建该目录
      LOG.info("Creating missing output directory - " + userDestDir.getName());
      fs.mkdirs(userDestDir);
      nextPartition = 0;
    } else {//如果目标目录存在,则在目标目录下建立数字的子目录,存放新追加的数据
      LOG.info("Appending to directory " + userDestDir.getName());
      // Get the right next partition for the imported files
      nextPartition = getNextPartition(fs, userDestDir);
    }

    // move files 移动目录
    moveFiles(fs, tempDir, userDestDir, nextPartition);

    // delete temporary path 删除临时目录
    LOG.debug("Deleting temporary folder " + tempDir.getName());
    fs.delete(tempDir, true);
  }

  /**
   * Returns the greatest partition number available for appending, for data
   * files in targetDir.
   * 获取最大的id,然后+1即可
   */
  private int getNextPartition(FileSystem fs, Path targetDir)
      throws IOException {

    int nextPartition = 0;
    FileStatus[] existingFiles = fs.listStatus(targetDir);
    if (existingFiles != null && existingFiles.length > 0) {
      for (FileStatus fileStat : existingFiles) {
        if (!fileStat.isDir()) {
          String filename = fileStat.getPath().getName();
          Matcher mat = DATA_PART_PATTERN.matcher(filename);
          if (mat.matches()) {
            int thisPart = Integer.parseInt(mat.group(1));
            if (thisPart >= nextPartition) {
              nextPartition = thisPart;
              nextPartition++;
            }
          }
        }
      }
    }

    if (nextPartition > 0) {
      LOG.info("Using found partition " + nextPartition);
    }

    return nextPartition;
  }

  /**
   * Move selected files from source to target using a specified starting partition.
   *
   * Directories are moved without restriction.  Note that the serial
   * number of directories bears no relation to the file partition
   * numbering.
   * 将sourceDir目录内容移动到targetDir目录下,因为该目录存在了,则移动到partitionStart分区内
   */
  private void moveFiles(FileSystem fs, Path sourceDir, Path targetDir,
      int partitionStart) throws IOException {

    /* list files in the source dir and check for errors */

    //获取数据源的文件数量,以及是否有文件,没文件则抛异常
    FileStatus[] sourceFiles = fs.listStatus(sourceDir);

    if (null == sourceFiles) {
      // If we've already checked that the dir exists, and now it can't be
      // listed, this is a genuine error (permissions, fs integrity, or other).
      throw new IOException("Could not list files from " + sourceDir);
    }


    /* state used throughout the entire move operation */

    // pad the data partition number thusly
    NumberFormat partFormat = NumberFormat.getInstance();
    partFormat.setMinimumIntegerDigits(PARTITION_DIGITS);
    partFormat.setGroupingUsed(false);

    // where the data partitioning is currently at
    int dataPart = partitionStart;


    /* loop through all top-level files and copy matching ones */
    //循环每一个数据源文件
    for (FileStatus fileStatus : sourceFiles) {
      String  sourceFilename = fileStatus.getPath().getName();
      StringBuilder destFilename  = new StringBuilder();

      if (fileStatus.isDir()) {    // move all subdirectories 如果是文件
        // pass target dir as initial dest to prevent nesting inside preexisting dir
        if (fs.rename(fileStatus.getPath(), targetDir)) {//将整个文件夹都移动走
          LOG.debug("Directory: " + sourceFilename + " renamed to: " + sourceFilename);
        } else {//不断的移动整个文件夹
          int dirNumber = 0;
          Path destPath;
          do {
            // clear the builder in case this isn't the first iteration
            destFilename.setLength(0);

            // name-nnnnn?
            destFilename
              .append(sourceFilename)
              .append("-")
              .append(partFormat.format(dirNumber++));

            destPath = new Path(targetDir, destFilename.toString());
            if (fs.exists(destPath))
              continue;

            /*
             * There's still a race condition right here if an
             * identically-named directory is created concurrently.
             * It can be avoided by creating a parent dir for all
             * migrated dirs, or by an intermediate rename.
             */

          } while (!fs.rename(fileStatus.getPath(), destPath));

          LOG.debug("Directory: " + sourceFilename + " renamed to: " + destPath.getName());
        }
      } else if (DATA_PART_PATTERN.matcher(sourceFilename).matches()) {    // move only matching top-level files 如果匹配的是一个文件,文件的名字改一下,为目标目录最大的序号值++即可
        do {
          // clear the builder in case this isn't the first iteration
          destFilename.setLength(0);

          // name-nnnnn
          destFilename
            .append(getFilename(sourceFilename))
            .append(partFormat.format(dataPart++));

          // .ext?
          String extension = getFileExtension(sourceFilename);
          if (extension != null)
            destFilename.append(getFileExtension(sourceFilename));
        } while (!fs.rename(fileStatus.getPath(), new Path(targetDir, destFilename.toString())));

        LOG.debug("Filename: " + sourceFilename + " repartitioned to: " + destFilename.toString());
      } else {
        // Generated Parquet files do not follow the pattern "part-m-([0-9]{5}).ext", so that these
        // files cannot be moved to target directory expectedly. We simply check file extension.
        boolean fileMoved = false;
        if (sourceFilename.endsWith(".parquet")) {
          Path targetFilename = new Path(targetDir, sourceFilename.toString());
          fileMoved = fs.rename(fileStatus.getPath(), targetFilename);
        }
        if (!fileMoved) {    // ignore everything else
          LOG.debug("Filename: " + sourceFilename + " ignored");
        }
      }
    }
  }

  /** returns the name component of a file. */
  private String getFilename(String filename) {
    String result = null;
    int pos = filename.lastIndexOf(FILEPART_SEPARATOR);
    if (pos != -1) {
      result = filename.substring(0, pos + 1);
    } else {
      pos = filename.lastIndexOf(FILEEXT_SEPARATOR);
      if (pos != -1) {
        result = filename.substring(0, pos);
      } else {
        result = filename;
      }
    }
    return result;
  }

  /** returns the extension component of a filename.
   * 获取文件的扩展名
   **/
  private String getFileExtension(String filename) {
    int pos = filename.lastIndexOf(FILEEXT_SEPARATOR);
    if (pos != -1) {
      return filename.substring(pos, filename.length());
    } else {
      return null;
    }
  }

  /**
   * Creates a unique path object inside the sqoop temporary directory.
   *
   * @param salt Salt that will be appended at the end of the generated directory.
   *             Can be arbitrary string, for example table name or query checksum.
   * @return a path pointing to the temporary directory
   * 创建临时目录,在临时目录下创建uuid_salt组成的临时目录
   */
  public static Path getTempAppendDir(String salt) {
    String uuid = UUID.randomUUID().toString().replace("-", "");
    String tempDir = TEMP_IMPORT_ROOT + Path.SEPARATOR + uuid + "_" + salt;
    return new Path(tempDir);
  }

}
