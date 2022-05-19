package com.api.organograma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class OrganogramaApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganogramaApplication.class, args);
	}

	@GetMapping("/")
	public String index() {
		return "Organograma CP2";
	}
}
