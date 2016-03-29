package org.vibioh.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestExceptionHandler {
   private static final Logger logger = Logger.getLogger(RestExceptionHandler.class);

   @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
   @ExceptionHandler(value = { RuntimeException.class, Exception.class })
   public void handleException(final Exception e) {
      logger.error(e.getMessage(), e);
   }
}
