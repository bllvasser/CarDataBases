package com.pact.carDataBase.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;// YOU MAY NEED TO EXTEND IT BACK TO CRUD TO GET THINGS RUNNING HOW IT DID B4
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource; 

@RepositoryRestResource
public interface CarRepository extends CrudRepository<Car, Long>{
	
	List<Car> findByBrand(@Param("brand") String brand);
	List<Car> findByColor(@Param("color") String color);
	List<Car> findByYear(int year);
	List<Car> findByBrandAndColor(String brand, String color);
	List<Car> findByBrandOrderByYearAsc(String brand);
	

}
