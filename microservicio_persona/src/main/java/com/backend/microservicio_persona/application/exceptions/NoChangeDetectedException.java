package com.backend.microservicio_persona.application.exceptions;

public class NoChangeDetectedException extends RuntimeException {

    public NoChangeDetectedException() {
    }

    public NoChangeDetectedException(String message) {
        super(message);
    }
}
