package org.vibioh.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.util.reflection.FieldSetter;
import org.vibioh.model.Hello;
import org.vibioh.service.DateService;

import java.time.Instant;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

public class HelloWorldControllerTest {
    private static final long NOEL_2010_20H00 = 1293303600000L;

    @InjectMocks
    private HelloWorldController controller;

    @Mock
    private DateService dateService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        new FieldSetter(controller, controller.getClass().getDeclaredField("appName")).set("Junit");

        when(dateService.now()).thenReturn(Instant.ofEpochMilli(NOEL_2010_20H00));
    }

    @Test
    public void testHello() throws Exception {
        final Hello result = controller.hello();

        assertNotNull(result);
        assertNotNull(result.getName());
        assertNotNull(result.getMoment());
    }
}