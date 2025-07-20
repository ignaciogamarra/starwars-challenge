package com.starwars.backend.application.util;

import java.util.List;

import com.starwars.backend.application.dto.PeopleDTO;
import com.starwars.backend.application.dto.StarshipDTO;
import com.starwars.backend.domain.model.People;
import com.starwars.backend.domain.model.Starship;

public class MockBuilderUtils {

  public static List<Starship> createStarshipList() {
    return List.of(
        Starship.builder()
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
            .build(),
        Starship.builder()
            .name("AA-9 Coruscant freighter")
            .model("Botajef AA-9 Freighter-Liner")
            .manufacturer("Botajef Shipyards")
            .costInCredits("unknown")
            .length("390")
            .maxAtmospheringSpeed("unknown")
            .crew("unknown")
            .passengers("30000")
            .cargoCapacity("unknown")
            .consumables("unknown")
            .hyperdriveRating("unknown")
            .MGLT("unknown")
            .starshipClass("freighter")
            .pilots(List.of())
            .films(List.of("https://swapi.info/api/films/5"))
            .build()
    );
  }

  public static List<StarshipDTO> createStarshipDTOsList() {
    return List.of(
        StarshipDTO.builder()
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
            .build(),
        StarshipDTO.builder()
            .name("AA-9 Coruscant freighter")
            .model("Botajef AA-9 Freighter-Liner")
            .manufacturer("Botajef Shipyards")
            .costInCredits("unknown")
            .length("390")
            .maxAtmospheringSpeed("unknown")
            .crew("unknown")
            .passengers("30000")
            .cargoCapacity("unknown")
            .consumables("unknown")
            .hyperdriveRating("unknown")
            .MGLT("unknown")
            .starshipClass("freighter")
            .pilots(List.of())
            .films(List.of("https://swapi.info/api/films/5"))
            .build()
    );
  }


  public static List<PeopleDTO> createPeopleDTOsList() {
    return List.of(
        PeopleDTO.builder()
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
            .build(),
        PeopleDTO.builder()
            .name("Adi Gallia")
            .height("184")
            .mass("50")
            .hairColor("none")
            .skinColor("dark")
            .eyeColor("blue")
            .birthYear("unknown")
            .gender("female")
            .homeworld("https://swapi.info/api/planets/9")
            .films(List.of("https://swapi.info/api/films/4", "https://swapi.info/api/films/6"))
            .species(List.of("https://swapi.info/api/species/23"))
            .vehicles(List.of())
            .starships(List.of())
            .build()
    );
  }


  public static List<People> createPeopleList() {
    return List.of(
        People.builder()
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
            .build(),
        People.builder()
            .name("Adi Gallia")
            .height("184")
            .mass("50")
            .hairColor("none")
            .skinColor("dark")
            .eyeColor("blue")
            .birthYear("unknown")
            .gender("female")
            .homeworld("https://swapi.info/api/planets/9")
            .films(List.of("https://swapi.info/api/films/4", "https://swapi.info/api/films/6"))
            .species(List.of("https://swapi.info/api/species/23"))
            .vehicles(List.of())
            .starships(List.of())
            .build()
    );
  }
}
