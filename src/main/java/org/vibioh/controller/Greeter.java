package org.vibioh.controller;

import org.vibioh.model.Hello;

import java.util.Locale;

public interface Greeter {
  Hello name(String name);

  String render(Hello hello, Locale locale);
}
