package com.backend.microservicio_persona.infrastructure.controllers;

import com.backend.microservicio_persona.infrastructure.converters.convert_services.PersonaConverter;
import com.backend.microservicio_persona.infrastructure.converters.dto.PersonaDto;
import com.backend.microservicio_persona.infrastructure.converters.validation.OnCreate;
import com.backend.microservicio_persona.infrastructure.converters.validation.OnUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaConverter service;

    @GetMapping
    public ResponseEntity<List<PersonaDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonaDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<PersonaDto> create(
            @RequestBody @Validated(OnCreate.class) PersonaDto entity
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(
            @PathVariable UUID id,
            @RequestBody @Validated(OnUpdate.class) PersonaDto entity
    ) {
        service.update(id, entity);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

}
