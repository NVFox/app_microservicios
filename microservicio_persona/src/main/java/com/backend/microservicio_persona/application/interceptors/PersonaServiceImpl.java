package com.backend.microservicio_persona.application.interceptors;

import com.backend.microservicio_persona.application.repositories.PersonaRepository;
import com.backend.microservicio_persona.application.services.PersonaService;
import com.backend.microservicio_persona.domain.entities.Persona;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class PersonaServiceImpl implements PersonaService<Persona, UUID> {

    @Autowired
    private PersonaRepository repository;

    @Override
    public List<Persona> getAll() {
        return repository.findAll();
    }

    @Override
    public Persona getById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Persona create(Persona entity) {
        return repository.save(entity);
    }

    @Override
    public void update(Persona entity) {
        repository.save(entity);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

}
