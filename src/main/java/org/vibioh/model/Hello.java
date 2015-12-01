package org.vibioh.model;

public class Hello {
  private String name;
  private long moment;

  public Hello(final String name) {
    this.name = name;
    moment = System.currentTimeMillis();
  }

  public String getName() {
    return name;
  }

  public long getMoment() {
    return moment;
  }
}
