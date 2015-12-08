package org.vibioh.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.util.reflection.FieldSetter;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.vibioh.model.Hello;
import org.vibioh.utils.DateHelper;

import java.util.Date;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(DateHelper.class)
public class HelloWorldControllerTest {
  private static final long NOEL_2010_20H00 = 1293303600000L;

  @InjectMocks
  private HelloWorldController controller;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    new FieldSetter(controller, controller.getClass().getDeclaredField("appName")).set("Junit");

    PowerMockito.mockStatic(DateHelper.class);
    when(DateHelper.now()).thenReturn(new Date(NOEL_2010_20H00));
  }

  @Test
  public void testHello() throws Exception {
    final Hello result = controller.hello();

    assertNotNull(result);
    assertNotNull(result.getName());
    assertNotNull(result.getMoment());

    PowerMockito.verifyStatic(times(1));
    DateHelper.now();
  }
}