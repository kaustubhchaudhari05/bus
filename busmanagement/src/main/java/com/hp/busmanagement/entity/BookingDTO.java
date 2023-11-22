package com.hp.busmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO {

	private String passengername;
	private String gender;
	private int age;
	private String email;
	private long contact;
	private String startpoint;
	private String endpoint;
	private int distance;
	private int fare;
	private String status;
}
