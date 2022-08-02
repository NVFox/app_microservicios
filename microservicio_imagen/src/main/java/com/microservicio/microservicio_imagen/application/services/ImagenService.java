package com.microservicio.microservicio_imagen.application.services;

import java.util.List;
import java.util.UUID;

public interface ImagenService<T, ID> {

    List<T> getAll();

    List<T> getAllByPersona(UUID id);

    T getById(ID id);

    T create(T entity);

    T update(ID id, T entity);

    void delete(ID id);

    void deleteByPersona(UUID id);

}
