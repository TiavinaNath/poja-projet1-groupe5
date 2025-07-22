package com.hei.school.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Getter
@Service
public class EnvService {
  private final String secretKey;

  public EnvService(@Value("${secret.key}") String secretKey) {
    this.secretKey = secretKey;
  }
}
