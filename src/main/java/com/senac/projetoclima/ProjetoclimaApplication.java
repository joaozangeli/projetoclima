package com.senac.projetoclima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ProjetoclimaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoclimaApplication.class, args);
	}

}
