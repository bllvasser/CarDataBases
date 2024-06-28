package com.pact.carDataBase.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Owner2 {
	
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="owner2")
	@JsonIgnore
	private List<Car> cars;
	
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_sequence")
	private Long id;
	
	
	@Column(name = "FirstName")
	private String firstName ;
	
	@Column(name = "LastName")
	private String lastName;
	
	public Owner2() {}

	public Owner2(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	
	
	
	
	

}
