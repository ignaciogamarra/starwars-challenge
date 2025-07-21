package com.starwars.backend.infrastructure.rest.validator;

import java.util.List;

import lombok.experimental.UtilityClass;
import org.apache.logging.log4j.util.Strings;

@UtilityClass
public class ParamValidator {

  private static final List<String> VALID_ORDER_BY_VALUES = List.of("ASC", "DESC");

  private static List<String> VALID_STARSHIP_FIELDS = List.of(
      "name",
      "model",
      "manufacturer",
      "costInCredits",
      "length",
      "maxAtmospheringSpeed",
      "crew",
      "passengers",
      "cargoCapacity",
      "consumables",
      "hyperdriveRating",
      "MGLT",
      "starshipClass",
      "created",
      "edited",
      "url"
  );

  private static List<String> VALID_PEOPLE_FIELDS = List.of(
      "name",
      "height",
      "mass",
      "hairColor",
      "skinColor",
      "eyeColor",
      "birthYear",
      "gender",
      "homeworld",
      "created",
      "edited",
      "url"
  );

  public static void validatePeopleField(final String field) {
    if (Strings.isEmpty(field) || !VALID_PEOPLE_FIELDS.contains(field)) {
      throw new IllegalArgumentException(
          String.format("Invalid field name: %s. Valid fields are: %s", field, VALID_PEOPLE_FIELDS));
    }
  }

  public static void validateStarshipField(final String field) {
    if (Strings.isEmpty(field) || !VALID_STARSHIP_FIELDS.contains(field)) {
      throw new IllegalArgumentException(
          String.format("Invalid field name: %s. Valid fields are: %s", field, VALID_STARSHIP_FIELDS));
    }
  }

  public static void validateOrderBy(final String orderBy) {
    if (Strings.isEmpty(orderBy) || !VALID_ORDER_BY_VALUES.contains(orderBy)) {
      throw new IllegalArgumentException(
          String.format("Invalid order by value: %s. Valid values are: %s", orderBy, VALID_ORDER_BY_VALUES));
    }
  }

}
