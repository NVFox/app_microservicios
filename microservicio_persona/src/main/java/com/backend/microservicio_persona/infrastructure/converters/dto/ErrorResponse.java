package com.backend.microservicio_persona.infrastructure.converters.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Builder
public @Data class ErrorResponse {

    private int status;

    private String message;

    private Date timestamp;

    private List<String> errors;

}
