package com.hp.busmanagement.controller;

import java.util.ArrayList;
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

import com.hp.busmanagement.entity.BookingDTO;
import com.hp.busmanagement.entity.BookingEntity;
import com.hp.busmanagement.repository.BookingRepository;
import com.hp.busmanagement.service.BookingService;

@RestController
@RequestMapping("/booking")
@CrossOrigin(origins = "http://localhost:4200")
public class Booking {
	
	@Autowired
	private BookingRepository repository;
	
	@Autowired
	private BookingService bookingService;
//	
//	@Autowired
//	private CustomerRepository customerRepository;
	
	
	@PostMapping("/savebooking")
	public List<BookingEntity> saveBooking(@RequestBody List<BookingEntity> bookingEntity) {
		
		List<BookingEntity> bookingEntities = new ArrayList<>(bookingEntity);
		var x = bookingService.insertBookings(bookingEntities);
		return x;
//		var x = repository.save(bookingEntity);
//		return x;
	}
	
	
	
	@GetMapping("/getbooking")
	public List<BookingEntity> getBooking(){
		return (List<BookingEntity>)repository.findAll();
	}
	
	@GetMapping("/getbook/{bookingid}")
	public BookingDTO getBookingsinFormate(@PathVariable("bookingid") Long bookingid) {
		return (BookingDTO)bookingService.getBooking(bookingid);
	}
	
//	@GetMapping("/getbooking/{booking_id}")
//	public Optional<BookingEntity> getBookingById(@PathVariable("booking_id") Long booking_id){
//		return repository.findById(booking_id);
//	}
	
	@GetMapping("/customer")
	public List<BookingDTO> getBookingByCustomerId(Long customerid){
		return (List<BookingDTO>)bookingService.findAllBookingsForCustomer(customerid);
	}
	
//	@GetMapping("/maxfare")
//	public List<BookingDTO> getBookingsMaxFare(){
//		return (List<BookingDTO>)bookingService.getBookingsWithMaxFare();
//	}
	
	@GetMapping("/maxfare")
	public List<BookingDTO> getBookingsMaxFare() {
		return (List<BookingDTO>)bookingService.processBookings2();
	}
	
//	@GetMapping("/{customerid}")
//	public List<BookingDTO> getBookingsByCustomerid(@PathVariable Long customerid) {
//		return (List<BookingDTO>)bookingService.getBookingByCustomerid(customerid);
//	}
	
//	@GetMapping("/book")
//	public List<BookingDTO> getBookingFor(){
//		return (List<BookingDTO>)bookingService.getBooking();
//	}
	
	@GetMapping("/books")
	public ArrayList<BookingDTO> getBookingss() {
		return (ArrayList<BookingDTO>)bookingService.getBookings();
	}
//	
//	@GetMapping("/city/{cityid}")
//	public List<BookingEntity> getBookingByCityId(@PathVariable("cityid") Long cityid){
//		return (List<BookingEntity>)repository.findByCityid(cityid);
//	}
	
//	@GetMapping("/customer/{bookingid}")
//	public List<CustomerEntity> getCustomerDetailsForBooking(@PathVariable Long bookingid) {
//		List<CustomerEntity> id = bookingService.findCustomerByBookingid(bookingid);
//		return (List<CustomerEntity>)customerRepository.findByCustomerid(bookingid);
//	}
//	@GetMapping("/booking/{customer_id}")
//	public List<BookingEntity> getAllBookingsForCustomer(@PathVariable("customer_id") Long customer_id){
//		return (List<BookingEntity>)bookingService.findAllBookingsForCustomer(customer_id);
//	}
	
	
	@DeleteMapping("/deletebooking/{booking_id}")
	public void deleteBooking(@PathVariable("booking_id") Long booking_id) {
		repository.deleteById(booking_id);
	}

}
