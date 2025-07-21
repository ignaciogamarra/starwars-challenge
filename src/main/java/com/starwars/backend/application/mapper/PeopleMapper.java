package com.starwars.backend.application.mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.starwars.backend.application.dto.PeopleDTO;
import com.starwars.backend.domain.model.People;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface PeopleMapper {

    @Mapping(source = "created", target = "created", qualifiedByName = "formatDate")
    PeopleDTO toDto(People people);

    @Named("formatDate")
    static String formatDate(String date) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return LocalDateTime.parse(date, inputFormatter).format(outputFormatter);
    }
}
