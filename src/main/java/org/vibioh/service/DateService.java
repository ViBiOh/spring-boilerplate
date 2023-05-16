package org.vibioh.service;

import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.Instant;

@Service
public class DateService {
  private final Clock clock;

  public DateService(Clock clock) {
    this.clock = clock;
  }

  public Instant now() {
    return Instant.now(clock);
  }
}
