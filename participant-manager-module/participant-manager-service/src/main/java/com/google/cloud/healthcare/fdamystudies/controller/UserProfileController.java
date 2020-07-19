/*
 * Copyright 2020 Google LLC
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package com.google.cloud.healthcare.fdamystudies.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.cloud.healthcare.fdamystudies.beans.UserProfileRequest;
import com.google.cloud.healthcare.fdamystudies.beans.UserProfileResponse;
import com.google.cloud.healthcare.fdamystudies.service.UserProfileService;

@RestController
public class UserProfileController {

  private XLogger logger = XLoggerFactory.getXLogger(UserProfileController.class.getName());

  private static final String STATUS_LOG = "status=%d";

  private static final String BEGIN_REQUEST_LOG = "%s request";

  @Autowired private UserProfileService userProfileService;

  @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<UserProfileResponse> getUserProfile(
      @RequestHeader("authUserId") String authUserId, HttpServletRequest request) {
    logger.entry(BEGIN_REQUEST_LOG, request.getRequestURI());
    UserProfileResponse profileResponse = userProfileService.getUserProfile(authUserId);

    logger.exit(String.format(STATUS_LOG, profileResponse.getHttpStatusCode()));
    return ResponseEntity.status(profileResponse.getHttpStatusCode()).body(profileResponse);
  }

  @PutMapping(
      value = "/updateUserProfile",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<UserProfileResponse> updateUserProfile(
      @Valid @RequestBody UserProfileRequest userProfileRequest, HttpServletRequest request) {

    logger.entry(String.format(BEGIN_REQUEST_LOG, request.getRequestURI()));

    UserProfileResponse userProfileResponse =
        userProfileService.updateUserProfile(userProfileRequest);
    logger.exit(String.format("status=%d", userProfileResponse.getHttpStatusCode()));
    return ResponseEntity.status(userProfileResponse.getHttpStatusCode()).body(userProfileResponse);
  }

  @GetMapping(value = "/userDetails", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> getUserDetails(
      @RequestParam("securityCode") String securityCode, HttpServletRequest request) {
    logger.entry(String.format(BEGIN_REQUEST_LOG, request.getRequestURI()));
    UserProfileResponse userProfileResponse =
        userProfileService.getUserProfileWithSecurityCode(securityCode);
    logger.exit(String.format("status=%d", userProfileResponse.getHttpStatusCode()));
    return ResponseEntity.status(userProfileResponse.getHttpStatusCode()).body(userProfileResponse);
  }
}
