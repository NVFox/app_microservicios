package com.microservicio.microservicio_imagen.infrastructure.converters.convert_services;

import com.microservicio.microservicio_imagen.infrastructure.converters.dto.ImagenDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface ImagenConverter {

    List<ImagenDto> getAll();

    List<ImagenDto> getAllByPersona(UUID id);

    ImagenDto getById(String id);

    ImagenDto create(UUID idPersona, MultipartFile file) throws IOException;

    void update(String id, UUID idPersona, MultipartFile file)
            throws IOException;

    void delete(String id);

}
