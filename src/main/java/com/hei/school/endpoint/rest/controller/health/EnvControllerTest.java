package com.hei.school.endpoint.rest.controller.health;

import com.hei.school.service.EnvService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvControllerTest {
  private final EnvService envService;

  public EnvControllerTest(EnvService envService) {
    this.envService = envService;
  }

  @GetMapping("/env/secret-key")
  public String getSecretKey() {
    return envService.getSecretKey();
  }
}
