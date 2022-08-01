package com.microservicio.microservicio_imagen.application.exceptions;

import lombok.Getter;

@Getter
public class NoSuchElementException extends RuntimeException {

    public NoSuchElementException() {}

    public NoSuchElementException(String message) {
        super(message);
    }

}
