package com.backend.microservicio_persona.application.exceptions;

public class NoDataFoundException extends RuntimeException {

    public NoDataFoundException() {
    }

    public NoDataFoundException(String message) {
        super(message);
    }
}
