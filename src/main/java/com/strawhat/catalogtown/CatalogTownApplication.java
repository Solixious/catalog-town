package com.strawhat.catalogtown;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class CatalogTownApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogTownApplication.class, args);
	}

}
