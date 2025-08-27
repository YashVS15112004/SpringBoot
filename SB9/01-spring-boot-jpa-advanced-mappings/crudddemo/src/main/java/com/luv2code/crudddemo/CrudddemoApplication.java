package com.luv2code.crudddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commondLineRunner(String[] args)
	{
		return runner ->{
			System.out.println("Hello World!");
		}; 
	}
}
