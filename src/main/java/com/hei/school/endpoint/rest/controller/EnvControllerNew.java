package com.hei.school.endpoint.rest.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvControllerNew {
  private final String secretKey;

  public EnvControllerNew(@Value("${secret.key}") String secretKey) {
    this.secretKey = secretKey;
  }

  @GetMapping("/env/secret-key")
  public String getSecretKey() {
    return secretKey;
  }
}
