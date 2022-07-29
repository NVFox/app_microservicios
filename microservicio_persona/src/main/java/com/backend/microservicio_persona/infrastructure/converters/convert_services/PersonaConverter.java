package com.backend.microservicio_persona.infrastructure.converters.convert_services;

import com.backend.microservicio_persona.domain.entities.Persona;
import com.backend.microservicio_persona.infrastructure.converters.dto.PersonaDto;

import java.util.List;
import java.util.UUID;

public interface PersonaConverter {

    List<PersonaDto> getAll();

    PersonaDto getById(UUID id);

    PersonaDto create(PersonaDto entity);

    void update(UUID id, PersonaDto entity);

    void delete(UUID id);

}
