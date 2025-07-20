package com.starwars.backend.application.mapper;

import java.util.List;

import com.starwars.backend.application.dto.PeopleDTO;
import com.starwars.backend.domain.model.People;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PeopleMapper {
    List<PeopleDTO> toDtoList(List<People> people);
}
