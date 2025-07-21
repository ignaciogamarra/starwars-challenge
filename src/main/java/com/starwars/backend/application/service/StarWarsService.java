package com.starwars.backend.application.service;

import java.util.List;
import java.util.stream.Collectors;

import com.starwars.backend.application.dto.PeopleDTO;
import com.starwars.backend.application.dto.StarshipDTO;
import com.starwars.backend.application.mapper.PeopleMapper;
import com.starwars.backend.application.mapper.StarshipMapper;
import com.starwars.backend.domain.port.ResourceConnector;
import com.starwars.backend.domain.model.People;
import com.starwars.backend.domain.model.Starship;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
public class StarWarsService {

  private final ResourceConnector<Starship> starshipConnector;
  private final ResourceConnector<People> peopleConnector;
  private final StarshipMapper starshipMapper;
  private final PeopleMapper peopleMapper;

  public StarWarsService(ResourceConnector<Starship> starshipConnector, ResourceConnector<People> peopleConnector,
      StarshipMapper starshipMapper, PeopleMapper peopleMapper) {
    this.starshipConnector = starshipConnector;
    this.peopleConnector = peopleConnector;
    this.starshipMapper = starshipMapper;
    this.peopleMapper = peopleMapper;
  }

  @SneakyThrows
  public List<StarshipDTO> getStarships(final String orderBy, final String field) {
    final List<Starship> starships = this.starshipConnector.getResourceByEntityName(orderBy, field, "starships", Starship.class);
    return starships.stream().map(this.starshipMapper::toDTO).collect(Collectors.toList());
  }

  @SneakyThrows
  public List<PeopleDTO> getPeople(final String orderBy, final String field) {
    final List<People> people = this.peopleConnector.getResourceByEntityName(orderBy, field, "people", People.class);
    return people.stream().map(this.peopleMapper::toDto).collect(Collectors.toList());
  }
}
