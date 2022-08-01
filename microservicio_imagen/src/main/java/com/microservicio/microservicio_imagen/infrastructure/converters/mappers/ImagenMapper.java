package com.microservicio.microservicio_imagen.infrastructure.converters.mappers;

import com.microservicio.microservicio_imagen.domain.entities.Imagen;
import com.microservicio.microservicio_imagen.infrastructure.converters.dto.ImagenDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ImagenMapper {

    List<ImagenDto> toDtoList (List<Imagen> baseObjects);

    List<Imagen> toBaseObjectList (List<ImagenDto> dtos);

    ImagenDto toDto (Imagen baseObject);

    Imagen toBaseObject (ImagenDto dto);

}
