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

import java.io.IOException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Identity mapper that continuously reports progress via a background thread.
 * map方法基础上有一个单独的线程,定期去报道该任务的执行进度情况
 */
public class AutoProgressMapper<KEYIN, VALIN, KEYOUT, VALOUT>
    extends SqoopMapper<KEYIN, VALIN, KEYOUT, VALOUT> {

  public static final Log LOG = LogFactory.getLog(
      AutoProgressMapper.class.getName());

  public static final String MAX_PROGRESS_PERIOD_KEY =
      "sqoop.mapred.auto.progress.max";//该任务线程报道多久后就销毁,不在报道数据了
  public static final String SLEEP_INTERVAL_KEY =
      "sqoop.mapred.auto.progress.sleep";//每次报道后休息多久
  public static final String REPORT_INTERVAL_KEY =
      "sqoop.mapred.auto.progress.report";//报道的时间间隔

  //上面三个属性的默认值
  // Sleep for 10 seconds at a time.
  public static final int DEFAULT_SLEEP_INTERVAL = 10000;

  // Report progress every 30 seconds.
  public static final int DEFAULT_REPORT_INTERVAL = 30000;

  // Disable max progress, by default.
  public static final int DEFAULT_MAX_PROGRESS = 0;

  // map() method intentionally omitted; Mapper.map() is the identity mapper.

  /**
   * Run the mapping process for this task, wrapped in an auto-progress system.
   * 运行map-reduce方法处理每一个task的时候,插入一个线程,去定期发送信息
   */
  @Override
  public void run(Context context) throws IOException, InterruptedException {
    ProgressThread thread = new ProgressThread(context, LOG);

    try {
      //启动一个线程,定期做报道该任务的执行进度
      thread.setDaemon(true);
      thread.start();

      // use default run() method to actually drive the mapping.真正执行map方法
      super.run(context);
    } finally {
      // Tell the progress thread to exit..
      LOG.debug("Instructing auto-progress thread to quit.");
      thread.signalShutdown();
      try {
        // And wait for that to happen.
        LOG.debug("Waiting for progress thread shutdown...");
        thread.join();
        LOG.debug("Progress thread shutdown detected.");
      } catch (InterruptedException ie) {
        LOG.warn("Interrupted when waiting on auto-progress thread: "
            + ie.toString(), ie);
      }
    }
  }
}
