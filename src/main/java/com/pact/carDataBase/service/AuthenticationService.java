package com.pact.carDataBase.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pact.carDataBase.domain.UserRepository;
import com.pact.carDataBase.model.AuthenticationResponse;
import com.pact.carDataBase.domain.User;

//ADDED THIS ANNOTATION
@Configuration
@Service
public class AuthenticationService {  
	private final UserRepository repo;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;
	

	
	public AuthenticationService(UserRepository repo,@Lazy PasswordEncoder passwordEncoder, JwtService jwtService,
			@Lazy AuthenticationManager authenticationManager) {
		super();
		this.repo = repo;
		this.passwordEncoder = passwordEncoder;
		this.jwtService = jwtService;
		this.authenticationManager = authenticationManager;
	}
	


	public  AuthenticationResponse register(User request) {
		System.out.println("At the beginning of register" + request); //fn
		User user = new User();
		
		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastName());
		user.setUsername(request.getUsername());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		
		user.setRole(user.getRole());
		
		user = repo.save(user);
		
		String token = jwtService.generateToken(user);
		
		System.out.println("Here is the token: " + token);// this is what i did for nurney
		
		return new AuthenticationResponse(token);
			
	}
	
	
	
	public AuthenticationResponse authenticate(User request) {
		
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						request.getUsername(),
						request.getPassword()
						)
				);
		
		User user = repo.findByUsername(request.getUsername()).orElseThrow();
		String token = jwtService.generateToken(user);
		
		return new AuthenticationResponse(token);
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	

	

}
