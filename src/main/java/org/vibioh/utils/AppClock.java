package org.vibioh.utils;

import java.time.Clock;
import java.time.Instant;
import org.springframework.stereotype.Component;

@Component
public class AppClock extends Clock {
  public Instant instant() {
    return Instant.now();
  }
}