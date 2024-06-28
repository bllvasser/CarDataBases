package com.pact.carDataBase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pact.carDataBase.domain.Car;
import com.pact.carDataBase.domain.CarRepository;
import com.pact.carDataBase.domain.User;
import com.pact.carDataBase.model.AuthenticationResponse;
import com.pact.carDataBase.service.AuthenticationService;

@RestController
public class AuthenticationController {
	
	@Autowired
	private final AuthenticationService authService;
	
	@Autowired
	private final CarRepository repo;

	public AuthenticationController(AuthenticationService authService, CarRepository repo) {
		this.repo = repo;
		
		this.authService = authService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(
			@RequestBody User request)
	{
		
		return ResponseEntity.ok(authService.register(request));
		
	
	}
	
	@PostMapping("/login")
	public ResponseEntity<AuthenticationResponse> login(
			@RequestBody User request){
		return ResponseEntity.ok(authService.authenticate(request));
	}
	
	@GetMapping("/cars")
	public Iterable<Car> getCars(){
		
		return repo.findAll();
	}
	

}
