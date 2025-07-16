package com.hei.school.endpoint.rest.controller;

import static org.assertj.core.api.Assertions.assertThat;

import com.hei.school.conf.FacadeIT;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = "SECRET_KEY=${secret.key}")
class EnvControllerTest extends FacadeIT {

  @LocalServerPort private int port;

  private final TestRestTemplate restTemplate = new TestRestTemplate();

  @Value("${secret.key}")
  private String secretKey;

  @Test
  void can_read_secret_key() {
    String response =
        restTemplate.getForObject("http://localhost:" + port + "/env/secret-key", String.class);

    assertThat(secretKey)
        .withFailMessage("La variable d'environnement SECRET_KEY n'est pas définie.")
        .isNotNull();

    assertThat(response).isEqualTo(secretKey);
  }
}
