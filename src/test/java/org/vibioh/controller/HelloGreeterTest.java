package org.vibioh.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.MessageSource;
import org.vibioh.model.Hello;
import org.vibioh.service.DateService;
import java.time.Instant;
import java.util.Locale;

@ExtendWith(MockitoExtension.class)
class HelloGreeterTest {
  private static final long NOEL_2010_20H00 = 1293303600000L;

  @InjectMocks
  private HelloGreeter controller;

  @Mock
  private DateService dateService;
  @Mock
  private MessageSource messageSource;

  @BeforeEach
  public void setUp() {
    when(dateService.now()).thenReturn(Instant.ofEpochMilli(NOEL_2010_20H00));
  }

  @Test
  void hello() {
    final Hello result = controller.name("world");

    assertNotNull(result);
    assertEquals(NOEL_2010_20H00, result.moment().toEpochMilli());
  }

  @Test
  void render() {
    when(messageSource.getMessage(eq("hello"), any(), eq(Locale.of("fr")))).thenReturn("mocked content");

    String result = controller.render(new Hello("render", dateService.now()), Locale.of("fr"));

    assertNotNull(result);
    assertEquals("mocked content", result);
  }
}
