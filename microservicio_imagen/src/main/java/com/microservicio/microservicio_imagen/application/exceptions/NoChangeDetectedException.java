package com.microservicio.microservicio_imagen.application.exceptions;

public class NoChangeDetectedException extends RuntimeException {

    public NoChangeDetectedException() {
    }

    public NoChangeDetectedException(String message) {
        super(message);
    }
}
