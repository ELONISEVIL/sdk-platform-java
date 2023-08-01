/*
 * Copyright 2017 Google LLC
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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.core.ApiClock;
import com.google.api.core.InternalApi;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The timed retry algorithm which uses jittered exponential backoff factor for calculating the next
 * attempt execution time.
 *
 * <p>This class is thread-safe.
 */
public class ExponentialRetryAlgorithm implements TimedRetryAlgorithmWithContext {

  private final RetrySettings globalSettings;
  private final ApiClock clock;

  /**
   * Creates a new exponential retry algorithm instance.
   *
   * @param globalSettings global retry settings (attempt independent)
   * @param clock clock to use for time-specific calculations
   * @throws NullPointerException if either {@code globalSettings} or {@code clock} is null
   */
  public ExponentialRetryAlgorithm(RetrySettings globalSettings, ApiClock clock) {
    this.globalSettings = checkNotNull(globalSettings);
    this.clock = checkNotNull(clock);
  }

  /**
   * Creates a first attempt {@link TimedAttemptSettings}. The first attempt is configured to be
   * executed immediately.
   *
   * @return first attempt settings
   */
  @Override
  public TimedAttemptSettings createFirstAttempt() {
    return TimedAttemptSettings.newBuilder()
        .setGlobalSettings(globalSettings)
        .setRetryDelay(org.threeten.bp.Duration.ZERO)
        .setRpcTimeout(globalSettings.getInitialRpcTimeout())
        .setRandomizedRetryDelay(org.threeten.bp.Duration.ZERO)
        .setAttemptCount(0)
        .setOverallAttemptCount(0)
        .setFirstAttemptStartTimeNanos(clock.nanoTime())
        .build();
  }

  /**
   * Creates a first attempt {@link TimedAttemptSettings}. The first attempt is configured to be
   * executed immediately.
   *
   * @param context a {@link RetryingContext} that can contain custom {@link RetrySettings} and
   *     retryable codes
   * @return first attempt settings
   */
  @Override
  public TimedAttemptSettings createFirstAttempt(RetryingContext context) {
    if (context.getRetrySettings() == null) {
      return createFirstAttempt();
    }

    RetrySettings retrySettings = context.getRetrySettings();
    return TimedAttemptSettings.newBuilder()
        // Use the given retrySettings rather than the settings this was created with.
        // Attempts created using the TimedAttemptSettings built here will use these
        // retrySettings, but a new call will not (unless overridden again).
        .setGlobalSettings(retrySettings)
        .setRpcTimeout(retrySettings.getInitialRpcTimeout())
        .setRetryDelay(org.threeten.bp.Duration.ZERO)
        .setRandomizedRetryDelay(org.threeten.bp.Duration.ZERO)
        .setAttemptCount(0)
        .setOverallAttemptCount(0)
        .setFirstAttemptStartTimeNanos(clock.nanoTime())
        .build();
  }

  /**
   * Creates a next attempt {@link TimedAttemptSettings}. The implementation increments the current
   * attempt count and uses randomized exponential backoff factor for calculating next attempt
   * execution time.
   *
   * @param previousSettings previous attempt settings
   * @return next attempt settings
   */
  @Override
  public TimedAttemptSettings createNextAttempt(TimedAttemptSettings previousSettings) {
    RetrySettings settings = previousSettings.getGlobalSettings();

    // The retry delay is determined as follows:
    //     attempt #0  - not used (initial attempt is always made immediately);
    //     attempt #1  - use initialRetryDelay;
    //     attempt #2+ - use the calculated value (i.e. the following if statement is true only
    //                   if we are about to calculate the value for the upcoming 2nd+ attempt).
    long newRetryDelay = settings.getInitialRetryDelay().toMillis();
    if (previousSettings.getAttemptCount() > 0) {
      newRetryDelay =
          (long) (settings.getRetryDelayMultiplier() * previousSettings.getRetryDelay().toMillis());
      newRetryDelay = Math.min(newRetryDelay, settings.getMaxRetryDelay().toMillis());
    }
    org.threeten.bp.Duration randomDelay =
        org.threeten.bp.Duration.ofMillis(nextRandomLong(newRetryDelay));

    // The rpc timeout is determined as follows:
    //     attempt #0  - use the initialRpcTimeout;
    //     attempt #1+ - use the calculated value, or the time remaining in totalTimeout if the
    //                   calculated value would exceed the totalTimeout.
    long newRpcTimeout =
        (long) (settings.getRpcTimeoutMultiplier() * previousSettings.getRpcTimeout().toMillis());
    newRpcTimeout = Math.min(newRpcTimeout, settings.getMaxRpcTimeout().toMillis());

    // The totalTimeout could be zero if a callable is only using maxAttempts to limit retries.
    // If set, calculate time remaining in the totalTimeout since the start, taking into account the
    // next attempt's delay, in order to truncate the RPC timeout should it exceed the totalTimeout.
    if (!settings.getTotalTimeout().isZero()) {
      org.threeten.bp.Duration timeElapsed =
          org.threeten.bp.Duration.ofNanos(clock.nanoTime())
              .minus(
                  org.threeten.bp.Duration.ofNanos(
                      previousSettings.getFirstAttemptStartTimeNanos()));
      org.threeten.bp.Duration timeLeft =
          settings.getTotalTimeout().minus(timeElapsed).minus(randomDelay);

      // If timeLeft at this point is < 0, the shouldRetry logic will prevent
      // the attempt from being made as it would exceed the totalTimeout. A negative RPC timeout
      // will result in a deadline in the past, which will always fail prior to making a
      // network call.
      newRpcTimeout = Math.min(newRpcTimeout, timeLeft.toMillis());
    }

    return TimedAttemptSettings.newBuilder()
        .setGlobalSettings(previousSettings.getGlobalSettings())
        .setRetryDelay(org.threeten.bp.Duration.ofMillis(newRetryDelay))
        .setRpcTimeout(org.threeten.bp.Duration.ofMillis(newRpcTimeout))
        .setRandomizedRetryDelay(randomDelay)
        .setAttemptCount(previousSettings.getAttemptCount() + 1)
        .setOverallAttemptCount(previousSettings.getOverallAttemptCount() + 1)
        .setFirstAttemptStartTimeNanos(previousSettings.getFirstAttemptStartTimeNanos())
        .build();
  }

