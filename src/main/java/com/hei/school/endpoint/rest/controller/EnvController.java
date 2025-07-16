package com.hei.school.endpoint.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvController {

  private final String secretKey;

  public EnvController() {
    this.secretKey = System.getenv("SECRET_KEY");
  }

  @GetMapping("/env/secret-key")
  public String getSecretKey() {
    return secretKey;
  }
}
