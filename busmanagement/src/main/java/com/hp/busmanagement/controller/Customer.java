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

import com.hp.busmanagement.entity.CustomerDTO;
import com.hp.busmanagement.entity.CustomerEntity;
import com.hp.busmanagement.repository.CustomerRepository;
import com.hp.busmanagement.service.CustomerService;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:4200")
public class Customer {

	@Autowired
	private CustomerRepository repository;
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/savecustomer")
	public CustomerEntity saveCustomer(@RequestBody CustomerEntity customerEntity) {	
		return customerService.saveCustomer(customerEntity);
	}
	
	@GetMapping("/getcustomer")
	public List<CustomerEntity> getCustomer(){
		return (List<CustomerEntity>)repository.findAll();
		
	}
	
//	@GetMapping("/getcustomer/{customer_id}")
//	public Optional<CustomerEntity> getCustomerById(@PathVariable("customer_id") Integer customer_id){
//		return repository.findById(customer_id);
//	}
	
	@GetMapping("/customer")
	public CustomerDTO getCustomer(Long customerid) {
		return customerService.getCustomer(customerid);
	}
	
	@DeleteMapping("/deletecustomer/{customer_id}")
	public void deleteCustomer(@PathVariable("customer_id") Integer customer_id) {
		repository.deleteById(customer_id);
	}
}
