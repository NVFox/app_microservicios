package com.microservicio.microservicio_imagen.application.exceptions;

import lombok.Getter;

@Getter
public class ServerErrorException extends RuntimeException {

    private int status;
    public ServerErrorException() {
    }

    public ServerErrorException(String message) {
        super(message);
    }

    public ServerErrorException(String message, int status) {
        super(message);
        this.status = status;
    }

}
