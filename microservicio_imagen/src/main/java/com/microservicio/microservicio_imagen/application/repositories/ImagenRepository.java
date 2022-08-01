package com.microservicio.microservicio_imagen.application.repositories;

import com.microservicio.microservicio_imagen.domain.entities.Imagen;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ImagenRepository extends MongoRepository<Imagen, String> {

    List<Imagen> findByPersona(UUID id);

}