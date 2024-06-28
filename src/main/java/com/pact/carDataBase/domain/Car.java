package com.pact.carDataBase.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Car {
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "owner2")
	private Owner2 owner2;
	

	
	@Id
	@Column(name = "id", unique = true, nullable = false)
//	@GeneratedValue (strategy=GenerationType.AUTO)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_sequence")
	private Long id;
	
	@Column(name = "Brand")
	private String brand;
	
	@Column(name = "Model")
	private String model; 
	
	@Column(name = "Color")
	private String color; 
	
	@Column(name = "RegisterNumber")
	private String registerNumber;
	
	
	@Column(name = "Year")
	private int year;
	
	@Column(name = "Price")
	private int price;
	
	
	public Car() {}
	
	

	public Car(  String brand, String model, String color, String registerNumber, int year, int price, Owner2 owner2) {
		super();
		
		this.owner2 = owner2;
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.registerNumber = registerNumber;
		this.year = year;
		this.price = price;
	}
	
	

	



	public Owner2 getOwner2() {
		return owner2;
	}



	public void setOwner2(Owner2 owner2) {
		this.owner2 = owner2;
	}



	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getRegisterNumber() {
		return registerNumber;
	}

	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	

}
