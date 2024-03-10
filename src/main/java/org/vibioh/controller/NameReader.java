package org.vibioh.controller;

import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.Scanner;

@Component
public class NameReader implements Reader {
  private final Scanner in;


  public NameReader(InputStream in) {
    this.in = new Scanner(in);
  }

  @Override
  public String read() {
    return in.next();
  }
}
