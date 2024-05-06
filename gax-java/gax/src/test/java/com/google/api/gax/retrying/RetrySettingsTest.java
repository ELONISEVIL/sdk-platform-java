/*
 * Copyright 2021 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.retrying;

import com.google.common.collect.ImmutableList;
import com.google.common.truth.Truth;
import org.junit.Test;

public class RetrySettingsTest {

  @Test
  public void retrySettingsSetLogicalTimeout() {
    java.time.Duration javaTimeTimeout = java.time.Duration.ofMillis(60000);
    org.threeten.bp.Duration threetenTimeout = org.threeten.bp.Duration.ofMillis(60000);
    RetrySettings javaTimeRetrySettings =
        RetrySettings.newBuilder().setLogicalTimeout(javaTimeTimeout).build();
    RetrySettings threetenRetrySettings =
        RetrySettings.newBuilder().setLogicalTimeout(threetenTimeout).build();

    for (RetrySettings retrySettings :
        ImmutableList.of(javaTimeRetrySettings, threetenRetrySettings)) {
      Truth.assertThat(retrySettings.getRpcTimeoutMultiplier()).isEqualTo(1);
      Truth.assertThat(retrySettings.getInitialRpcTimeoutDuration()).isEqualTo(javaTimeTimeout);
      Truth.assertThat(retrySettings.getInitialRpcTimeout()).isEqualTo(threetenTimeout);
      Truth.assertThat(retrySettings.getMaxRpcTimeoutDuration()).isEqualTo(javaTimeTimeout);
      Truth.assertThat(retrySettings.getMaxRpcTimeout()).isEqualTo(threetenTimeout);
      Truth.assertThat(retrySettings.getTotalTimeoutDuration()).isEqualTo(javaTimeTimeout);
      Truth.assertThat(retrySettings.getTotalTimeout()).isEqualTo(threetenTimeout);
    }
  }

  @Test
  public void retrySettingsMerge() {
    RetrySettings.Builder builder =
        RetrySettings.newBuilder()
            .setTotalTimeout(java.time.Duration.ofMillis(45000))
            .setInitialRpcTimeout(java.time.Duration.ofMillis(2000))
            .setRpcTimeoutMultiplier(1.5)
            .setMaxRpcTimeout(java.time.Duration.ofMillis(30000))
            .setInitialRetryDelay(java.time.Duration.ofMillis(100))
            .setRetryDelayMultiplier(1.2)
            .setMaxRetryDelay(java.time.Duration.ofMillis(1000));
    RetrySettings.Builder mergedBuilder = RetrySettings.newBuilder();
    mergedBuilder.merge(builder);

    RetrySettings settingsA = builder.build();
    RetrySettings settingsB = mergedBuilder.build();

    Truth.assertThat(settingsA.getTotalTimeoutDuration())
        .isEqualTo(settingsB.getTotalTimeoutDuration());
    Truth.assertThat(settingsA.getInitialRetryDelayDuration())
        .isEqualTo(settingsB.getInitialRetryDelayDuration());
    Truth.assertThat(settingsA.getRpcTimeoutMultiplier())
        .isWithin(0)
        .of(settingsB.getRpcTimeoutMultiplier());
    Truth.assertThat(settingsA.getMaxRpcTimeoutDuration())
        .isEqualTo(settingsB.getMaxRpcTimeoutDuration());
    Truth.assertThat(settingsA.getInitialRetryDelayDuration())
        .isEqualTo(settingsB.getInitialRetryDelayDuration());
    Truth.assertThat(settingsA.getRetryDelayMultiplier())
        .isWithin(0)
        .of(settingsB.getRetryDelayMultiplier());
    Truth.assertThat(settingsA.getMaxRetryDelayDuration())
        .isEqualTo(settingsB.getMaxRetryDelayDuration());
  }
}
