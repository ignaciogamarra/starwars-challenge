package com.starwars.backend.infrastructure.rest;

import com.starwars.backend.application.dto.PeopleDTO;
import com.starwars.backend.application.dto.StarshipDTO;
import com.starwars.backend.application.service.StarWarsService;
import com.starwars.backend.application.util.MockBuilderUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class StarWarsApiControllerIntegrationTest {

  @Autowired
  private MockMvc mockMvc;

  @MockitoBean
  private StarWarsService starWarsService;

  @DisplayName("GIVEN a valid request to get starships WHEN the service returns data THEN the response is correct")
  @Test
  void test_getStarships_ok() throws Exception {
    List<StarshipDTO> starships = List.of(MockBuilderUtils.createStarshipDTO());

    when(starWarsService.getStarships("ASC", "name")).thenReturn(starships);

    mockMvc.perform(get("/starships")
            .param("orderBy", "ASC")
            .param("field", "name"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.length()").value(2))
        .andExpect(jsonPath("$[0].name").value("A-wing"))
        .andExpect(jsonPath("$[1].name").value("AA-9 Coruscant freighter"));
  }

  @DisplayName("GIVEN a valid request to get people WHEN the service returns data THEN the response is correct")
  @Test
  void test_getPeople_ok() throws Exception {
    List<PeopleDTO> people = List.of(MockBuilderUtils.createPeopleDTO());

    when(starWarsService.getPeople("ASC", "name")).thenReturn(people);

    mockMvc.perform(get("/people")
            .param("orderBy", "ASC")
            .param("field", "name"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.length()").value(2))
        .andExpect(jsonPath("$[0].name").value("Ackbar"))
        .andExpect(jsonPath("$[1].name").value("Adi Gallia"));
  }

  @DisplayName("GIVEN a request to get starships WHEN the service throws an exception THEN the response is an error")
  @Test
  void test_getStarships_error() throws Exception {
    when(starWarsService.getStarships("ASC", "name"))
        .thenThrow(new RuntimeException("Error when fetching starships"));

    mockMvc.perform(get("/starships")
            .param("orderBy", "ASC")
            .param("field", "name"))
        .andExpect(status().isInternalServerError())
        .andExpect(jsonPath("$.error").value("Error when fetching starships"));
  }

  @DisplayName("GIVEN a request to get people WHEN the service throws an exception THEN the response is an error")
  @Test
  void test_getPeople_error() throws Exception {
    when(starWarsService.getPeople("ASC", "name"))
        .thenThrow(new RuntimeException("Error when fetching people"));

    mockMvc.perform(get("/people")
            .param("orderBy", "ASC")
            .param("field", "name"))
        .andExpect(status().isInternalServerError())
        .andExpect(jsonPath("$.error").value("Error when fetching people"));
  }
}