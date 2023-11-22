package com.hp.busmanagement.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long bookingid;
	private String firstname;
	private String lastname;
	private LocalDate dob;
	private String email;
	private String gender;
	private long contact_no;
	private String startpoint;
	private String endpoint;
	private String bookingstatus;
	private long customerid;
//	@ManyToOne
//	@JoinColumn(name = "customerid")
//	private CustomerEntity customerid;
//	
//
//	@ManyToOne
//	@JoinColumn(name = "city_id")
//	private CityEntity city;
}
