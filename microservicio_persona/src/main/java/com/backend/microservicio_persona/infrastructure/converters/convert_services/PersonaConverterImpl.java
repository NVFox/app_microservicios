package com.backend.microservicio_persona.infrastructure.converters.convert_services;

import com.backend.microservicio_persona.application.services.PersonaService;
import com.backend.microservicio_persona.domain.entities.Persona;
import com.backend.microservicio_persona.infrastructure.converters.dto.PersonaDto;
import com.backend.microservicio_persona.infrastructure.converters.mappers.PersonaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonaConverterImpl implements PersonaConverter {

    @Autowired
    private PersonaService<Persona, UUID> service;

    @Autowired
    private PersonaMapper mapper;

    @Override
    public List<PersonaDto> getAll() {
        return mapper.toDtoList(service.getAll());
    }

    @Override
    public PersonaDto getById(UUID id) {
        return mapper.toDto(service.getById(id));
    }

    @Override
    public PersonaDto create(PersonaDto entity) {
        Persona newEntity = mapper.toBaseObject(entity);
        return mapper.toDto(service.create(newEntity));
    }

    @Override
    public void update(UUID id, PersonaDto entity) {
        service.update(id, mapper.toBaseObject(entity));
    }

    @Override
    public void delete(UUID id) {
        service.delete(id);
    }
}
