package com.backend.microservicio_persona.application.repositories;

import com.backend.microservicio_persona.domain.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, UUID> {
}
