package com.uber_project.entity_provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EntityProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(EntityProviderApplication.class, args);
	}

}
