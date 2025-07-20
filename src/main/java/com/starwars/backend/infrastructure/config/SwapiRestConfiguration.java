package com.starwars.backend.infrastructure.config;

import com.starwars.backend.application.mapper.PeopleMapper;
import com.starwars.backend.application.mapper.StarshipMapper;
import com.starwars.backend.application.service.StarWarsService;
import com.starwars.backend.domain.port.ResourceConnector;
import com.starwars.backend.domain.model.People;
import com.starwars.backend.domain.model.Starship;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SwapiRestConfiguration {

  @Bean
  public RestTemplate restTemplate(final RestTemplateBuilder builder) {
    return builder.build();
  }

  @Bean
  public StarWarsService starWarsService(final ResourceConnector<Starship> starshipConnector,
      final ResourceConnector<People> peopleConnector, final StarshipMapper starshipMapper,
      final PeopleMapper peopleMapper) {
    return new StarWarsService(starshipConnector, peopleConnector, starshipMapper, peopleMapper);
  }
}
