package com.backend.microservicio_persona.application.exceptions;

import lombok.Getter;

@Getter
public class ClientErrorException extends RuntimeException {

    private int status;

    public ClientErrorException() {
    }

    public ClientErrorException(String message) {
        super(message);
    }

    public ClientErrorException(String message, int status) {
        super(message);
        this.status = status;
    }

}