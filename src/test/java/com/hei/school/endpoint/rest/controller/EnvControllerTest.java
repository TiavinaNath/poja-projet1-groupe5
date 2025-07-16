package com.hei.school.endpoint.rest.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EnvControllerTest {

  @LocalServerPort private int port;

  private final TestRestTemplate restTemplate = new TestRestTemplate();

  private static final String secretKey = System.getenv("SECRET_KEY");

  @DynamicPropertySource
  static void overrideSecretKey(DynamicPropertyRegistry registry) {
    registry.add("SECRET_KEY", () -> secretKey);
  }

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
