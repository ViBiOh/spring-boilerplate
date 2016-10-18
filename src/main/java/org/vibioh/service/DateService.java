package org.vibioh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.Instant;

@Service
public class DateService {
    private final Clock clock;

    @Autowired
    public DateService(final Clock clock) {
        this.clock = clock;
    }

    public Instant now() {
        return Instant.now(this.clock);
    }
}