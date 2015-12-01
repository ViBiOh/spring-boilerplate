package org.vibioh.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class BaseController {
  private static final Logger logger = Logger.getLogger(BaseController.class.getCanonicalName());

  public static Logger getLogger() {
    return logger;
  }

  @ExceptionHandler(value = {RuntimeException.class, Exception.class})
  public static ResponseEntity<String> handle(final Exception e) {
    logger.log(Level.SEVERE, e.getMessage(), e);
    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
