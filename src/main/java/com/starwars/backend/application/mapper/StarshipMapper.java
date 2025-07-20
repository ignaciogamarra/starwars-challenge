package com.starwars.backend.application.mapper;

import java.util.List;

import com.starwars.backend.application.dto.StarshipDTO;
import com.starwars.backend.domain.model.Starship;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StarshipMapper {
  List<StarshipDTO> toDTOList(List<Starship> starship);
}
