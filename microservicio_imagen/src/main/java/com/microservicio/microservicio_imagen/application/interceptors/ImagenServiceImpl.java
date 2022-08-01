package com.microservicio.microservicio_imagen.application.interceptors;

import com.microservicio.microservicio_imagen.application.clients.PersonaClient;
import com.microservicio.microservicio_imagen.application.exceptions.NoChangeDetectedException;
import com.microservicio.microservicio_imagen.application.exceptions.NoSuchElementException;
import com.microservicio.microservicio_imagen.application.exceptions.NotFoundException;
import com.microservicio.microservicio_imagen.application.repositories.ImagenRepository;
import com.microservicio.microservicio_imagen.application.services.ImagenService;
import com.microservicio.microservicio_imagen.domain.entities.Imagen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ImagenServiceImpl implements ImagenService<Imagen, String> {

    @Autowired
    private ImagenRepository repository;

    @Autowired
    private PersonaClient personaClient;

    @Override
    public List<Imagen> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Imagen> getAllByPersona(UUID id) {
        personaClient.getById(id);
        return repository.findByPersona(id);
    }

    @Override
    public Imagen getById(String s) {
        return repository.findById(s)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public Imagen create(Imagen entity) {
        personaClient.getById(entity.getPersona());
        return repository.save(entity);
    }

    @Override
    public Imagen update(String s, Imagen entity) {
        entity.setId(s);
        personaClient.getById(entity.getPersona());
        Optional<Imagen> previousEntity = repository.findById(s);

        if (previousEntity.isEmpty())
            throw new NoSuchElementException();

        if (entity.equals(previousEntity.get()))
            throw new NoChangeDetectedException();

        return repository.save(entity);
    }

    @Override
    public void delete(String s) {
        Optional<Imagen> previousEntity = repository.findById(s);

        if (previousEntity.isEmpty())
            throw new NoSuchElementException();

        repository.deleteById(s);
    }

}
