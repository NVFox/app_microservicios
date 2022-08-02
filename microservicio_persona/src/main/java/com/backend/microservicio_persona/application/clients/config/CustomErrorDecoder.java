package com.backend.microservicio_persona.application.clients.config;

import com.backend.microservicio_persona.application.exceptions.ClientErrorException;
import com.backend.microservicio_persona.application.exceptions.ServerErrorException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        int status = response.status();

        if (status >= 400 && status < 500) {
            return new ClientErrorException(
                    "Err: El elemento no existe o no se encuentra disponible",
                    status
            );
        }

        if (status >= 500) {
            return new ServerErrorException(
                    "Err: Error interno del servidor",
                    status
            );
        }

        return defaultErrorDecoder.decode(methodKey, response);
    }
}
