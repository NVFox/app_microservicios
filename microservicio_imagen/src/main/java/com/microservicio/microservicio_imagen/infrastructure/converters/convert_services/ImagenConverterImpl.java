package com.microservicio.microservicio_imagen.infrastructure.converters.convert_services;

import com.microservicio.microservicio_imagen.application.services.ImagenService;
import com.microservicio.microservicio_imagen.domain.entities.Imagen;
import com.microservicio.microservicio_imagen.infrastructure.converters.convert_services.imagen.IImageProcessor;
import com.microservicio.microservicio_imagen.infrastructure.converters.dto.ImagenDto;
import com.microservicio.microservicio_imagen.infrastructure.converters.mappers.ImagenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class ImagenConverterImpl implements ImagenConverter {

    @Autowired
    private ImagenMapper mapper;

    @Autowired
    private IImageProcessor<String, MultipartFile> processor;

    @Autowired
    private ImagenService<Imagen, String> service;

    @Override
    public List<ImagenDto> getAll() {
        return mapper.toDtoList(service.getAll());
    }

    @Override
    public List<ImagenDto> getAllByPersona(UUID id) {
        return mapper.toDtoList(service.getAllByPersona(id));
    }

    @Override
    public ImagenDto getById(String id) {
        return mapper.toDto(service.getById(id));
    }

    @Override
    public ImagenDto create(UUID idPersona, MultipartFile file) throws IOException {

        Imagen newEntity = Imagen.builder()
                .nombre(file.getOriginalFilename())
                .archivo(processor.getImage(file))
                .persona(idPersona)
                .build();

        return mapper.toDto(service.create(newEntity));
    }

    @Override
    public void update(String id, UUID idPersona, MultipartFile file) throws IOException {
        Imagen previousEntity = service.getById(id);

        Imagen newEntity = Imagen.builder()
                .id(id)
                .nombre(file == null
                        ? previousEntity.getNombre()
                        : file.getOriginalFilename())
                .archivo(file == null
                        ? previousEntity.getArchivo()
                        : processor.getImage(file))
                .persona(idPersona == null
                        ? previousEntity.getPersona()
                        : idPersona)
                .build();

        service.update(id, newEntity);
    }

    @Override
    public void delete(String id) {
        service.delete(id);
    }
}
