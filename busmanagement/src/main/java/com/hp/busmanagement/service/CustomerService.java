package com.hp.busmanagement.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hp.busmanagement.entity.CustomerDTO;
import com.hp.busmanagement.entity.CustomerEntity;
import com.hp.busmanagement.repository.CustomerRepository;

import jakarta.validation.ValidationException;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public CustomerDTO getCustomer(long customerid) {
		CustomerEntity customer = customerRepository.findByCustomerid(customerid);
		
		int today = LocalDate.now().getYear();
		int dob = customer.getDob().getYear();
		
		CustomerDTO dto = new CustomerDTO();
		
		dto.setCustomername(customer.getFirstname()+" "+customer.getLastname());
		dto.setGender(customer.getGender());
		dto.setAge(today - dob);
		dto.setEmail(customer.getEmail());
		dto.setCity(customer.getCity());
		dto.setContact(customer.getContact_no());
		dto.setUsername(customer.getUsername());
		
		return dto;
	}
	
	public CustomerEntity saveCustomer(CustomerEntity customerEntity) {
		 if (!ValidationService.isBookingValid(customerEntity) ) {
             throw new ValidationException("Booking validation failed for booking with ID: " + customerEntity.getCustomerid());
         }
		 return customerRepository.save(customerEntity);
	}
}
