package org.vibioh.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Clock;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DateServiceTest {
  private static final long NOEL_2010_20H00 = 1293303600000L;
  @InjectMocks
  private DateService service;

  @Mock
  private Clock clock;

  @Test
  void now() {
    when(clock.instant()).thenReturn(Instant.ofEpochMilli(NOEL_2010_20H00));
    assertEquals(service.now(), Instant.ofEpochMilli(NOEL_2010_20H00));
  }
}
