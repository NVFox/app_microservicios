package com.microservicio.microservicio_imagen.application.exceptions;

public class NoDataFoundException extends RuntimeException {

    public NoDataFoundException() {
    }

    public NoDataFoundException(String message) {
        super(message);
    }
}
