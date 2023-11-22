package com.hp.busmanagement.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hp.busmanagement.entity.BookingDTO;
import com.hp.busmanagement.entity.BookingEntity;
import com.hp.busmanagement.entity.CustomerEntity;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Long> {
	
	 public List<BookingEntity> findByCustomerid(long customerid);
	 
	 @Query("SELECT b.customerid FROM BookingEntity b where b.bookingid =  :bookingid")
	 public List<CustomerEntity> findCustomerByBookingid(@Param("bookingid") Long bookingid);
	 
	public Long findByCustomerid(Long customerid);
	
	public BookingEntity findBycustomerid(long customer);
	
	@Query("SELECT b.bookingid FROM BookingEntity b")
	public BookingEntity getAllBooingid();
	
	public BookingEntity findByBookingid(int index);
	
	public BookingEntity findByDob(LocalDate dob);
	
	public BookingEntity findByEmail(String email);
	
//	public BookingEntity findByContactNo(long contact_no);
	
	 
}
