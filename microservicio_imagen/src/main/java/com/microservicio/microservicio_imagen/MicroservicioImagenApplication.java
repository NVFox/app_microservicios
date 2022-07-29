package com.microservicio.microservicio_imagen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroservicioImagenApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioImagenApplication.class, args);
	}

}
