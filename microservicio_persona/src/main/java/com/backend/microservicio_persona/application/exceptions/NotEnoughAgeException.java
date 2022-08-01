package com.backend.microservicio_persona.application.exceptions;

public class NotEnoughAgeException extends RuntimeException {

    public NotEnoughAgeException() {
    }

    public NotEnoughAgeException(String message) {
        super(message);
    }

}
