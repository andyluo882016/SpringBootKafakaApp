package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebSpringBootKafkaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebSpringBootKafkaDemoApplication.class, args);
		System.out.println("The Server is up");
	}

}
