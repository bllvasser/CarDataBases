package com.pact.carDataBase.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pact.carDataBase.domain.UserRepository;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService{
	
	private final UserRepository repo;
	
	

	public UserDetailsServiceImplementation(UserRepository repo) {
		
		this.repo = repo;
	}



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return repo.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("User not found"));
	}

}
