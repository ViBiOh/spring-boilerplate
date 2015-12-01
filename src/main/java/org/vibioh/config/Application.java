package org.vibioh.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableAutoConfiguration
@ComponentScan(value = "org.vibioh")
@PropertySource("classpath:application.properties")
public class Application {
  public static void main(final String[] args) throws Exception {
    SpringApplication.run(Application.class, args);
  }
}
