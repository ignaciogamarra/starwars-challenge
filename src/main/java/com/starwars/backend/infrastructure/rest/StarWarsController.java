package com.starwars.backend.infrastructure.rest;
import java.util.List;

import com.starwars.backend.application.dto.PeopleDTO;
import com.starwars.backend.application.dto.StarshipDTO;
import com.starwars.backend.application.service.StarWarsService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})

@RestController
public class StarWarsController {

  private final StarWarsService starWarsService;

  public StarWarsController(StarWarsService starWarsService) {
    this.starWarsService = starWarsService;
  }

  @CrossOrigin(origins = "http://localhost:6969")
  @GetMapping("/starships")
  public List<StarshipDTO> getStarships(final @RequestParam(defaultValue = "ASC") String orderBy,
      final @RequestParam (defaultValue = "name") String field) {
    return starWarsService.getStarships(orderBy, field);
  }

  @CrossOrigin(origins = "http://localhost:6969")
  @GetMapping("/people")
  public List<PeopleDTO> getPeople(final @RequestParam(defaultValue = "ASC") String orderBy,
      final @RequestParam (defaultValue = "name") String field) {
    return starWarsService.getPeople(orderBy, field);
  }
}