  /**
   * Creates a next attempt {@link TimedAttemptSettings}. The implementation increments the current
   * attempt count and uses randomized exponential backoff factor for calculating next attempt
   * execution time.
   *
   * @param context a {@link RetryingContext} that can contain custom {@link RetrySettings} and
   *     retryable codes
   * @param previousSettings previous attempt settings
   * @return next attempt settings
   */
  @Override
  public TimedAttemptSettings createNextAttempt(
      RetryingContext context, TimedAttemptSettings previousSettings) {
    // The RetrySettings from the context are not used here, as they have already been set as the
    // global settings during the creation of the initial attempt.
    return createNextAttempt(previousSettings);
  }

  /**
   * Returns {@code true} if another attempt should be made, or {@code false} otherwise.
   *
   * @param nextAttemptSettings attempt settings, which will be used for the next attempt, if
   *     accepted
   * @return {@code true} if {@code nextAttemptSettings} does not exceed either maxAttempts limit or
   *     totalTimeout limit, or {@code false} otherwise
   */
  @Override
  public boolean shouldRetry(TimedAttemptSettings nextAttemptSettings) {
    RetrySettings globalSettings = nextAttemptSettings.getGlobalSettings();

    int maxAttempts = globalSettings.getMaxAttempts();
    org.threeten.bp.Duration totalTimeout = globalSettings.getTotalTimeout();

    // If total timeout and maxAttempts is not set then do not attempt retry.
    if (totalTimeout.isZero() && maxAttempts == 0) {
      return false;
    }

    long totalTimeSpentNanos =
        clock.nanoTime()
            - nextAttemptSettings.getFirstAttemptStartTimeNanos()
            + nextAttemptSettings.getRandomizedRetryDelay().toNanos();

    org.threeten.bp.Duration timeLeft =
        totalTimeout.minus(org.threeten.bp.Duration.ofNanos(totalTimeSpentNanos));
    // Convert time spent to milliseconds to standardize the units being used for
    // retries. Otherwise, we would be using nanoseconds to determine if retries
    // should be attempted and milliseconds for retry delays and rpc timeouts
    long timeLeftMs = timeLeft.toMillis();
    // If totalTimeout limit is defined, check that it hasn't been crossed.
    if (!totalTimeout.isZero() && shouldRPCTerminate(timeLeftMs)) {
      return false;
    }

    // If maxAttempts limit is defined, check that it hasn't been crossed
    if (maxAttempts > 0 && nextAttemptSettings.getAttemptCount() >= maxAttempts) {
      return false;
    }

    // No limits crossed
    return true;
  }

  // For non-LRO RPCs, do not attempt to retry if the totalTime spend is over
  // the totalTimeout (timeout is in the past) or at the totalTimeout (timeout
  // will occur immediately). For any other value, the deadlineScheduler will
  // terminate in the future (even if the timeout is small).
  @InternalApi
  protected boolean shouldRPCTerminate(long timeLeftMs) {
    return timeLeftMs <= 0;
  }

  /**
   * Returns {@code true} if another attempt should be made, or {@code false} otherwise.
   *
   * @param context a {@link RetryingContext} that can contain custom {@link RetrySettings} and
   *     retryable codes. Ignored by this implementation.
   * @param nextAttemptSettings attempt settings, which will be used for the next attempt, if
   *     accepted
   * @return {@code true} if {@code nextAttemptSettings} does not exceed either maxAttempts limit or
   *     totalTimeout limit, or {@code false} otherwise
   */
  @Override
  public boolean shouldRetry(RetryingContext context, TimedAttemptSettings nextAttemptSettings) {
    // The RetrySettings from the context are not used here, as they have already been set as the
    // global settings during the creation of the initial attempt.
    return shouldRetry(nextAttemptSettings);
  }

  // Injecting Random is not possible here, as Random does not provide nextLong(long bound) method
  protected long nextRandomLong(long bound) {
    return bound > 0 && globalSettings.isJittered() // Jitter check needed for testing purposes.
        ? ThreadLocalRandom.current().nextLong(bound)
        : bound;
  }
}
