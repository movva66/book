package com.one.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableAspectJAutoProxy
@OpenAPIDefinition(info = @Info(title = "Book",
version = "1.0", 
description = "Provides All Scirpt related API"))
public class MovvaBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovvaBookApplication.class, args);
	}

}
