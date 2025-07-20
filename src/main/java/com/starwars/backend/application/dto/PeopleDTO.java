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
public class PeopleDTO {
  private String name;
  private String height;
  private String mass;
  private String hairColor;
  private String skinColor;
  private String eyeColor;
  private String birthYear;
  private String gender;
  private String homeworld;
  private List<String> films;
  private List<String> species;
  private List<String> vehicles;
  private List<String> starships;

}
