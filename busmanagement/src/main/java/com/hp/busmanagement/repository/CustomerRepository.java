package com.hp.busmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hp.busmanagement.entity.CustomerEntity;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
	
	public CustomerEntity findByCustomerid(Long customerid);
	
	public String findByUsername(String username);

}
