package org.vibioh.controller;

import org.springframework.stereotype.Component;
import org.vibioh.model.Hello;
import org.vibioh.service.DateService;

@Component
public class NamedGreeter implements Greeter {
  private final DateService dateService;

  public NamedGreeter(final DateService dateService) {
    this.dateService = dateService;
  }

  @Override
  public Hello name(final String name) {
    return new Hello(name, dateService.now());
  }
}
