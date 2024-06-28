package com.pact.carDataBase.domain;





import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.pact.carDataBase.model.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

//@SuppressWarnings("serial") // I ADDED THIS ANNOTATION TO REMOVE YELLOW ERROR
@Entity(name = "User")// I HAD TO ADD THE NAME WITH QUOTATIONS TO STOP SQL ERROR
public class User implements UserDetails {
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
@Enumerated(value = EnumType.STRING)
private Role role;












public User() { // I created this to use in AuthenticationService.java
	
}





public User(String username, String password, String firstName, String lastName) {
	super();
	this.username = username;
	this.password = password;
	this.firstName = firstName;
	this.lastName = lastName;
	//this.role = role; // i changed this for nurney
}





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

public Role getRole() { 
	return role;
}

public void setRole(Role role) {
	this.role = role;
}

@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
	
	return List.of(new SimpleGrantedAuthority(role.name()));// IDEALLY I DIDN'T HAVE TO USE THE "LISTHIBERNATE" IMPORT
}

@Override
public boolean isAccountNonExpired() {
	return true;
}

@Override
public boolean isAccountNonLocked() {
	return true;
}

@Override
public boolean isCredentialsNonExpired() {
	return true;
}

@Override
public boolean isEnabled() {
	return true;
}


















}
