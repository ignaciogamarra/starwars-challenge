package com.starwars.backend.infrastructure.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(StarWarsException.class)
  public ResponseEntity<ErrorResponse> handleStarWarsException(StarWarsException ex) {
    ErrorResponse errorResponse = new ErrorResponse(
        HttpStatus.INTERNAL_SERVER_ERROR.value(),
        "StarWars Server Error: " + ex.getMessage()
    );
    return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @Getter
  public static class ErrorResponse {
    private final int status;
    private final String message;

    public ErrorResponse(int status, String message) {
      this.status = status;
      this.message = message;
    }

  }
}