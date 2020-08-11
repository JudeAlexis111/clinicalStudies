/*
 * Copyright 2020 Google LLC
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package com.google.cloud.healthcare.fdamystudies.beans;

import java.sql.Timestamp;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AuditLogEventRequest {

  @NotBlank
  @Size(max = 36)
  private String correlationId;

  @NotBlank
  @Size(max = 40)
  private String eventCode;

  @NotBlank
  @Size(max = 255)
  @ToString.Exclude
  private String description;

  @NotBlank
  @Size(max = 50)
  private String source;

  @NotBlank
  @Size(max = 50)
  private String destination;

  @Size(max = 50)
  private String resourceServer;

  @Size(max = 64)
  @ToString.Exclude
  private String userId;

  @Size(max = 20)
  private String userAccessLevel;

  @NotBlank
  @Size(max = 20)
  private String sourceApplicationVersion;

  @NotBlank
  @Size(max = 20)
  private String destinationApplicationVersion;

  @NotBlank
  @Size(max = 20)
  private String platformVersion;

  @PastOrPresent private Timestamp occured;

  @Size(max = 64)
  private String appId;

  @ToString.Exclude
  @Size(min = 7, max = 39)
  private String userIp;

  @NotBlank
  @Size(max = 20)
  private String mobilePlatform;

  @Size(max = 20)
  private String appVersion;

  @Size(max = 64)
  private String participantId;

  @Size(max = 64)
  private String studyId;

  @Size(max = 20)
  private String studyVersion;
}
