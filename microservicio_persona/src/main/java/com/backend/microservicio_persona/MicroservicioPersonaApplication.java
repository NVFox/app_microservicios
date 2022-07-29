package com.backend.microservicio_persona;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class MicroservicioPersonaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioPersonaApplication.class, args);
	}

}
