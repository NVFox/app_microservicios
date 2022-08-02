package com.microservicio.microservicio_imagen.application.clients.config;

import org.springframework.context.annotation.Bean;

public class PersonaClientConfig {

    @Bean
    public CustomErrorDecoder customErrorDecoder() {
        return new CustomErrorDecoder();
    }

}
