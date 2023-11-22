package com.hp.busmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hp.busmanagement.entity.CityEntity;

@Repository
public interface CityRepositrory extends JpaRepository<CityEntity, Long>{

//	@Query("SELECT c.cityname FROM CityEntity c where c.cityname =  :cityname")
	public CityEntity findByCitynameIgnoreCase(String cityname);
	
	@Query("SELECT c.distance FROM CityEntity c where c.cityname =  :cityname")
	public Integer findDistanceByCityname(String cityname);
}