package com.pact.carDataBase.domain;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity(name = "User")// I HAD TO ADD THE NAME WITH QUOTATIONS TO STOP SQL ERROR
public class User   {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column
private Long id;

@Column(name = "\"username\"")// I HAD TO ADD THE BACK SPACE FOR BOTH USERNAME AND ROLE TO STOP SQL ERROR
private String username;

@Column(name = "password")
private String password;

@Column(name = "firstname")
private String firstName;

@Column(name = "lastname")
private String lastName;

@Column( name = "\"role\"")

private String role;




public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
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

public String getRole() { 
	return role;
}

public void setRole(String role) {
	this.role = role;
}










}
