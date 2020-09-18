/*
 * Copyright 2012 Evernote Corporation
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.evernote.auth;

public enum EvernoteService {

  EVERNOTE_PRODUCTION("https://www.evernote.com"), //
  EVERNOTE_SANDBOX("https://sandbox.evernote.com"), //
  YINXIANG_PRODUCTION("https://app.yinxiang.com"),
  YINXIANG_SANDBOX("https://sandbox.yinxiang.com");

  private String host;

  private EvernoteService(String host) {
    this.host = host;
  }

  public String getHost() {
    return host;
  }

  public String getRequestTokenEndpoint() {
    return getEndpointUrl("/oauth");
  }

  public String getAccessTokenEndpoint() {
    return getEndpointUrl("/oauth");
  }

  public String getAuthorizationUrl(String token) {
    return String.format(getEndpointUrl("/OAuth.action?oauth_token=%s"), token);
  }

  String getEndpointUrl(String path) {
    return this.host + path;
  }

}
