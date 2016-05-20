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
package org.apache.sqoop.io;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Formatter;

import org.apache.commons.io.output.CountingOutputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.compress.CompressionCodec;

/**
 * An output stream that writes to an underlying filesystem, opening
 * a new file after a specified number of bytes have been written to the
 * current one.
 * 读取输入源，然后将结果写成多个文件输出,每一个文件有一个文件字节上限,达到该限制,就生成一个文件
 */
public class SplittingOutputStream extends OutputStream {

  public static final Log LOG = LogFactory.getLog(
      SplittingOutputStream.class.getName());

  private OutputStream writeStream;//输出流
  private CountingOutputStream countingFilterStream;//计数器流
  private Configuration conf;
  private Path destDir;//已经存在的目录,文件将会输出到该文件目录下
  private String filePrefix;//文件前缀
  private long cutoffBytes;// 每一个文件被切分的时候的临界点,超过该值则要进行一次切分
  private CompressionCodec codec;//文件压缩对象
  private int fileNum;//最终有多少个文件

  /**
   * Create a new SplittingOutputStream.
   * @param conf the Configuration to use to interface with HDFS
   * @param destDir the directory where the files will go (should already
   *     exist).已经存在的目录,文件将会输出到该文件目录下
   * @param filePrefix the first part of the filename, which will be appended
   *    by a number. This file will be placed inside destDir.文件前缀
   * @param cutoff the approximate number of bytes to use per file 每一个文件被切分的时候的临界点,超过该值则要进行一次切分
   * @param doGzip if true, then output files will be gzipped and have a .gz
   *   suffix.如果是true,则输出文件要有.gz后缀
   */
  public SplittingOutputStream(final Configuration conf, final Path destDir,
      final String filePrefix, final long cutoff, final CompressionCodec codec)
      throws IOException {

    this.conf = conf;
    this.destDir = destDir;
    this.filePrefix = filePrefix;
    this.cutoffBytes = cutoff;
    if (this.cutoffBytes < 0) {
      this.cutoffBytes = 0; // splitting disabled.
    }
    this.codec = codec;
    this.fileNum = 0;

    openNextFile();
  }

  /** Initialize the OutputStream to the next file to write to.
   * 创建一个文件
   */
  private void openNextFile() throws IOException {
    StringBuffer sb = new StringBuffer();
    Formatter fmt = new Formatter(sb);
    fmt.format("%05d", this.fileNum++);
    String filename = filePrefix + fmt.toString();//根据前缀和文件序号  ----> 生成文件名
    if (codec != null) {//添加压缩后缀扩展名
      filename = filename + codec.getDefaultExtension();
    }
    Path destFile = new Path(destDir, filename);//设置文件输出的全路就
    FileSystem fs = destFile.getFileSystem(conf);//打开开输出流
    LOG.debug("Opening next output file: " + destFile);
    if (fs.exists(destFile)) {
      Path canonicalDest = destFile.makeQualified(fs);
      throw new IOException("Destination file " + canonicalDest
          + " already exists");
    }

    OutputStream fsOut = fs.create(destFile);

    // Count how many actual bytes hit HDFS.对该输出流包装一下,让他有计数功能
    this.countingFilterStream = new CountingOutputStream(fsOut);

    if (codec != null) {
      // Wrap that in a compressing stream.
      this.writeStream = codec.createOutputStream(this.countingFilterStream);//输出流,支持压缩
    } else {
      // Write to the counting stream directly.
      this.writeStream = this.countingFilterStream;//正常输出流
    }
  }

  /**
   * @return true if allowSplit() would actually cause a split.
   * 判断是否要进行切分文件了
   */
  public boolean wouldSplit() {
    return this.cutoffBytes > 0
        && this.countingFilterStream.getByteCount() >= this.cutoffBytes;//计数字节数超过了一定阀值
  }

  /** If we've written more to the disk than the user's split size,
   * open the next file.
   * 判断是否到了切分条件,切换下一个文件
   */
  private void checkForNextFile() throws IOException {
    if (wouldSplit()) {
      LOG.debug("Starting new split");
      this.writeStream.flush();
      this.writeStream.close();
      openNextFile();//创建新的文件
    }
  }

  /** Defines a point in the stream when it is acceptable to split to a new
      file; e.g., the end of a record.
    */
  public void allowSplit() throws IOException {
    checkForNextFile();
  }

  public void close() throws IOException {
    this.writeStream.close();
  }

  public void flush() throws IOException {
    this.writeStream.flush();
  }

  public void write(byte [] b) throws IOException {
    this.writeStream.write(b);
  }

  public void write(byte [] b, int off, int len) throws IOException {
    this.writeStream.write(b, off, len);
  }

  public void write(int b) throws IOException {
    this.writeStream.write(b);
  }
}
