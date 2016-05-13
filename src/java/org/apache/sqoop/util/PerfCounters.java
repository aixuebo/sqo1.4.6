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

import java.text.NumberFormat;

/**
 * A quick set of performance counters for reporting import speed.
 * 创建每秒流量统计对象
 */
public class PerfCounters {

  private long bytes;//产生多少字节
  private long nanoseconds;//消耗多少时间

  private long startTime;//开始时间

  public PerfCounters() {
  }

  public void addBytes(long more) {
    bytes += more;
  }

  public void startClock() {
    startTime = System.nanoTime();
  }

  public void stopClock() {
    nanoseconds = System.nanoTime() - startTime;
  }

  private static final double ONE_BILLION = 1000.0 * 1000.0 * 1000.0;

  /** Maximum number of digits after the decimal place. 
   * 小数点保留多少位
   **/
  private static final int MAX_PLACES = 4;

  /**
   * @return A value in nanoseconds scaled to report in seconds
   * 消耗时间单位转换成秒
   */
  private Double inSeconds(long nanos) {
    return (double) nanos / ONE_BILLION;
  }

  private static final long ONE_GB = 1024 * 1024 * 1024;//1G
  private static final long ONE_MB = 1024 * 1024;//1M
  private static final long ONE_KB = 1024;//1K


  /**
   * @return a string of the form "xxxx bytes" or "xxxxx KB" or "xxxx GB",
   * scaled as is appropriate for the current value.
   */
  private String formatBytes() {
    double val;
    String scale;
    if (bytes > ONE_GB) {
      val = (double) bytes / (double) ONE_GB;
      scale = "GB";
    } else if (bytes > ONE_MB) {
      val = (double) bytes / (double) ONE_MB;
      scale = "MB";
    } else if (bytes > ONE_KB) {
      val = (double) bytes / (double) ONE_KB;
      scale = "KB";
    } else {
      val = (double) bytes;
      scale = "bytes";
    }

    NumberFormat fmt = NumberFormat.getInstance();
    fmt.setMaximumFractionDigits(MAX_PLACES);
    return fmt.format(val) + " " + scale;
  }

  //一共消耗了多少秒
  private String formatTimeInSeconds() {
    NumberFormat fmt = NumberFormat.getInstance();
    fmt.setMaximumFractionDigits(MAX_PLACES);
    return fmt.format(inSeconds(this.nanoseconds)) + " seconds";
  }

  /**
   * @return a string of the form "xxx bytes/sec" or "xxx KB/sec" scaled as is
   * appropriate for the current value.
   */
  private String formatSpeed() {
    NumberFormat fmt = NumberFormat.getInstance();
    fmt.setMaximumFractionDigits(MAX_PLACES);

    //消耗时间转换成秒
    Double seconds = inSeconds(this.nanoseconds);

    //计算每秒多少字节
    double speed = (double) bytes / seconds;
    double val;
    String scale;
    if (speed > ONE_GB) {
      val = speed / (double) ONE_GB;
      scale = "GB";
    } else if (speed > ONE_MB) {
      val = speed / (double) ONE_MB;
      scale = "MB";
    } else if (speed > ONE_KB) {
      val = speed / (double) ONE_KB;
      scale = "KB";
    } else {
      val = speed;
      scale = "bytes";
    }

    return fmt.format(val) + " " + scale + "/sec";
  }

  //产生多少字节,在多少秒内,平均每秒多少字节
  public String toString() {
    return formatBytes() + " in " + formatTimeInSeconds() + " ("
        + formatSpeed() + ")";
  }

}

