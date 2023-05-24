/*
 * Copyright 2020 Google LLC
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
// source: google/iam/v1/policy.proto

package com.google.iam.v1;

/**
 *
 *
 * <pre>
 * One delta entry for AuditConfig. Each individual change (only one
 * exempted_member in each entry) to a AuditConfig will be a separate entry.
 * </pre>
 *
 * Protobuf type {@code google.iam.v1.AuditConfigDelta}
 */
public final class AuditConfigDelta extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:google.iam.v1.AuditConfigDelta)
    AuditConfigDeltaOrBuilder {
  private static final long serialVersionUID = 0L;
  // Use AuditConfigDelta.newBuilder() to construct.
  private AuditConfigDelta(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private AuditConfigDelta() {
    action_ = 0;
    service_ = "";
    exemptedMember_ = "";
    logType_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new AuditConfigDelta();
  }

  public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
    return com.google.iam.v1.PolicyProto.internal_static_google_iam_v1_AuditConfigDelta_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.iam.v1.PolicyProto
        .internal_static_google_iam_v1_AuditConfigDelta_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.iam.v1.AuditConfigDelta.class,
            com.google.iam.v1.AuditConfigDelta.Builder.class);
  }

  /**
   *
   *
   * <pre>
   * The type of action performed on an audit configuration in a policy.
   * </pre>
   *
   * Protobuf enum {@code google.iam.v1.AuditConfigDelta.Action}
   */
  public enum Action implements com.google.protobuf.ProtocolMessageEnum {
    /**
     *
     *
     * <pre>
     * Unspecified.
     * </pre>
     *
     * <code>ACTION_UNSPECIFIED = 0;</code>
     */
    ACTION_UNSPECIFIED(0),
    /**
     *
     *
     * <pre>
     * Addition of an audit configuration.
     * </pre>
     *
     * <code>ADD = 1;</code>
     */
    ADD(1),
    /**
     *
     *
     * <pre>
     * Removal of an audit configuration.
     * </pre>
     *
     * <code>REMOVE = 2;</code>
     */
    REMOVE(2),
    UNRECOGNIZED(-1),
    ;

    /**
     *
     *
     * <pre>
     * Unspecified.
     * </pre>
     *
     * <code>ACTION_UNSPECIFIED = 0;</code>
     */
    public static final int ACTION_UNSPECIFIED_VALUE = 0;
    /**
     *
     *
     * <pre>
     * Addition of an audit configuration.
     * </pre>
     *
     * <code>ADD = 1;</code>
     */
    public static final int ADD_VALUE = 1;
    /**
     *
     *
     * <pre>
     * Removal of an audit configuration.
     * </pre>
     *
     * <code>REMOVE = 2;</code>
     */
    public static final int REMOVE_VALUE = 2;

    public final int getNumber() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalArgumentException(
            "Can't get the number of an unknown enum value.");
      }
      return value;
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static Action valueOf(int value) {
      return forNumber(value);
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     */
    public static Action forNumber(int value) {
      switch (value) {
        case 0:
          return ACTION_UNSPECIFIED;
        case 1:
          return ADD;
        case 2:
          return REMOVE;
        default:
          return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<Action> internalGetValueMap() {
      return internalValueMap;
    }

    private static final com.google.protobuf.Internal.EnumLiteMap<Action> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<Action>() {
          public Action findValueByNumber(int number) {
            return Action.forNumber(number);
          }
        };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor getValueDescriptor() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalStateException(
            "Can't get the descriptor of an unrecognized enum value.");
      }
      return getDescriptor().getValues().get(ordinal());
    }

    public final com.google.protobuf.Descriptors.EnumDescriptor getDescriptorForType() {
      return getDescriptor();
    }

    public static final com.google.protobuf.Descriptors.EnumDescriptor getDescriptor() {
      return com.google.iam.v1.AuditConfigDelta.getDescriptor().getEnumTypes().get(0);
    }

    private static final Action[] VALUES = values();

    public static Action valueOf(com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException("EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private Action(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:google.iam.v1.AuditConfigDelta.Action)
  }

  public static final int ACTION_FIELD_NUMBER = 1;
  private int action_ = 0;
  /**
   *
   *
   * <pre>
   * The action that was performed on an audit configuration in a policy.
   * Required
   * </pre>
   *
   * <code>.google.iam.v1.AuditConfigDelta.Action action = 1;</code>
   *
   * @return The enum numeric value on the wire for action.
   */
  @java.lang.Override
  public int getActionValue() {
    return action_;
  }
  /**
   *
   *
   * <pre>
   * The action that was performed on an audit configuration in a policy.
   * Required
   * </pre>
   *
   * <code>.google.iam.v1.AuditConfigDelta.Action action = 1;</code>
   *
   * @return The action.
   */
  @java.lang.Override
  public com.google.iam.v1.AuditConfigDelta.Action getAction() {
    com.google.iam.v1.AuditConfigDelta.Action result =
        com.google.iam.v1.AuditConfigDelta.Action.forNumber(action_);
    return result == null ? com.google.iam.v1.AuditConfigDelta.Action.UNRECOGNIZED : result;
  }

  public static final int SERVICE_FIELD_NUMBER = 2;

  @SuppressWarnings("serial")
  private volatile java.lang.Object service_ = "";
  /**
   *
   *
   * <pre>
   * Specifies a service that was configured for Cloud Audit Logging.
   * For example, `storage.googleapis.com`, `cloudsql.googleapis.com`.
   * `allServices` is a special value that covers all services.
   * Required
   * </pre>
   *
   * <code>string service = 2;</code>
   *
   * @return The service.
   */
  @java.lang.Override
  public java.lang.String getService() {
    java.lang.Object ref = service_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      service_ = s;
      return s;
    }
  }
  /**
   *
   *
   * <pre>
   * Specifies a service that was configured for Cloud Audit Logging.
   * For example, `storage.googleapis.com`, `cloudsql.googleapis.com`.
   * `allServices` is a special value that covers all services.
   * Required
   * </pre>
   *
   * <code>string service = 2;</code>
   *
   * @return The bytes for service.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getServiceBytes() {
    java.lang.Object ref = service_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      service_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int EXEMPTED_MEMBER_FIELD_NUMBER = 3;

  @SuppressWarnings("serial")
  private volatile java.lang.Object exemptedMember_ = "";
  /**
   *
   *
   * <pre>
   * A single identity that is exempted from "data access" audit
   * logging for the `service` specified above.
   * Follows the same format of Binding.members.
   * </pre>
   *
   * <code>string exempted_member = 3;</code>
   *
   * @return The exemptedMember.
   */
  @java.lang.Override
  public java.lang.String getExemptedMember() {
    java.lang.Object ref = exemptedMember_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      exemptedMember_ = s;
      return s;
    }
  }
  /**
   *
   *
   * <pre>
   * A single identity that is exempted from "data access" audit
   * logging for the `service` specified above.
   * Follows the same format of Binding.members.
   * </pre>
   *
   * <code>string exempted_member = 3;</code>
   *
   * @return The bytes for exemptedMember.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getExemptedMemberBytes() {
    java.lang.Object ref = exemptedMember_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      exemptedMember_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int LOG_TYPE_FIELD_NUMBER = 4;

  @SuppressWarnings("serial")
  private volatile java.lang.Object logType_ = "";
  /**
   *
   *
   * <pre>
   * Specifies the log_type that was be enabled. ADMIN_ACTIVITY is always
   * enabled, and cannot be configured.
   * Required
   * </pre>
   *
   * <code>string log_type = 4;</code>
   *
   * @return The logType.
   */
  @java.lang.Override
  public java.lang.String getLogType() {
    java.lang.Object ref = logType_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      logType_ = s;
      return s;
    }
  }
  /**
   *
   *
   * <pre>
   * Specifies the log_type that was be enabled. ADMIN_ACTIVITY is always
   * enabled, and cannot be configured.
   * Required
   * </pre>
   *
   * <code>string log_type = 4;</code>
   *
   * @return The bytes for logType.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getLogTypeBytes() {
    java.lang.Object ref = logType_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      logType_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;

  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
    if (action_ != com.google.iam.v1.AuditConfigDelta.Action.ACTION_UNSPECIFIED.getNumber()) {
      output.writeEnum(1, action_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(service_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, service_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(exemptedMember_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, exemptedMember_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(logType_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, logType_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (action_ != com.google.iam.v1.AuditConfigDelta.Action.ACTION_UNSPECIFIED.getNumber()) {
      size += com.google.protobuf.CodedOutputStream.computeEnumSize(1, action_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(service_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, service_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(exemptedMember_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, exemptedMember_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(logType_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, logType_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof com.google.iam.v1.AuditConfigDelta)) {
      return super.equals(obj);
    }
    com.google.iam.v1.AuditConfigDelta other = (com.google.iam.v1.AuditConfigDelta) obj;

    if (action_ != other.action_) return false;
    if (!getService().equals(other.getService())) return false;
    if (!getExemptedMember().equals(other.getExemptedMember())) return false;
    if (!getLogType().equals(other.getLogType())) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + ACTION_FIELD_NUMBER;
    hash = (53 * hash) + action_;
    hash = (37 * hash) + SERVICE_FIELD_NUMBER;
    hash = (53 * hash) + getService().hashCode();
    hash = (37 * hash) + EXEMPTED_MEMBER_FIELD_NUMBER;
    hash = (53 * hash) + getExemptedMember().hashCode();
    hash = (37 * hash) + LOG_TYPE_FIELD_NUMBER;
    hash = (53 * hash) + getLogType().hashCode();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.iam.v1.AuditConfigDelta parseFrom(java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.iam.v1.AuditConfigDelta parseFrom(
      java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.iam.v1.AuditConfigDelta parseFrom(com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.iam.v1.AuditConfigDelta parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.iam.v1.AuditConfigDelta parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.iam.v1.AuditConfigDelta parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.iam.v1.AuditConfigDelta parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.iam.v1.AuditConfigDelta parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.iam.v1.AuditConfigDelta parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.google.iam.v1.AuditConfigDelta parseDelimitedFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.iam.v1.AuditConfigDelta parseFrom(
      com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.iam.v1.AuditConfigDelta parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() {
    return newBuilder();
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(com.google.iam.v1.AuditConfigDelta prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   *
   *
   * <pre>
   * One delta entry for AuditConfig. Each individual change (only one
   * exempted_member in each entry) to a AuditConfig will be a separate entry.
   * </pre>
   *
   * Protobuf type {@code google.iam.v1.AuditConfigDelta}
   */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:google.iam.v1.AuditConfigDelta)
      com.google.iam.v1.AuditConfigDeltaOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.google.iam.v1.PolicyProto
          .internal_static_google_iam_v1_AuditConfigDelta_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.iam.v1.PolicyProto
          .internal_static_google_iam_v1_AuditConfigDelta_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.iam.v1.AuditConfigDelta.class,
              com.google.iam.v1.AuditConfigDelta.Builder.class);
    }

    // Construct using com.google.iam.v1.AuditConfigDelta.newBuilder()
    private Builder() {}

    private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
    }

    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      action_ = 0;
      service_ = "";
      exemptedMember_ = "";
      logType_ = "";
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.google.iam.v1.PolicyProto
          .internal_static_google_iam_v1_AuditConfigDelta_descriptor;
    }

    @java.lang.Override
    public com.google.iam.v1.AuditConfigDelta getDefaultInstanceForType() {
      return com.google.iam.v1.AuditConfigDelta.getDefaultInstance();
    }

    @java.lang.Override
    public com.google.iam.v1.AuditConfigDelta build() {
      com.google.iam.v1.AuditConfigDelta result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.google.iam.v1.AuditConfigDelta buildPartial() {
      com.google.iam.v1.AuditConfigDelta result = new com.google.iam.v1.AuditConfigDelta(this);
      if (bitField0_ != 0) {
        buildPartial0(result);
      }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.google.iam.v1.AuditConfigDelta result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.action_ = action_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.service_ = service_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.exemptedMember_ = exemptedMember_;
      }
      if (((from_bitField0_ & 0x00000008) != 0)) {
        result.logType_ = logType_;
      }
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.google.iam.v1.AuditConfigDelta) {
        return mergeFrom((com.google.iam.v1.AuditConfigDelta) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.iam.v1.AuditConfigDelta other) {
      if (other == com.google.iam.v1.AuditConfigDelta.getDefaultInstance()) return this;
      if (other.action_ != 0) {
        setActionValue(other.getActionValue());
      }
      if (!other.getService().isEmpty()) {
        service_ = other.service_;
        bitField0_ |= 0x00000002;
        onChanged();
      }
      if (!other.getExemptedMember().isEmpty()) {
        exemptedMember_ = other.exemptedMember_;
        bitField0_ |= 0x00000004;
        onChanged();
      }
      if (!other.getLogType().isEmpty()) {
        logType_ = other.logType_;
        bitField0_ |= 0x00000008;
        onChanged();
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 8:
              {
                action_ = input.readEnum();
                bitField0_ |= 0x00000001;
                break;
              } // case 8
            case 18:
              {
                service_ = input.readStringRequireUtf8();
                bitField0_ |= 0x00000002;
                break;
              } // case 18
            case 26:
              {
                exemptedMember_ = input.readStringRequireUtf8();
                bitField0_ |= 0x00000004;
                break;
              } // case 26
            case 34:
              {
                logType_ = input.readStringRequireUtf8();
                bitField0_ |= 0x00000008;
                break;
              } // case 34
            default:
              {
                if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                  done = true; // was an endgroup tag
                }
                break;
              } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }

    private int bitField0_;

    private int action_ = 0;
    /**
     *
     *
     * <pre>
     * The action that was performed on an audit configuration in a policy.
     * Required
     * </pre>
     *
     * <code>.google.iam.v1.AuditConfigDelta.Action action = 1;</code>
     *
     * @return The enum numeric value on the wire for action.
     */
    @java.lang.Override
    public int getActionValue() {
      return action_;
    }
    /**
     *
     *
     * <pre>
     * The action that was performed on an audit configuration in a policy.
     * Required
     * </pre>
     *
     * <code>.google.iam.v1.AuditConfigDelta.Action action = 1;</code>
     *
     * @param value The enum numeric value on the wire for action to set.
     * @return This builder for chaining.
     */
    public Builder setActionValue(int value) {
      action_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * The action that was performed on an audit configuration in a policy.
     * Required
     * </pre>
     *
     * <code>.google.iam.v1.AuditConfigDelta.Action action = 1;</code>
     *
     * @return The action.
     */
    @java.lang.Override
    public com.google.iam.v1.AuditConfigDelta.Action getAction() {
      com.google.iam.v1.AuditConfigDelta.Action result =
          com.google.iam.v1.AuditConfigDelta.Action.forNumber(action_);
      return result == null ? com.google.iam.v1.AuditConfigDelta.Action.UNRECOGNIZED : result;
    }
    /**
     *
     *
     * <pre>
     * The action that was performed on an audit configuration in a policy.
     * Required
     * </pre>
     *
     * <code>.google.iam.v1.AuditConfigDelta.Action action = 1;</code>
     *
     * @param value The action to set.
     * @return This builder for chaining.
     */
    public Builder setAction(com.google.iam.v1.AuditConfigDelta.Action value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000001;
      action_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * The action that was performed on an audit configuration in a policy.
     * Required
     * </pre>
     *
     * <code>.google.iam.v1.AuditConfigDelta.Action action = 1;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearAction() {
      bitField0_ = (bitField0_ & ~0x00000001);
      action_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object service_ = "";
    /**
     *
     *
     * <pre>
     * Specifies a service that was configured for Cloud Audit Logging.
     * For example, `storage.googleapis.com`, `cloudsql.googleapis.com`.
     * `allServices` is a special value that covers all services.
     * Required
     * </pre>
     *
     * <code>string service = 2;</code>
     *
     * @return The service.
     */
    public java.lang.String getService() {
      java.lang.Object ref = service_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        service_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     *
     *
     * <pre>
     * Specifies a service that was configured for Cloud Audit Logging.
     * For example, `storage.googleapis.com`, `cloudsql.googleapis.com`.
     * `allServices` is a special value that covers all services.
     * Required
     * </pre>
     *
     * <code>string service = 2;</code>
     *
     * @return The bytes for service.
     */
    public com.google.protobuf.ByteString getServiceBytes() {
      java.lang.Object ref = service_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        service_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     *
     *
     * <pre>
     * Specifies a service that was configured for Cloud Audit Logging.
     * For example, `storage.googleapis.com`, `cloudsql.googleapis.com`.
     * `allServices` is a special value that covers all services.
     * Required
     * </pre>
     *
     * <code>string service = 2;</code>
     *
     * @param value The service to set.
     * @return This builder for chaining.
     */
    public Builder setService(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }
      service_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * Specifies a service that was configured for Cloud Audit Logging.
     * For example, `storage.googleapis.com`, `cloudsql.googleapis.com`.
     * `allServices` is a special value that covers all services.
     * Required
     * </pre>
     *
     * <code>string service = 2;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearService() {
      service_ = getDefaultInstance().getService();
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * Specifies a service that was configured for Cloud Audit Logging.
     * For example, `storage.googleapis.com`, `cloudsql.googleapis.com`.
     * `allServices` is a special value that covers all services.
     * Required
     * </pre>
     *
     * <code>string service = 2;</code>
     *
     * @param value The bytes for service to set.
     * @return This builder for chaining.
     */
    public Builder setServiceBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);
      service_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }

    private java.lang.Object exemptedMember_ = "";
    /**
     *
     *
     * <pre>
     * A single identity that is exempted from "data access" audit
     * logging for the `service` specified above.
     * Follows the same format of Binding.members.
     * </pre>
     *
     * <code>string exempted_member = 3;</code>
     *
     * @return The exemptedMember.
     */
    public java.lang.String getExemptedMember() {
      java.lang.Object ref = exemptedMember_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        exemptedMember_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     *
     *
     * <pre>
     * A single identity that is exempted from "data access" audit
     * logging for the `service` specified above.
     * Follows the same format of Binding.members.
     * </pre>
     *
     * <code>string exempted_member = 3;</code>
     *
     * @return The bytes for exemptedMember.
     */
    public com.google.protobuf.ByteString getExemptedMemberBytes() {
      java.lang.Object ref = exemptedMember_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        exemptedMember_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     *
     *
     * <pre>
     * A single identity that is exempted from "data access" audit
     * logging for the `service` specified above.
     * Follows the same format of Binding.members.
     * </pre>
     *
     * <code>string exempted_member = 3;</code>
     *
     * @param value The exemptedMember to set.
     * @return This builder for chaining.
     */
    public Builder setExemptedMember(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }
      exemptedMember_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * A single identity that is exempted from "data access" audit
     * logging for the `service` specified above.
     * Follows the same format of Binding.members.
     * </pre>
     *
     * <code>string exempted_member = 3;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearExemptedMember() {
      exemptedMember_ = getDefaultInstance().getExemptedMember();
      bitField0_ = (bitField0_ & ~0x00000004);
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * A single identity that is exempted from "data access" audit
     * logging for the `service` specified above.
     * Follows the same format of Binding.members.
     * </pre>
     *
     * <code>string exempted_member = 3;</code>
     *
     * @param value The bytes for exemptedMember to set.
     * @return This builder for chaining.
     */
    public Builder setExemptedMemberBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);
      exemptedMember_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }

    private java.lang.Object logType_ = "";
    /**
     *
     *
     * <pre>
     * Specifies the log_type that was be enabled. ADMIN_ACTIVITY is always
     * enabled, and cannot be configured.
     * Required
     * </pre>
     *
     * <code>string log_type = 4;</code>
     *
     * @return The logType.
     */
    public java.lang.String getLogType() {
      java.lang.Object ref = logType_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        logType_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     *
     *
     * <pre>
     * Specifies the log_type that was be enabled. ADMIN_ACTIVITY is always
     * enabled, and cannot be configured.
     * Required
     * </pre>
     *
     * <code>string log_type = 4;</code>
     *
     * @return The bytes for logType.
     */
    public com.google.protobuf.ByteString getLogTypeBytes() {
      java.lang.Object ref = logType_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        logType_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     *
     *
     * <pre>
     * Specifies the log_type that was be enabled. ADMIN_ACTIVITY is always
     * enabled, and cannot be configured.
     * Required
     * </pre>
     *
     * <code>string log_type = 4;</code>
     *
     * @param value The logType to set.
     * @return This builder for chaining.
     */
    public Builder setLogType(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }
      logType_ = value;
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * Specifies the log_type that was be enabled. ADMIN_ACTIVITY is always
     * enabled, and cannot be configured.
     * Required
     * </pre>
     *
     * <code>string log_type = 4;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearLogType() {
      logType_ = getDefaultInstance().getLogType();
      bitField0_ = (bitField0_ & ~0x00000008);
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * Specifies the log_type that was be enabled. ADMIN_ACTIVITY is always
     * enabled, and cannot be configured.
     * Required
     * </pre>
     *
     * <code>string log_type = 4;</code>
     *
     * @param value The bytes for logType to set.
     * @return This builder for chaining.
     */
    public Builder setLogTypeBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);
      logType_ = value;
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }

    @java.lang.Override
    public final Builder setUnknownFields(final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }

    // @@protoc_insertion_point(builder_scope:google.iam.v1.AuditConfigDelta)
  }

  // @@protoc_insertion_point(class_scope:google.iam.v1.AuditConfigDelta)
  private static final com.google.iam.v1.AuditConfigDelta DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new com.google.iam.v1.AuditConfigDelta();
  }

  public static com.google.iam.v1.AuditConfigDelta getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<AuditConfigDelta> PARSER =
      new com.google.protobuf.AbstractParser<AuditConfigDelta>() {
        @java.lang.Override
        public AuditConfigDelta parsePartialFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
          Builder builder = newBuilder();
          try {
            builder.mergeFrom(input, extensionRegistry);
          } catch (com.google.protobuf.InvalidProtocolBufferException e) {
            throw e.setUnfinishedMessage(builder.buildPartial());
          } catch (com.google.protobuf.UninitializedMessageException e) {
            throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
          } catch (java.io.IOException e) {
            throw new com.google.protobuf.InvalidProtocolBufferException(e)
                .setUnfinishedMessage(builder.buildPartial());
          }
          return builder.buildPartial();
        }
      };

  public static com.google.protobuf.Parser<AuditConfigDelta> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<AuditConfigDelta> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.iam.v1.AuditConfigDelta getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}
