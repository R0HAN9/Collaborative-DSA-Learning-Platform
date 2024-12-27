package com.Collaborative.DSALearningPlatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class CollaborativeDsaLearningPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollaborativeDsaLearningPlatformApplication.class, args);
	}
@GetMapping("/")
	public String home() {
		return "This is our Home Page!";
	}
}
