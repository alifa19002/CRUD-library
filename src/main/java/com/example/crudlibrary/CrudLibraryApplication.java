package com.example.crudlibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class CrudLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudLibraryApplication.class, args);
	}
}