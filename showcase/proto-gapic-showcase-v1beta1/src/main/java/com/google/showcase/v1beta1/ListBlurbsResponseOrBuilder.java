// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: schema/google/showcase/v1beta1/messaging.proto

// Protobuf Java Version: 3.25.0
package com.google.showcase.v1beta1;

public interface ListBlurbsResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.showcase.v1beta1.ListBlurbsResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * The list of blurbs.
   * </pre>
   *
   * <code>repeated .google.showcase.v1beta1.Blurb blurbs = 1;</code>
   */
  java.util.List<com.google.showcase.v1beta1.Blurb> 
      getBlurbsList();
  /**
   * <pre>
   * The list of blurbs.
   * </pre>
   *
   * <code>repeated .google.showcase.v1beta1.Blurb blurbs = 1;</code>
   */
  com.google.showcase.v1beta1.Blurb getBlurbs(int index);
  /**
   * <pre>
   * The list of blurbs.
   * </pre>
   *
   * <code>repeated .google.showcase.v1beta1.Blurb blurbs = 1;</code>
   */
  int getBlurbsCount();
  /**
   * <pre>
   * The list of blurbs.
   * </pre>
   *
   * <code>repeated .google.showcase.v1beta1.Blurb blurbs = 1;</code>
   */
  java.util.List<? extends com.google.showcase.v1beta1.BlurbOrBuilder> 
      getBlurbsOrBuilderList();
  /**
   * <pre>
   * The list of blurbs.
   * </pre>
   *
   * <code>repeated .google.showcase.v1beta1.Blurb blurbs = 1;</code>
   */
  com.google.showcase.v1beta1.BlurbOrBuilder getBlurbsOrBuilder(
      int index);

  /**
   * <pre>
   * A token to retrieve next page of results.
   * Pass this value in ListBlurbsRequest.page_token field in the subsequent
   * call to `google.showcase.v1beta1.Blurb&#92;ListBlurbs` method to retrieve
   * the next page of results.
   * </pre>
   *
   * <code>string next_page_token = 2;</code>
   * @return The nextPageToken.
   */
  java.lang.String getNextPageToken();
  /**
   * <pre>
   * A token to retrieve next page of results.
   * Pass this value in ListBlurbsRequest.page_token field in the subsequent
   * call to `google.showcase.v1beta1.Blurb&#92;ListBlurbs` method to retrieve
   * the next page of results.
   * </pre>
   *
   * <code>string next_page_token = 2;</code>
   * @return The bytes for nextPageToken.
   */
  com.google.protobuf.ByteString
      getNextPageTokenBytes();
}
