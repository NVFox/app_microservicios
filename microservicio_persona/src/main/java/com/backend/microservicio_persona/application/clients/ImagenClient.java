package com.backend.microservicio_persona.application.clients;

import com.backend.microservicio_persona.application.clients.config.ImagenClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "imagen-service", configuration = ImagenClientConfig.class,
        path = "/imagenes")
public interface ImagenClient {

    @DeleteMapping("/persona/{persona}")
    public ResponseEntity<Void> deleteByPersona(@PathVariable UUID persona);

}