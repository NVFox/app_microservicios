package com.microservicio.microservicio_imagen.application.clients;

import com.microservicio.microservicio_imagen.domain.model.Persona;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "persona-service", configuration = PersonaClientConfig.class,
        path = "/personas")
public interface PersonaClient {

    @GetMapping("/{id}")
    public ResponseEntity<Persona> getById(@PathVariable UUID id);

}