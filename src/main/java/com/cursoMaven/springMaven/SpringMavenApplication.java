package com.cursoMaven.springMaven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLOutput;

@SpringBootApplication
public class SpringMavenApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringMavenApplication.class, args);
		System.out.println("Aplicacion corriendo");
	}

}
