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

package com.cloudera.sqoop.mapreduce;

/**
 * @deprecated Moving to use org.apache.sqoop namespace.
 * map方法基础上有一个单独的线程,定期去报道该任务的执行进度情况
 */
public class AutoProgressMapper<KEYIN, VALIN, KEYOUT, VALOUT>
    extends org.apache.sqoop.mapreduce.AutoProgressMapper
    <KEYIN, VALIN, KEYOUT, VALOUT> {

  public static final String MAX_PROGRESS_PERIOD_KEY =
      org.apache.sqoop.mapreduce.AutoProgressMapper.MAX_PROGRESS_PERIOD_KEY;//最多报道多久后,就不再进行报道了,线程单独退出
  public static final String SLEEP_INTERVAL_KEY =
      org.apache.sqoop.mapreduce.AutoProgressMapper.SLEEP_INTERVAL_KEY;//每一次报道后睡眠时间
  public static final String REPORT_INTERVAL_KEY =
      org.apache.sqoop.mapreduce.AutoProgressMapper.REPORT_INTERVAL_KEY;//报道时间间隔

  //上面三个属性的默认值
  public static final int DEFAULT_SLEEP_INTERVAL =
      org.apache.sqoop.mapreduce.AutoProgressMapper.DEFAULT_SLEEP_INTERVAL;
  public static final int DEFAULT_REPORT_INTERVAL =
      org.apache.sqoop.mapreduce.AutoProgressMapper.DEFAULT_REPORT_INTERVAL;
  public static final int DEFAULT_MAX_PROGRESS =
      org.apache.sqoop.mapreduce.AutoProgressMapper.DEFAULT_MAX_PROGRESS;

}
