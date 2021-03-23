package org.vibioh.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.vibioh.model.Hello;
import org.vibioh.service.DateService;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HelloWorldControllerTest {
    private static final long NOEL_2010_20H00 = 1293303600000L;

    @InjectMocks
    private HelloWorldController controller;

    @Mock
    private DateService dateService;

    @BeforeEach
    public void setUp() {
        when(dateService.now()).thenReturn(Instant.ofEpochMilli(NOEL_2010_20H00));
    }

    @Test
    public void testHello() {
        final Hello result = controller.get();

        assertNotNull(result);
        assertNotEquals(result.getMoment(), 0);
    }
}
