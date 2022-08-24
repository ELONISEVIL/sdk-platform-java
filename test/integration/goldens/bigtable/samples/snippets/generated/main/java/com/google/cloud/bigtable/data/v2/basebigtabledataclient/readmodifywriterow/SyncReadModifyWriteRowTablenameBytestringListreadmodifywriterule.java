/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigtable.data.v2.samples;

// [START bigtable_v2_generated_basebigtabledataclient_readmodifywriterow_tablenamebytestringlistreadmodifywriterule_sync]
import com.google.bigtable.v2.ReadModifyWriteRowResponse;
import com.google.bigtable.v2.ReadModifyWriteRule;
import com.google.bigtable.v2.TableName;
import com.google.cloud.bigtable.data.v2.BaseBigtableDataClient;
import com.google.protobuf.ByteString;
import java.util.ArrayList;
import java.util.List;

public class SyncReadModifyWriteRowTablenameBytestringListreadmodifywriterule {

  public static void main(String[] args) throws Exception {
    syncReadModifyWriteRowTablenameBytestringListreadmodifywriterule();
  }

  public static void syncReadModifyWriteRowTablenameBytestringListreadmodifywriterule()
      throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (BaseBigtableDataClient baseBigtableDataClient = BaseBigtableDataClient.create()) {
      TableName tableName = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
      ByteString rowKey = ByteString.EMPTY;
      List<ReadModifyWriteRule> rules = new ArrayList<>();
      ReadModifyWriteRowResponse response =
          baseBigtableDataClient.readModifyWriteRow(tableName, rowKey, rules);
    }
  }
}
// [END bigtable_v2_generated_basebigtabledataclient_readmodifywriterow_tablenamebytestringlistreadmodifywriterule_sync]
