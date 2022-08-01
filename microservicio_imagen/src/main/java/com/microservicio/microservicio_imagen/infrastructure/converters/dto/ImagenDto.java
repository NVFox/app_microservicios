package com.microservicio.microservicio_imagen.infrastructure.converters.dto;

import com.microservicio.microservicio_imagen.infrastructure.converters.validation.OnCreate;
import com.microservicio.microservicio_imagen.infrastructure.converters.validation.OnUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public @Data class ImagenDto {

    @Null(groups = {OnCreate.class, OnUpdate.class})
    private String id;

    private String nombre;

    @NotNull(groups = {OnCreate.class},
            message = "Nombre no puede ser nulo")
    private String archivo;

    private UUID persona;

}
