package org.vibioh.entrypoint;

import org.springframework.boot.SpringApplication;
import org.vibioh.config.AppConfiguration;

public class Starter {
  public static void main(final String[] args) throws Exception {
    SpringApplication.run(AppConfiguration.class, args);
  }
}
