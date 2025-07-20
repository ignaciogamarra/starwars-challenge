package com.starwars.backend.infrastructure.connector;

import com.starwars.backend.domain.model.People;
import com.starwars.backend.infrastructure.exceptions.StarWarsException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ResourceConnectorImplTest {

  @Mock
  private RestTemplate restTemplate;

  @InjectMocks
  private ResourceConnectorImpl<People> resourceConnector;

  @Test
  @DisplayName("GIVEN valid entityName and entityClass WHEN getResourceByEntityName is called THEN return sorted list")
  void test_whenGetResourceByEntityNameCorrectOrder_ok() throws StarWarsException {
    final String entityName = "people";
    final String orderBy = "ASC";
    final String field = "name";
    final String jsonResponse = "[{\"name\":\"Luke\"},{\"name\":\"Leia\"}]";

    when(restTemplate.getForObject(anyString(), eq(String.class))).thenReturn(jsonResponse);

    final List<People> result = resourceConnector.getResourceByEntityName(orderBy, field, entityName, People.class);

    assertNotNull(result);
    assertTrue(result.get(0).name().compareTo(result.get(1).name()) < 0);
    verify(restTemplate, times(1)).getForObject(anyString(), eq(String.class));
  }

  @Test
  @DisplayName("GIVEN invalid JSON response WHEN getResourceByEntityName is called THEN throw StarWarsException")
  void test_InvalidJsonResponse_whenGetResourceByEntityName_ko() {
    String entityName = "people";
    String orderBy = "ASC";
    String field = "name";
    Class<People> entityClass = People.class;
    String invalidJsonResponse = "invalid_json";

    when(restTemplate.getForObject(anyString(), eq(String.class))).thenReturn(invalidJsonResponse);

    assertThrows(StarWarsException.class, () ->
        resourceConnector.getResourceByEntityName(orderBy, field, entityName, entityClass)
    );
    verify(restTemplate, times(1)).getForObject(anyString(), eq(String.class));
  }

  @Test
  @DisplayName("GIVEN invalid field WHEN getResourceByEntityName is called THEN throw RuntimeException")
  void test_InvalidField_whenGetResourceByEntityName_ko() {
    String entityName = "people";
    String orderBy = "ASC";
    String field = "invalidField";
    Class<People> entityClass = People.class;
    String jsonResponse = "[{\"name\":\"Luke\"},{\"name\":\"Leia\"}]";

    when(restTemplate.getForObject(anyString(), eq(String.class))).thenReturn(jsonResponse);

    assertThrows(RuntimeException.class, () ->
        resourceConnector.getResourceByEntityName(orderBy, field, entityName, entityClass)
    );
    verify(restTemplate, times(1)).getForObject(anyString(), eq(String.class));
  }

  @Test
  @DisplayName("GIVEN null response from API WHEN getResourceByEntityName is called THEN throw StarWarsException")
  void test_NullResponseFromApi_whenGetResourceByEntityName_ko() {
    String entityName = "people";
    String orderBy = "ASC";
    String field = "getName";
    Class<People> entityClass = People.class;

    when(restTemplate.getForObject(anyString(), eq(String.class))).thenReturn(null);

    assertThrows(StarWarsException.class, () ->
        resourceConnector.getResourceByEntityName(orderBy, field, entityName, entityClass)
    );
    verify(restTemplate, times(1)).getForObject(anyString(), eq(String.class));
  }
}