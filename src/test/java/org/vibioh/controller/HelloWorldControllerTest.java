package org.vibioh.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.util.reflection.FieldSetter;
import org.vibioh.model.Hello;

import static org.junit.Assert.assertNotNull;

public class HelloWorldControllerTest {
  @InjectMocks
  private HelloWorldController controller;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    new FieldSetter(controller, controller.getClass().getDeclaredField("appName")).set("Junit");
  }

  @Test
  public void testHello() throws Exception {
    final Hello result = controller.hello();

    assertNotNull(result);
    assertNotNull(result.getName());
    assertNotNull(result.getMoment());
  }
}