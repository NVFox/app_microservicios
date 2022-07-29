package com.backend.microservicio_persona.infrastructure.converters.dto;

import com.backend.microservicio_persona.infrastructure.converters.validation.OnCreate;
import com.backend.microservicio_persona.infrastructure.converters.validation.OnUpdate;

import java.util.UUID;
import javax.validation.constraints.*;

public class PersonaDto {
    @Null(groups = {OnCreate.class, OnUpdate.class},
            message = "El id debe ser nulo")
    private UUID id;

    @NotNull(groups = {OnCreate.class},
            message = "Nombre no puede ser nulo")
    @Size(min = 2, groups = {OnCreate.class, OnUpdate.class},
            message = "Nombre tiene que tener más de 1 carácter")
    private String nombre;

    @NotNull(groups = {OnCreate.class},
            message = "Apellido no puede ser nulo")
    @Size(min = 2, groups = {OnCreate.class, OnUpdate.class},
            message = "Apellido tiene que tener más de 1 carácter")
    private String apellido;

    @NotNull(groups = {OnCreate.class},
            message = "Sexo no puede ser nulo")
    @Size(min = 2, groups = {OnCreate.class, OnUpdate.class},
            message = "Sexo tiene que tener al menos 1 carácter")
    private String sexo;

    @NotNull(groups = {OnCreate.class},
            message = "Edad no puede ser nulo")
    @Min(value = 18, groups = {OnCreate.class, OnUpdate.class},
            message = "Debe ser mayor de edad")
    private Integer edad;
}