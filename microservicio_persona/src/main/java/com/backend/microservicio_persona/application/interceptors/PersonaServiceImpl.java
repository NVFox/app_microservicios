package com.backend.microservicio_persona.application.interceptors;

import com.backend.microservicio_persona.application.clients.ImagenClient;
import com.backend.microservicio_persona.application.exceptions.NoChangeDetectedException;
import com.backend.microservicio_persona.application.exceptions.NoSuchElementException;
import com.backend.microservicio_persona.application.exceptions.NotEnoughAgeException;
import com.backend.microservicio_persona.application.exceptions.NotFoundException;
import com.backend.microservicio_persona.application.repositories.PersonaRepository;
import com.backend.microservicio_persona.application.services.PersonaService;
import com.backend.microservicio_persona.domain.entities.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonaServiceImpl implements PersonaService<Persona, UUID> {

    @Autowired
    private PersonaRepository repository;

    @Autowired
    private ImagenClient imagenClient;

    @Override
    public List<Persona> getAll() {
        return repository.findAll();
    }

    @Override
    public Persona getById(UUID id) {
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public Persona create(Persona entity) {
        if (entity.getEdad() < 18)
            throw new NotEnoughAgeException();

        return repository.save(entity);
    }

    @Override
    public void update(UUID id, Persona entity) {
        entity.setId(id);
        Optional<Persona> previousEntity = repository.findById(id);

        if (entity.getEdad() < 18)
            throw new NotEnoughAgeException();

        if (previousEntity.isEmpty())
            throw new NoSuchElementException();

        if (entity.equals(previousEntity.get()))
            throw new NoChangeDetectedException();

        repository.save(entity);
    }

    @Override
    public void delete(UUID id) {
        Optional<Persona> previousEntity = repository.findById(id);

        if (previousEntity.isEmpty())
            throw new NoSuchElementException();

        repository.deleteById(id);
        imagenClient.deleteByPersona(id);
    }

}
