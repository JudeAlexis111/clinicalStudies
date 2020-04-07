/*
 * Copyright 2020 Google LLC
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package com.google.cloud.healthcare.fdamystudies.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Configuration
@PropertySource("classpath:appConfigurations.properties")
@Setter
@Getter
@ToString
public class ApplicationPropertyConfiguration {

  @Value("${from.email.address}")
  private String fromEmailAddress;

  @Value("${from.email.password}")
  private String fromEmailPassword;

  @Value("${factory.value}")
  private String sslFactoryValue;

  @Value("${port}")
  private String smtpPortValue;

  @Value("${host.name}")
  private String smtpHostName;

  @Value("${passwd.reset.link.subject}")
  private String passwdResetLinkSubject;

  @Value("${passwd.reset.link.content}")
  private String passwdResetLinkContent;

  @Value("${resend.confirmation.mail.subject}")
  private String resendConfirmationMailSubject;

  @Value("${resend.confirmation.mail.content}")
  private String resendConfirmationMail;

  @Value("${authServerAccessTokenValidationUrl}")
  private String authServerAccessTokenValidationUrl;

  @Value("${auth.server.url}")
  private String authServerUrl;

  @Value("${auth.server.updateStatusUrl}")
  private String authServerUpdateStatusUrl;

  @Value("${auth.server.deleteStatusUrl}")
  private String authServerDeleteStatusUrl;

  @Value("${register.url}")
  private String authServerRegisterStatusUrl;

  @Value("${interceptor}")
  private String interceptorUrls;

  @Value("${AUTH_KEY_FCM}")
  private String authKeyFcm;

  @Value("${API_URL_FCM}")
  private String apiUrlFcm;

  @Value("${serverApiUrls}")
  private String serverApiUrls;

  @Value("${authServerClientValidationUrl}")
  private String authServerClientValidationUrl;

  @Value("${clientId}")
  private String clientId;

  @Value("${secretKey}")
  private String secretKey;

  @Value("${response.server.url.participant.withdraw}")
  private String withdrawStudyUrl;

  @Value("${ios.push.notification.type}")
  private String iosPushNotificationType;
}
