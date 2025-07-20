package com.starwars.backend.infrastructure.connector;

import java.lang.reflect.Method;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.starwars.backend.domain.port.ResourceConnector;
import com.starwars.backend.infrastructure.exceptions.StarWarsException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ResourceConnectorImpl<T> implements ResourceConnector<T> {

  private final RestTemplate restTemplate;

  @Value("${swapi.base-url}")
  private String baseUrl;

  public ResourceConnectorImpl(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public List<T> getResourceByEntityName(final String orderBy, final String field, final String entityName, final Class<T> entityClass)
      throws StarWarsException {
    final String quote = restTemplate.getForObject(baseUrl + entityName, String.class);
    final ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
    List<T> entities;
    try {
      entities = objectMapper.readValue(quote, objectMapper.getTypeFactory().constructCollectionType(List.class, entityClass));
    } catch (Exception e) {
      throw new StarWarsException("Error when parsing entities. ", e, field, orderBy);
    }
    return entities.stream()
        .sorted((s1, s2) -> {
          try {
            final Method getter = entityClass.getMethod(field);
            final Comparable<T> value1 = (Comparable<T>) getter.invoke(s1);
            final Comparable<T> value2 = (Comparable<T>) getter.invoke(s2);
            int comparison = value1.compareTo((T) value2);
            return "DESC".equalsIgnoreCase(orderBy) ? -comparison : comparison;
          } catch (Exception e) {
            throw new IllegalArgumentException("Error when sorting entities. ", e);
          }
        })
        .toList();
  }
}