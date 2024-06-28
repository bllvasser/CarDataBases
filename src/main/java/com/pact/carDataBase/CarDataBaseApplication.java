package com.pact.carDataBase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import com.pact.carDataBase.domain.User;
import com.pact.carDataBase.service.AuthenticationService;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarDataBaseApplication {
	@Autowired
	AuthenticationService authService;
	

	public static void main(String[] args) {
		SpringApplication.run(CarDataBaseApplication.class, args);
		
		System.out.println("Hello Bilaal");
		
		
		
		
		
	}
	

}
