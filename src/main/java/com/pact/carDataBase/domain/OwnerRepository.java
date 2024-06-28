package com.pact.carDataBase.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner2, Long> { //YOU HAVE NOT ADDED ANY METHODS TO REPO LIKE YOU DID FOR CARREPO
	
	
	
	List<Owner2> findAll();
}
