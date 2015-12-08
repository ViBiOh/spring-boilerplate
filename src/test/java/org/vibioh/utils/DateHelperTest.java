package org.vibioh.utils;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class DateHelperTest {
  @Test
  public void testNow() throws Exception {
    assertNotNull(DateHelper.now());
  }
}