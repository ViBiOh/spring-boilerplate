package org.vibioh.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.vibioh.model.Hello;
import org.vibioh.service.DateService;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class HelloWorldControllerTest {
    private static final long NOEL_2010_20H00 = 1293303600000L;

    @InjectMocks
    private HelloWorldController controller;

    @Mock
    private DateService dateService;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        when(dateService.now()).thenReturn(Instant.ofEpochMilli(NOEL_2010_20H00));
    }

    @Test
    public void testHello() throws Exception {
        final Hello result = controller.get();

        assertNotNull(result);
        assertNotEquals(result.getMoment(), 0);
    }
}
