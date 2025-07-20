package com.starwars.backend.domain.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record Starship(
    @JsonProperty("name") String name,
    @JsonProperty("model") String model,
    @JsonProperty("manufacturer") String manufacturer,
    @JsonProperty("cost_in_credits") String costInCredits,
    @JsonProperty("length") String length,
    @JsonProperty("max_atmosphering_speed") String maxAtmospheringSpeed,
    @JsonProperty("crew") String crew,
    @JsonProperty("passengers") String passengers,
    @JsonProperty("cargo_capacity") String cargoCapacity,
    @JsonProperty("consumables") String consumables,
    @JsonProperty("hyperdrive_rating") String hyperdriveRating,
    @JsonProperty("MGLT") String MGLT,
    @JsonProperty("starship_class") String starshipClass,
    @JsonProperty("pilots") List<String> pilots,
    @JsonProperty("films") List<String> films,
    @JsonProperty("created") String created,
    @JsonProperty("edited") String edited,
    @JsonProperty("url") String url
) {}