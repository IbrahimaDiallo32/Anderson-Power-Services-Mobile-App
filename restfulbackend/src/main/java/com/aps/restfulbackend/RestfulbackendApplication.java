package com.aps.restfulbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestfulbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulbackendApplication.class, args);
		System.out.print("Hello APS world");
	}
}
