package com.hp.busmanagement.service;

import java.time.LocalDate;
import java.util.regex.Pattern;

import com.hp.busmanagement.entity.BookingEntity;
import com.hp.busmanagement.entity.CustomerEntity;

public class ValidationService {

	
	public static boolean isEmailValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return Pattern.matches(emailRegex, email);
    }

    public static boolean isContactNumberValid(long contact_no) {
        String contactRegex = "^[0-9]{10}$";
        return Pattern.matches(contactRegex, String.valueOf(contact_no));
    }
    
    public static boolean isDob(BookingEntity bookingEntity) {
    	LocalDate dob = bookingEntity.getDob();
    	LocalDate today = LocalDate.now();
    	
    	if(dob.isEqual(today)) 
    		return false;
    	else 
    		return true;
    }
    
    
    public static boolean isBookingValid(CustomerEntity customerEntity) {
    	return isEmailValid(customerEntity.getEmail()) && isContactNumberValid(customerEntity.getContact_no()) && true;
    }
    
    public static boolean isBookingValid(BookingEntity booking) {
        return isEmailValid(booking.getEmail()) &&
               isContactNumberValid(booking.getContact_no()) && 
               true;  
    }
    
}
