package com.backend.microservicio_persona.application.clients.config;

import org.springframework.context.annotation.Bean;

public class ImagenClientConfig {

    @Bean
    public CustomErrorDecoder customErrorDecoder() {
        return new CustomErrorDecoder();
    }

}
