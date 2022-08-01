package com.backend.microservicio_persona.application.exceptions;

import lombok.Getter;

@Getter
public class NoSuchElementException extends RuntimeException {

    public NoSuchElementException() {}

    public NoSuchElementException(String message) {
        super(message);
    }

}
