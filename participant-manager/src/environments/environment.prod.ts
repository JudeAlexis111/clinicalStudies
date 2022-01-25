// Replace the example domain name with your deployed address.
export const environment = {
  production: true,
  // remove http/https to appear relative. xsrf-token skips absolute paths.
  participantManagerDatastoreUrl: '//participants.clinicaltrials-dev.clinicaltrials.mobi/participant-manager-datastore',
  baseHref: '/participant-manager/',
  hydraLoginUrl: 'https://participants.clinicaltrials-dev.clinicaltrials.mobi/oauth2/auth',
  authServerUrl: 'https://participants.clinicaltrials-dev.clinicaltrials.mobi/auth-server',
  authServerRedirectUrl: 'https://participants.clinicaltrials-dev.clinicaltrials.mobi/auth-server/callback',
  hydraClientId: '',
  appVersion: 'v0.1',
  termsPageTitle: 'Terms title goes here',
  termsPageDescription: 'Terms description goes here',
  aboutPageTitle: 'About page title goes here',
  aboutPageDescription: 'About page description goes here',
  copyright: 'Copyright 2020-2021 Google LLC.',
};