package com.starwars.backend.domain.port;

import java.util.List;

import com.starwars.backend.infrastructure.exceptions.StarWarsException;

public interface ResourceConnector<T> {
  List<T> getResourceByEntityName(final String orderBy, final String field, final String entityName, final Class<T> entityClass)
      throws StarWarsException;
}
