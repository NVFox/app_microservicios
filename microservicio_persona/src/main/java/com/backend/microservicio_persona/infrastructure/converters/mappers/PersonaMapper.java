package com.backend.microservicio_persona.infrastructure.converters.mappers;

import com.backend.microservicio_persona.domain.entities.Persona;
import com.backend.microservicio_persona.infrastructure.converters.dto.PersonaDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonaMapper {

    List<PersonaDto> toDtoList (List<Persona> baseObjects);

    List<Persona> toBaseObjectList (List<PersonaDto> dtos);

    PersonaDto toDto (Persona baseObject);

    Persona toBaseObject (PersonaDto dto);

}
