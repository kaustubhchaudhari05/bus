package com.hp.busmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class CityEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long city_id;
	private String cityname;
	private int distance;
}
