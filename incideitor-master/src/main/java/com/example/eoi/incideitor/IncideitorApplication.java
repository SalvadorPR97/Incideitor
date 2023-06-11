package com.example.eoi.incideitor;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class IncideitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(IncideitorApplication.class, args);
	}

	@PostConstruct
	public void init() {

		//No se requiere inicialización en este punto por el momento.

	}

}
