package com.hp.busmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hp.busmanagement.entity.CityEntity;
import com.hp.busmanagement.repository.CityRepositrory;



@RestController
@RequestMapping("/city")
@CrossOrigin(origins = "http://localhost:4200")

public class City {


	@Autowired
	private CityRepositrory repository;
	
	@PostMapping("/savecity")
	public void saveCity(@RequestBody CityEntity cityEntity) { 
		repository.save(cityEntity);
	}
	
	@GetMapping("/getcity")
	public List<CityEntity> getCity(){
		return (List<CityEntity>)repository.findAll();
	}
	
	@DeleteMapping("/deletecity/{city_id}")
	public void deleteCity(@PathVariable("city_id") Long city_id) {
		repository.deleteById(city_id);
	}
}
