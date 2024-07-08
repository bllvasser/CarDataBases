package com.pact.carDataBase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.pact.carDataBase.domain.CarRepository;

import com.pact.carDataBase.domain.Owner2;
import com.pact.carDataBase.domain.OwnerRepository;
import com.pact.carDataBase.domain.Car;


@SpringBootApplication(exclude = {  org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})

//@SpringBootApplication(exclude={SecurityAutoConfiguration.class})

public class CarDataBaseApplication {
	
	@Autowired
	private CarRepository cRepo;
	@Autowired 
	private OwnerRepository oRepo;
	
	
	
	

	public static void main(String[] args) {
		SpringApplication.run(CarDataBaseApplication.class, args);
		
		System.out.println("Hello Bilaal");
		
	}
	
	@Bean
	CommandLineRunner runner() {
		
		return args -> {
			
			
			Owner2 owner1 = new Owner2("Bilaal","Vasser");
			Owner2 owner2 = new Owner2("Nasiyra", "Mccorkle");
			
			oRepo.save(owner1);
			oRepo.save(owner2);
			
			Car car = new Car("Ford", "Mustang", "Red", "ADF-1121", 2017, 59000, owner1);
			cRepo.save(car);
			
			car = new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000, owner2);
			cRepo.save(car);
			
			car = new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, 39000, owner2);
			cRepo.save(car);
				
		};
	}
	

}
