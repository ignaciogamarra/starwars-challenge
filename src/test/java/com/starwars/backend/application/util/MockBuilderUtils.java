package com.starwars.backend.application.util;

import java.util.List;

import com.starwars.backend.application.dto.PeopleDTO;
import com.starwars.backend.application.dto.StarshipDTO;
import com.starwars.backend.domain.model.People;
import com.starwars.backend.domain.model.Starship;

public class MockBuilderUtils {

  public static Starship createStarship() {
    return Starship.builder()
            .name("A-wing")
            .model("RZ-1 A-wing Interceptor")
            .manufacturer("Alliance Underground Engineering, Incom Corporation")
            .costInCredits("175000")
            .length("9.6")
            .maxAtmospheringSpeed("1300")
            .crew("1")
            .passengers("0")
            .cargoCapacity("40")
            .consumables("1 week")
            .hyperdriveRating("1.0")
            .MGLT("120")
            .starshipClass("Starfighter")
            .pilots(List.of("https://swapi.info/api/people/29"))
            .films(List.of("https://swapi.info/api/films/3"))
            .build();
  }

  public static StarshipDTO createStarshipDTO() {
    return StarshipDTO.builder()
            .name("A-wing")
            .model("RZ-1 A-wing Interceptor")
            .manufacturer("Alliance Underground Engineering, Incom Corporation")
            .costInCredits("175000")
            .length("9.6")
            .maxAtmospheringSpeed("1300")
            .crew("1")
            .passengers("0")
            .cargoCapacity("40")
            .consumables("1 week")
            .hyperdriveRating("1.0")
            .MGLT("120")
            .starshipClass("Starfighter")
            .pilots(List.of("https://swapi.info/api/people/29"))
            .films(List.of("https://swapi.info/api/films/3"))
            .build();

  }

  public static StarshipDTO createStarshipDTO2() {
    return StarshipDTO.builder()
            .name("AA-9 Coruscant freighter")
            .model("RZ-1 A-wing Interceptor")
            .manufacturer("Alliance Underground Engineering, Incom Corporation")
            .costInCredits("175000")
            .length("9.6")
            .maxAtmospheringSpeed("1300")
            .crew("1")
            .passengers("0")
            .cargoCapacity("40")
            .consumables("1 week")
            .hyperdriveRating("1.0")
            .MGLT("120")
            .starshipClass("Starfighter")
            .pilots(List.of("https://swapi.info/api/people/29"))
            .films(List.of("https://swapi.info/api/films/3"))
            .build();

  }

  public static PeopleDTO createPeopleDTO() {
    return PeopleDTO.builder()
            .name("Ackbar")
            .height("180")
            .mass("83")
            .hairColor("none")
            .skinColor("brown mottle")
            .eyeColor("orange")
            .birthYear("41BBY")
            .gender("male")
            .homeworld("https://swapi.info/api/planets/31")
            .films(List.of("https://swapi.info/api/films/3"))
            .species(List.of("https://swapi.info/api/species/8"))
            .vehicles(List.of())
            .starships(List.of())
            .build();
  }

  public static PeopleDTO createPeopleDTO2() {
    return PeopleDTO.builder()
            .name("Adi Gallia")
            .height("180")
            .mass("83")
            .hairColor("none")
            .skinColor("brown mottle")
            .eyeColor("orange")
            .birthYear("41BBY")
            .gender("male")
            .homeworld("https://swapi.info/api/planets/31")
            .films(List.of("https://swapi.info/api/films/3"))
            .species(List.of("https://swapi.info/api/species/8"))
            .vehicles(List.of())
            .starships(List.of())
            .build();
  }


  public static People createPeople() {
    return People.builder()
            .name("Ackbar")
            .height("180")
            .mass("83")
            .hairColor("none")
            .skinColor("brown mottle")
            .eyeColor("orange")
            .birthYear("41BBY")
            .gender("male")
            .homeworld("https://swapi.info/api/planets/31")
            .films(List.of("https://swapi.info/api/films/3"))
            .species(List.of("https://swapi.info/api/species/8"))
            .vehicles(List.of())
            .starships(List.of())
            .build();
  }
}
