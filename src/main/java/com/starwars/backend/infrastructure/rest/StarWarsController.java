package com.starwars.backend.infrastructure.rest;
import java.util.List;

import com.starwars.backend.application.dto.PeopleDTO;
import com.starwars.backend.application.dto.StarshipDTO;
import com.starwars.backend.application.service.StarWarsService;
import com.starwars.backend.infrastructure.rest.validator.ParamValidator;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
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

  @GetMapping("/starships")
  public List<StarshipDTO> getStarships(final @RequestParam(defaultValue = "ASC") String orderBy,
      final @RequestParam (defaultValue = "name") String field) {
    ParamValidator.validateOrderBy(orderBy);
    ParamValidator.validateStarshipField(field);
    return starWarsService.getStarships(orderBy, field);
  }

  @GetMapping("/people")
  public List<PeopleDTO> getPeople(final @RequestParam(defaultValue = "ASC") String orderBy,
      final @RequestParam (defaultValue = "name") String field) {
    ParamValidator.validateOrderBy(orderBy);
    ParamValidator.validatePeopleField(field);
    return starWarsService.getPeople(orderBy, field);
  }
}
