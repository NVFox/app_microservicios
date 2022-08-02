package com.microservicio.microservicio_imagen.infrastructure.controllers;

import com.microservicio.microservicio_imagen.infrastructure.converters.convert_services.ImagenConverter;
import com.microservicio.microservicio_imagen.infrastructure.converters.dto.ImagenDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/imagenes")
public class ImagenController {

    @Autowired
    private ImagenConverter service;

    @GetMapping
    public ResponseEntity<List<ImagenDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/persona/{persona}")
    public ResponseEntity<List<ImagenDto>> getAllByPersona(@PathVariable UUID persona) {
        return ResponseEntity.ok(service.getAllByPersona(persona));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImagenDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<ImagenDto> create(
            @RequestParam UUID persona,
            @RequestPart MultipartFile file) throws IOException
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(persona, file));
    }

    @PutMapping(value = "/{id}", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<ImagenDto> update(
            @PathVariable String id,
            @RequestParam(value = "persona", required = false) UUID persona,
            @RequestPart(required = false) MultipartFile file) throws IOException
    {
        service.update(id, persona, file);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @DeleteMapping("/persona/{persona}")
    public ResponseEntity<Void> deleteByPersona(@PathVariable UUID persona) {
        service.deleteByPersona(persona);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}