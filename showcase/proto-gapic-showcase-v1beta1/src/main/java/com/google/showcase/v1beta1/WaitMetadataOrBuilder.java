// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: schema/google/showcase/v1beta1/echo.proto

// Protobuf Java Version: 3.25.0
package com.google.showcase.v1beta1;

public interface WaitMetadataOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.showcase.v1beta1.WaitMetadata)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * The time that this operation will complete.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp end_time = 1;</code>
   * @return Whether the endTime field is set.
   */
  boolean hasEndTime();
  /**
   * <pre>
   * The time that this operation will complete.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp end_time = 1;</code>
   * @return The endTime.
   */
  com.google.protobuf.Timestamp getEndTime();
  /**
   * <pre>
   * The time that this operation will complete.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp end_time = 1;</code>
   */
  com.google.protobuf.TimestampOrBuilder getEndTimeOrBuilder();
}
