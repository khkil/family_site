package com.example.googoos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class GoogoosApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoogoosApiApplication.class, args);
	}

}
