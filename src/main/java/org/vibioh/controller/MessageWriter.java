package org.vibioh.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

@Component
public class MessageWriter implements Writer {
  private final OutputStream out;
  private final MessageSource source;

  @Value("${app.name}")
  private String appName;

  public MessageWriter(OutputStream out, MessageSource source) {
    this.out = out;
    this.source = source;
  }

  @Override
  public void write(String payload, Locale locale) throws IOException {
    String content = source.getMessage("prompt", new Object[]{appName}, locale);
    content += " " + payload;

    out.write(content.getBytes(StandardCharsets.UTF_8));
  }
}
