package com.starwars.backend.infrastructure.exceptions;

public class StarWarsException extends Exception  {

  public StarWarsException(final String s, final Exception e, final String field, final String orderBy) {
   super(s + "; field value: " + field + "; orderBy value" + orderBy, e);
  }
}
