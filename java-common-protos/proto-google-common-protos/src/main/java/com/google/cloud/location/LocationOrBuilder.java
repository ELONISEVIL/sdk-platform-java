/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/cloud/location/locations.proto

// Protobuf Java Version: 3.25.5
package com.google.cloud.location;

public interface LocationOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.cloud.location.Location)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * Resource name for the location, which may vary between implementations.
   * For example: `"projects/example-project/locations/us-east1"`
   * </pre>
   *
   * <code>string name = 1;</code>
   *
   * @return The name.
   */
  java.lang.String getName();
  /**
   *
   *
   * <pre>
   * Resource name for the location, which may vary between implementations.
   * For example: `"projects/example-project/locations/us-east1"`
   * </pre>
   *
   * <code>string name = 1;</code>
   *
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString getNameBytes();

  /**
   *
   *
   * <pre>
   * The canonical id for this location. For example: `"us-east1"`.
   * </pre>
   *
   * <code>string location_id = 4;</code>
   *
   * @return The locationId.
   */
  java.lang.String getLocationId();
  /**
   *
   *
   * <pre>
   * The canonical id for this location. For example: `"us-east1"`.
   * </pre>
   *
   * <code>string location_id = 4;</code>
   *
   * @return The bytes for locationId.
   */
  com.google.protobuf.ByteString getLocationIdBytes();

  /**
   *
   *
   * <pre>
   * The friendly name for this location, typically a nearby city name.
   * For example, "Tokyo".
   * </pre>
   *
   * <code>string display_name = 5;</code>
   *
   * @return The displayName.
   */
  java.lang.String getDisplayName();
  /**
   *
   *
   * <pre>
   * The friendly name for this location, typically a nearby city name.
   * For example, "Tokyo".
   * </pre>
   *
   * <code>string display_name = 5;</code>
   *
   * @return The bytes for displayName.
   */
  com.google.protobuf.ByteString getDisplayNameBytes();

  /**
   *
   *
   * <pre>
   * Cross-service attributes for the location. For example
   *
   *     {"cloud.googleapis.com/region": "us-east1"}
   * </pre>
   *
   * <code>map&lt;string, string&gt; labels = 2;</code>
   */
  int getLabelsCount();
  /**
   *
   *
   * <pre>
   * Cross-service attributes for the location. For example
   *
   *     {"cloud.googleapis.com/region": "us-east1"}
   * </pre>
   *
   * <code>map&lt;string, string&gt; labels = 2;</code>
   */
  boolean containsLabels(java.lang.String key);
  /** Use {@link #getLabelsMap()} instead. */
  @java.lang.Deprecated
  java.util.Map<java.lang.String, java.lang.String> getLabels();
  /**
   *
   *
   * <pre>
   * Cross-service attributes for the location. For example
   *
   *     {"cloud.googleapis.com/region": "us-east1"}
   * </pre>
   *
   * <code>map&lt;string, string&gt; labels = 2;</code>
   */
  java.util.Map<java.lang.String, java.lang.String> getLabelsMap();
  /**
   *
   *
   * <pre>
   * Cross-service attributes for the location. For example
   *
   *     {"cloud.googleapis.com/region": "us-east1"}
   * </pre>
   *
   * <code>map&lt;string, string&gt; labels = 2;</code>
   */
  /* nullable */
  java.lang.String getLabelsOrDefault(
      java.lang.String key,
      /* nullable */
      java.lang.String defaultValue);
  /**
   *
   *
   * <pre>
   * Cross-service attributes for the location. For example
   *
   *     {"cloud.googleapis.com/region": "us-east1"}
   * </pre>
   *
   * <code>map&lt;string, string&gt; labels = 2;</code>
   */
  java.lang.String getLabelsOrThrow(java.lang.String key);

  /**
   *
   *
   * <pre>
   * Service-specific metadata. For example the available capacity at the given
   * location.
   * </pre>
   *
   * <code>.google.protobuf.Any metadata = 3;</code>
   *
   * @return Whether the metadata field is set.
   */
  boolean hasMetadata();
  /**
   *
   *
   * <pre>
   * Service-specific metadata. For example the available capacity at the given
   * location.
   * </pre>
   *
   * <code>.google.protobuf.Any metadata = 3;</code>
   *
   * @return The metadata.
   */
  com.google.protobuf.Any getMetadata();
  /**
   *
   *
   * <pre>
   * Service-specific metadata. For example the available capacity at the given
   * location.
   * </pre>
   *
   * <code>.google.protobuf.Any metadata = 3;</code>
   */
  com.google.protobuf.AnyOrBuilder getMetadataOrBuilder();
}
