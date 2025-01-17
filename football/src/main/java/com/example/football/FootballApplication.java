package com.example.football;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;




@ComponentScan({"com.example.service","com.example.controller"})
@EntityScan("com.example.entity")
@EnableJpaRepositories("com.example.repository")
@SpringBootApplication


public class FootballApplication {


	public static void main(String[] args) {
		SpringApplication.run(FootballApplication.class, args);
		
	}

}
