package com.backend.microservicio_persona.application.exceptions;

import lombok.Getter;
import org.springframework.validation.BindingResult;

@Getter
public class InvalidDataException extends RuntimeException {

    private BindingResult result;

    public InvalidDataException(BindingResult result) {
        super();
        this.result = result;
    }

    public InvalidDataException() {}

}