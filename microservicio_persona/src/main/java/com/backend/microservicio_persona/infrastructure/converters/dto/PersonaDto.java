package com.backend.microservicio_persona.infrastructure.converters.dto;

import com.backend.microservicio_persona.infrastructure.converters.validation.OnCreate;
import com.backend.microservicio_persona.infrastructure.converters.validation.OnUpdate;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
import javax.validation.constraints.*;
@AllArgsConstructor
@NoArgsConstructor
@Builder
public @Data class PersonaDto {
    @JsonProperty("id")
    @Null(groups = {OnCreate.class, OnUpdate.class},
            message = "El id debe ser nulo")
    private UUID id;

    @JsonProperty("nombre")
    @NotNull(groups = {OnCreate.class},
            message = "Nombre no puede ser nulo")
    @Size(min = 2, groups = {OnCreate.class, OnUpdate.class},
            message = "Nombre tiene que tener más de 1 carácter")
    private String nombre;

    @JsonProperty("apellido")
    @NotNull(groups = {OnCreate.class},
            message = "Apellido no puede ser nulo")
    @Size(min = 2, groups = {OnCreate.class, OnUpdate.class},
            message = "Apellido tiene que tener más de 1 carácter")
    private String apellido;

    @JsonProperty("sexo")
    @NotNull(groups = {OnCreate.class},
            message = "Sexo no puede ser nulo")
    @Size(min = 2, groups = {OnCreate.class, OnUpdate.class},
            message = "Sexo tiene que tener al menos 1 carácter")
    private String sexo;

    @JsonProperty("edad")
    @NotNull(groups = {OnCreate.class},
            message = "Edad no puede ser nulo")
    @Min(value = 18, groups = {OnCreate.class, OnUpdate.class},
            message = "Debe ser mayor de edad")
    private Integer edad;
}