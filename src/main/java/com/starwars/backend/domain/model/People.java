package com.starwars.backend.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;

@Builder
public record People(
    @JsonProperty("name") String name,
    @JsonProperty("height") String height,
    @JsonProperty("mass") String mass,
    @JsonProperty("hair_color") String hairColor,
    @JsonProperty("skin_color") String skinColor,
    @JsonProperty("eye_color") String eyeColor,
    @JsonProperty("birth_year") String birthYear,
    @JsonProperty("gender") String gender,
    @JsonProperty("homeworld") String homeworld,
    @JsonProperty("films") List<String> films,
    @JsonProperty("species") List<String> species,
    @JsonProperty("vehicles") List<String> vehicles,
    @JsonProperty("starships") List<String> starships,
    @JsonProperty("created") String created,
    @JsonProperty("edited") String edited,
    @JsonProperty("url") String url
) {}
