package com.microservicio.microservicio_imagen.application.exceptions;

import lombok.Getter;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {}

    public NotFoundException(String message) {
        super(message);
    }

}