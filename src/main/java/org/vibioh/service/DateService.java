package org.vibioh.service;

import java.time.Instant;
import java.time.Clock;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class DateService {
    private Clock clock;
    
    @Autowired
    public DateService(final Clock clock) {
        this.clock = clock;
    }
    
    public Instant now() {
        return Instant.now(this.clock);
    }
}