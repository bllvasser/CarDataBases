package com.pact.carDataBase.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pact.carDataBase.domain.Car;
import com.pact.carDataBase.domain.CarRepository;


@RestController
public class Controller {
	@Autowired
	private final CarRepository repo;
	
	
	
	

	public Controller(CarRepository repo) {
		super();
		this.repo = repo;
	}





	@GetMapping("/cars")
	public Iterable<Car> getCars(){
		
		return repo.findAll();
	}
	
	
}
