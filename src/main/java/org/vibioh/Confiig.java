package org.vibioh;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.time.Clock;

@Configuration
public class Confiig {
  @Bean
  public Clock clock() {
    return Clock.systemUTC();
  }

  @Bean
  public MessageSource messageSource() {
    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    messageSource.setBasenames("locale");
    messageSource.setDefaultEncoding("UTF-8");

    return messageSource;
  }
}
