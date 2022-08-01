package com.microservicio.microservicio_imagen.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public @Data class Persona {

    private UUID id;
    private String nombre;
    private String apellido;
    private String sexo;
    private Integer edad;

}
