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

package org.apache.sqoop.mapreduce;

import org.apache.commons.logging.Log;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.TaskInputOutputContext;


/**
  * Run the task process for auto-progress tasks.
  * 后台自动定期报答该task运行的进度信息
  */
public class ProgressThread extends Thread {

  private static Log log = null;

  /**
   * Total number of millis for which progress will be reported by the
   * auto-progress thread. If this is zero, then the auto-progress thread will
   * never voluntarily exit.
   * 最大的处理时间,超过该时间则要主动退出
   */
  private int maxProgressPeriod;

  /**
   * Number of milliseconds to sleep for between loop iterations. Must be less
   * than report interval.
   * 每次循环后要休息多久,该时间必须比报道周期小
   */
  private int sleepInterval;

  /**
   * Number of milliseconds between calls to Reporter.progress().
   * Should be a multiple of the sleepInterval.
   * 报道周期时间间隔
   */
  private int reportInterval;

  public static final String MAX_PROGRESS_PERIOD_KEY =
      "sqoop.mapred.auto.progress.max";
  public static final String SLEEP_INTERVAL_KEY =
      "sqoop.mapred.auto.progress.sleep";
  public static final String REPORT_INTERVAL_KEY =
      "sqoop.mapred.auto.progress.report";

  // Sleep for 10 seconds at a time.
  public static final int DEFAULT_SLEEP_INTERVAL = 10000;

  // Report progress every 30 seconds.
  public static final int DEFAULT_REPORT_INTERVAL = 30000;

  // Disable max progress, by default.
  public static final int DEFAULT_MAX_PROGRESS = 0;

  private volatile boolean keepGoing; // While this is true, thread runs.false表示停止运行

  private TaskInputOutputContext context;
  private long startTimeMillis;
  private long lastReportMillis;//上一次报道该任务情况时间

  public ProgressThread(final TaskInputOutputContext ctxt, Log log) {
    this.context = ctxt;
    this.log = log;
    this.keepGoing = true;
    configureAutoProgress(ctxt.getConfiguration());
  }

  /**
   * Set configuration parameters for the auto-progress thread.
   */
  private void configureAutoProgress(Configuration job) {
    this.maxProgressPeriod = job.getInt(MAX_PROGRESS_PERIOD_KEY,
                                        DEFAULT_MAX_PROGRESS);
    this.sleepInterval = job.getInt(SLEEP_INTERVAL_KEY,
                                    DEFAULT_SLEEP_INTERVAL);
    this.reportInterval = job.getInt(REPORT_INTERVAL_KEY,
                                     DEFAULT_REPORT_INTERVAL);

    if (this.reportInterval < 1) {
      log.warn("Invalid " + REPORT_INTERVAL_KEY + "; setting to "
               + DEFAULT_REPORT_INTERVAL);
      this.reportInterval = DEFAULT_REPORT_INTERVAL;
    }

    if (this.sleepInterval > this.reportInterval || this.sleepInterval < 1) {
      log.warn("Invalid " + SLEEP_INTERVAL_KEY + "; setting to "
               + DEFAULT_SLEEP_INTERVAL);
      this.sleepInterval = DEFAULT_SLEEP_INTERVAL;
    }

    if (this.maxProgressPeriod < 0) {
      log.warn("Invalid " + MAX_PROGRESS_PERIOD_KEY + "; setting to "
               + DEFAULT_MAX_PROGRESS);
      this.maxProgressPeriod = DEFAULT_MAX_PROGRESS;
    }
  }

  public void signalShutdown() {
    this.keepGoing = false; // volatile update.
    this.interrupt();
  }

  public void run() {
    this.lastReportMillis = System.currentTimeMillis();//当前时间
    this.startTimeMillis = this.lastReportMillis;//上一次报道时间

    final long MAX_PROGRESS = this.maxProgressPeriod;//最大时间,超过该时间,则不再进行报道,线程停止
    final long REPORT_INTERVAL = this.reportInterval;//报道间隔
    final long SLEEP_INTERVAL = this.sleepInterval;//报道后至少睡眠多久

    // In a loop:
    //   * Check that we haven't run for too long (maxProgressPeriod).
    //   * If it's been a report interval since we last made progress,
    //     make more.
    //   * Sleep for a bit.
    //   * If the parent thread has signaled for exit, do so.
    while (this.keepGoing) {
      long curTimeMillis = System.currentTimeMillis();//当前时间

      //超时了,则退出
      if (MAX_PROGRESS != 0
          && curTimeMillis - this.startTimeMillis > MAX_PROGRESS) {//超过该时间,则不再进行报道,线程停止
        this.keepGoing = false;
        log.info("Auto-progress thread exiting after " + MAX_PROGRESS
                 + " ms.");
        break;
      }

      if (curTimeMillis - this.lastReportMillis > REPORT_INTERVAL) {//超过时间报道间隔,则进行报道信息
        // It's been a full report interval -- claim progress.
        log.debug("Auto-progress thread reporting progress");
        this.context.progress();
        this.lastReportMillis = curTimeMillis;
      }

      // Unless we got an interrupt while we were working,
      // sleep a bit before doing more work.
      if (!Thread.interrupted()) {
        try {
          Thread.sleep(SLEEP_INTERVAL);
        } catch (InterruptedException ie) {
          // we were notified on something; not necessarily an error.
        }
      }
    }
    log.info("Auto-progress thread is finished. keepGoing=" + this.keepGoing);
  }
}
