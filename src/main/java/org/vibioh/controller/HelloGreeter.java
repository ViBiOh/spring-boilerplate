package org.vibioh.controller;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.vibioh.model.Hello;
import org.vibioh.service.DateService;

import java.util.Locale;

import static java.time.format.DateTimeFormatter.ISO_INSTANT;

@Component
public class HelloGreeter implements Greeter {
  private final DateService dateService;
  private final MessageSource source;

  public HelloGreeter(DateService dateService, MessageSource source) {
    this.dateService = dateService;
    this.source = source;
  }

  @Override
  public Hello name(String name) {
    return new Hello(name, dateService.now());
  }

  @Override

  public String render(Hello hello, Locale locale) {
    return source.getMessage("hello", new Object[]{hello.name(), ISO_INSTANT.format(hello.moment())}, locale);
  }
}
