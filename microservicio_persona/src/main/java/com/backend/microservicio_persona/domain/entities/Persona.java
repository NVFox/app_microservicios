package com.backend.microservicio_persona.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity()
@Table(name = "personas")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public @Data class Persona {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    private String sexo;

    @Column(nullable = false)
    private Integer edad;
}
