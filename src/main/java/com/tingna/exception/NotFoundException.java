package com.tingna.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

<<<<<<< HEAD
=======

>>>>>>> ae25b79fed11168d904f5d8e5ecaa76c70e81e8e
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{

  private final String message;

  public NotFoundException(String message){
    this.message = message;
  }

  @Override
  public String getMessage() {
    return message;
  }
}
