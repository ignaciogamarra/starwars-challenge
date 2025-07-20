package com.starwars.backend.application.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StarshipDTO {
  private String name;
  private String model;
  private String manufacturer;
  private String costInCredits;
  private String length;
  private String maxAtmospheringSpeed;
  private String crew;
  private String passengers;
  private String cargoCapacity;
  private String consumables;
  private String hyperdriveRating;
  private String MGLT;
  private String starshipClass;
  private List<String> pilots;
  private List<String> films;
}
