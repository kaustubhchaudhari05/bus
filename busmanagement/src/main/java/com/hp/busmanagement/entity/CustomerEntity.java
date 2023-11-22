package com.hp.busmanagement.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class CustomerEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long customerid;
	private String firstname;
	private String lastname;
	private String gender;	
	private String city;
	private LocalDate dob;
	private String email;
	private long contact_no;
	private String username;
	private String password;
	
//	@OneToMany(mappedBy = "customerid")
//	private List<BookingEntity> bookings;
}
