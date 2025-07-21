package com.starwars.backend.infrastructure.rest.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParamValidatorTest {

  @Test
  @DisplayName("GIVEN a valid people field WHEN validated THEN no exception is thrown")
  void test_validatePeopleField_ok() {
    assertDoesNotThrow(() -> ParamValidator.validatePeopleField("name"));
  }

  @Test
  @DisplayName("GIVEN an invalid people field WHEN validated THEN IllegalArgumentException is thrown")
  void test_validatePeopleField_ko() {
    assertThrows(IllegalArgumentException.class, () -> ParamValidator.validatePeopleField("invalidField"));
  }

  @Test
  @DisplayName("GIVEN a valid starship field WHEN validated THEN no exception is thrown")
  void test_validateStarshipField_ok() {
    assertDoesNotThrow(() -> ParamValidator.validateStarshipField("model"));
  }

  @Test
  @DisplayName("GIVEN an invalid starship field WHEN validated THEN IllegalArgumentException is thrown")
  void test_validateStarshipField_ko() {
    assertThrows(IllegalArgumentException.class, () -> ParamValidator.validateStarshipField("invalidField"));
  }

  @Test
  @DisplayName("GIVEN a valid orderBy value WHEN validated THEN no exception is thrown")
  void test_validateOrderBy_ok() {
    assertDoesNotThrow(() -> ParamValidator.validateOrderBy("ASC"));
    assertDoesNotThrow(() -> ParamValidator.validateOrderBy("DESC"));
  }

  @Test
  @DisplayName("GIVEN an invalid orderBy value WHEN validated THEN IllegalArgumentException is thrown")
  void test_validateOrderBy_ko() {
    assertThrows(IllegalArgumentException.class, () -> ParamValidator.validateOrderBy("INVALID"));
  }
}