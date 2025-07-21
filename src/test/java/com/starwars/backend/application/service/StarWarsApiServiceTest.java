package com.starwars.backend.application.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.List;

import com.starwars.backend.application.dto.PeopleDTO;
import com.starwars.backend.application.dto.StarshipDTO;
import com.starwars.backend.application.mapper.PeopleMapper;
import com.starwars.backend.application.mapper.StarshipMapper;
import com.starwars.backend.application.util.MockBuilderUtils;
import com.starwars.backend.domain.model.People;
import com.starwars.backend.domain.model.Starship;
import com.starwars.backend.infrastructure.connector.ResourceConnectorImpl;
import com.starwars.backend.infrastructure.exceptions.StarWarsException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class StarWarsApiServiceTest {

  @Mock
  private ResourceConnectorImpl<Starship> starshipConnector;
  @Mock
  private ResourceConnectorImpl<People> peopleConnector;
  @Mock
  private StarshipMapper starshipMapper;
  @Mock
  private PeopleMapper peopleMapper;

  @InjectMocks
  private StarWarsService starWarsService;

  @DisplayName("GIVEN a valid parameters orderBy and field WHEN getStarships is called THEN return a list of StarshipDTO")
  @Test
  void test_getStarships_ok() throws StarWarsException {
    when(this.starshipConnector.getResourceByEntityName(anyString(), anyString(), eq("starships"), eq(Starship.class)))
        .thenReturn(List.of(MockBuilderUtils.createStarship()));

    when(this.starshipMapper.toDTO(any(Starship.class))).thenReturn(MockBuilderUtils.createStarshipDTO());

    final List<StarshipDTO> starshipDTOs = this.starWarsService.getStarships("ASC", "name");
    assertThat(starshipDTOs).usingRecursiveComparison().isEqualTo(List.of(MockBuilderUtils.createStarshipDTO()));
  }

  @DisplayName("GIVEN a valid parameters orderBy and field WHEN getPeople is called THEN return a list of PeopleDTO")
  @Test
  void test_getPeople_ok() throws StarWarsException {
    when(this.peopleConnector.getResourceByEntityName(anyString(), anyString(), eq("people"), eq(People.class)))
        .thenReturn(List.of(MockBuilderUtils.createPeople()));

    when(this.peopleMapper.toDto(any(People.class))).thenReturn(MockBuilderUtils.createPeopleDTO());

    final List<PeopleDTO> peopleDTOs = this.starWarsService.getPeople("ASC", "name");
    assertThat(peopleDTOs).usingRecursiveComparison().isEqualTo(List.of(MockBuilderUtils.createPeopleDTO()));
  }
}