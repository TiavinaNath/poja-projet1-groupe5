package com.hei.school.endpoint.rest.controller;

import static org.assertj.core.api.Assertions.assertThat;

import com.hei.school.conf.FacadeIT;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.web.client.TestRestTemplate;

class EnvControllerTest extends FacadeIT {

  private static final Logger log = LoggerFactory.getLogger(EnvControllerTest.class);

  @Autowired private TestRestTemplate restTemplate;

  @Value("${secret.key}")
  private String secretKey;

  @Test
  void can_read_secret_key() {
    log.info("==> secret.key depuis @Value : {}", secretKey);

    String response = restTemplate.getForObject("/env/secret-key", String.class);

    log.info("==> secret.key depuis l'endpoint : {}", response);

    assertThat(secretKey)
        .withFailMessage("La variable d'environnement secret.key n'est pas définie.")
        .isNotNull();

    assertThat(response).isEqualTo(secretKey);
  }
}
