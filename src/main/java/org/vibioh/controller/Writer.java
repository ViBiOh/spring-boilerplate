package org.vibioh.controller;

import java.io.IOException;
import java.util.Locale;

public interface Writer {
  void write(String payload, Locale locale) throws IOException;
}
