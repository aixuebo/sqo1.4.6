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

import com.cloudera.sqoop.SqoopOptions;

/**
 * @deprecated Moving to use org.apache.sqoop namespace.
 */
public class MergeJob
    extends org.apache.sqoop.mapreduce.MergeJob {

  public static final String MERGE_OLD_PATH_KEY =
      org.apache.sqoop.mapreduce.MergeJob.MERGE_OLD_PATH_KEY;//老数据所在的path路径
  public static final String MERGE_NEW_PATH_KEY =
      org.apache.sqoop.mapreduce.MergeJob.MERGE_NEW_PATH_KEY;//新数据所在的path路径
  public static final String MERGE_KEY_COL_KEY =
      org.apache.sqoop.mapreduce.MergeJob.MERGE_KEY_COL_KEY;//用什么字段进行merge合并
  public static final String MERGE_SQOOP_RECORD_KEY =
      org.apache.sqoop.mapreduce.MergeJob.MERGE_SQOOP_RECORD_KEY;//合并的记录对象

  public MergeJob(final SqoopOptions opts) {
    super(opts);
  }

}


