package com.hp.busmanagement.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class AdminEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long admin_id;
	private String firstname;
	private String lastname;
	private LocalDate dob;
	private String gender;
	private String email;
	private String city;
	private long contact_no;
	private String username;
	private String password;

}
