package com.backend.microservicio_persona.application.services;

import java.util.List;

public interface PersonaService<T, ID> {

    List<T> getAll();

    T getById(ID id);

    T create(T entity);

    void update(T entity);

    void delete(ID id);

}
