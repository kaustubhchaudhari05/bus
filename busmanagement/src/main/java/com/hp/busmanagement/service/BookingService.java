package com.hp.busmanagement.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hp.busmanagement.entity.BookingDTO;
import com.hp.busmanagement.entity.BookingEntity;
import com.hp.busmanagement.entity.CityEntity;
import com.hp.busmanagement.entity.CustomerEntity;
import com.hp.busmanagement.repository.BookingRepository;
import com.hp.busmanagement.repository.CityRepositrory;

import jakarta.validation.ValidationException;


@Service
public class BookingService {
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private CityRepositrory cityRepositrory;
	
	
	public List<BookingEntity> insertBookings(List<BookingEntity> bookings) {
        for (BookingEntity booking : bookings) {
            if (!ValidationService.isBookingValid(booking) && ValidationService.isDob(booking)) {
                throw new ValidationException("Booking validation failed for booking with ID: " + booking.getBookingid());
            }
        }

        return (List<BookingEntity>)bookingRepository.saveAll(bookings);
    }
	
	public List<BookingEntity> saveAll(List<BookingEntity> booking) {
		return bookingRepository.saveAll(booking);
	}
	
	public List<BookingDTO> findAllBookingsForCustomer(long customerid){
		List<BookingEntity> bookings = bookingRepository.findByCustomerid(customerid);
//		processBookings2();
		
ArrayList<BookingDTO> bookingDtos = new ArrayList<BookingDTO>();
		
		
		for (BookingEntity booking : bookings) {
			CityEntity startCityEntity1 =  cityRepositrory.findByCitynameIgnoreCase(booking.getStartpoint());
			CityEntity endCityEntity1 = cityRepositrory.findByCitynameIgnoreCase(booking.getEndpoint());
		
		int startpoint1 = startCityEntity1.getDistance();
			int endpoint1 = endCityEntity1.getDistance();
			
			int distance = endpoint1-startpoint1;

			
			
			BookingDTO dto = new BookingDTO();
			
			int today = LocalDate.now().getYear();
			int dob = booking.getDob().getYear();
			
			int age = today - dob;
			int fare;
			if(age < 7) {
				fare = distance * 2;
			} else if( age > 7 && age < 50) {
				fare = distance * 5;
			} else {
				fare = distance * 3;
			}
			
			dto.setPassengername(booking.getFirstname()+" "+booking.getLastname());
			dto.setGender(booking.getGender());
			dto.setAge(age);
			dto.setEmail(booking.getEmail());
			dto.setContact(booking.getContact_no());
			dto.setStartpoint(booking.getStartpoint());
			dto.setEndpoint(booking.getEndpoint());
			dto.setDistance(distance);
			dto.setFare(fare);
			dto.setStatus(booking.getBookingstatus());
			
			bookingDtos.add(dto);
		}
		return bookingDtos;
		
	}
	
	public List<CustomerEntity> findCustomerByBookingid(Long bookingid) {
		return (List<CustomerEntity>)bookingRepository.findCustomerByBookingid(bookingid);	
	}

//	public List<BookingEntity> findAllBookingId(){
//		
//	}
	
	
	public List<BookingDTO> getBookings() {
		List<BookingEntity> bookings = bookingRepository.findAll();
	
		ArrayList<BookingDTO> bookingDtos = new ArrayList<BookingDTO>();
		
		
		for (BookingEntity booking : bookings) {
			CityEntity startCityEntity1 =  cityRepositrory.findByCitynameIgnoreCase(booking.getStartpoint());
			CityEntity endCityEntity1 = cityRepositrory.findByCitynameIgnoreCase(booking.getEndpoint());
		
		int startpoint1 = startCityEntity1.getDistance();
			int endpoint1 = endCityEntity1.getDistance();
			
			int distance = endpoint1-startpoint1;

			
			
			BookingDTO dto = new BookingDTO();
			
			int today = LocalDate.now().getYear();
			int dob = booking.getDob().getYear();
			
			int age = today - dob;
			int fare;
			if(age < 7) {
				fare = distance * 2;
			} else if( age > 7 && age < 50) {
				fare = distance * 5;
			} else {
				fare = distance * 3;
			}
			
			dto.setPassengername(booking.getFirstname()+" "+booking.getLastname());
			dto.setGender(booking.getGender());
			dto.setAge(age);
			dto.setEmail(booking.getEmail());
			dto.setContact(booking.getContact_no());
			dto.setStartpoint(booking.getStartpoint());
			dto.setEndpoint(booking.getEndpoint());
			dto.setDistance(distance);
			dto.setFare(fare);
			dto.setStatus(booking.getBookingstatus());
			
			bookingDtos.add(dto);
		}
		return bookingDtos;
 	}
	
	
	public BookingDTO getBooking() {
		BookingEntity booking = (BookingEntity)bookingRepository.findAll();
		CityEntity startCityEntity1 =  cityRepositrory.findByCitynameIgnoreCase(booking.getStartpoint());
		CityEntity enCityEntity1 = cityRepositrory.findByCitynameIgnoreCase(booking.getEndpoint());
		
		int startpoint1 = startCityEntity1.getDistance();
		int endpoint1 = enCityEntity1.getDistance();
		
		int distance = endpoint1-startpoint1;
		
		
		BookingDTO dto = new BookingDTO();
		
		int today = LocalDate.now().getYear();
		int dob = booking.getDob().getYear();
		
		int age = today - dob;
		int fare;
		if(age < 7) {
			fare = distance * 2;
		} else if( age > 7 && age < 50) {
			fare = distance * 5;
		} else {
			fare = distance * 3;
		}
		
		dto.setPassengername(booking.getFirstname()+" "+booking.getLastname());
		dto.setGender(booking.getGender());
		dto.setAge(age);
		dto.setEmail(booking.getEmail());
		dto.setContact(booking.getContact_no());
		dto.setStartpoint(booking.getStartpoint());
		dto.setEndpoint(booking.getEndpoint());
		dto.setDistance(distance);
		dto.setFare(fare);
		dto.setStatus(booking.getBookingstatus());
		
		return dto;	
	}
	
	public BookingDTO getBookingByCustomerid(Long customerid) {
		long customerid1 = bookingRepository.findByCustomerid(customerid); 
		
		BookingEntity booking = bookingRepository.findBycustomerid(customerid1);
		
		CityEntity startCityEntity1 =  cityRepositrory.findByCitynameIgnoreCase(booking.getStartpoint());
		CityEntity enCityEntity1 = cityRepositrory.findByCitynameIgnoreCase(booking.getEndpoint());
		
		int startpoint1 = startCityEntity1.getDistance();
		int endpoint1 = enCityEntity1.getDistance();
		
		int distance = endpoint1-startpoint1;
		
		
		BookingDTO dto = new BookingDTO();
		
		int today = LocalDate.now().getYear();
		int dob = booking.getDob().getYear();
		
		int age = today - dob;
		int fare;
		if(age < 7) {
			fare = distance * 2;
		} else if( age > 7 && age < 50) {
			fare = distance * 5;
		} else {
			fare = distance * 3;
		}
		
		dto.setPassengername(booking.getFirstname()+" "+booking.getLastname());
		dto.setGender(booking.getGender());
		dto.setAge(age);
		dto.setEmail(booking.getEmail());
		dto.setContact(booking.getContact_no());
		dto.setStartpoint(booking.getStartpoint());
		dto.setEndpoint(booking.getEndpoint());
		dto.setDistance(distance);
		dto.setFare(fare);
		dto.setStatus(booking.getBookingstatus());
		
		return dto;
	}
	
	public BookingDTO getBooking(long bookingid) {
		BookingEntity booking = bookingRepository.getById(bookingid);
		
		CityEntity startCityEntity1 =  cityRepositrory.findByCitynameIgnoreCase(booking.getStartpoint());
		CityEntity enCityEntity1 = cityRepositrory.findByCitynameIgnoreCase(booking.getEndpoint());
		
		int startpoint1 = startCityEntity1.getDistance();
		int endpoint1 = enCityEntity1.getDistance();
		
		int distance = endpoint1-startpoint1;
		
		
		BookingDTO dto = new BookingDTO();
		
		int today = LocalDate.now().getYear();
		int dob = booking.getDob().getYear();
		
		int age = today - dob;
		int fare;
		if(age < 7) {
			fare = distance * 2;
		} else if( age > 7 && age < 50) {
			fare = distance * 5;
		} else {
			fare = distance * 3;
		}
		
		dto.setPassengername(booking.getFirstname()+" "+booking.getLastname());
		dto.setGender(booking.getGender());
		dto.setAge(age);
		dto.setEmail(booking.getEmail());
		dto.setContact(booking.getContact_no());
		dto.setStartpoint(booking.getStartpoint());
		dto.setEndpoint(booking.getEndpoint());
		dto.setDistance(distance);
		dto.setFare(fare);
		dto.setStatus(booking.getBookingstatus());
		
		return dto;	
	}
    
    public List<BookingDTO> processBookings2() {
        List<BookingEntity> bookings = bookingRepository.findAll();

        List<BookingDTO> bookingDtos = new ArrayList<>();

        for (BookingEntity booking : bookings) {
            BookingDTO dto = new BookingDTO();

            CityEntity startCityEntity1 = cityRepositrory.findByCitynameIgnoreCase(booking.getStartpoint());
            CityEntity endCityEntity1 = cityRepositrory.findByCitynameIgnoreCase(booking.getEndpoint());

            int startpoint1 = startCityEntity1.getDistance();
            int endpoint1 = endCityEntity1.getDistance();

            int distance = endpoint1 - startpoint1;

            int today = LocalDate.now().getYear();
            int dob = booking.getDob().getYear();

            int age = today - dob;
            int fare;

            if (age < 7) {
                fare = distance * 2;
            } else if (age > 7 && age < 50) {
                fare = distance * 5;
            } else {
                fare = distance * 3;
            }

            dto.setPassengername(booking.getFirstname() + " " + booking.getLastname());
            dto.setGender(booking.getGender());
            dto.setAge(age);
            dto.setEmail(booking.getEmail());
            dto.setContact(booking.getContact_no());
            dto.setStartpoint(booking.getStartpoint());
            dto.setEndpoint(booking.getEndpoint());
            dto.setDistance(distance);
            dto.setFare(fare);
            dto.setStatus(booking.getBookingstatus());

            bookingDtos.add(dto);
        }

        List<BookingDTO> selectedBookings = new ArrayList<>();
        List<BookingDTO> femalePassenger = new ArrayList<>();
        List<BookingDTO> malePassenger = new ArrayList<>();
        List<BookingDTO> rejectedBookings = new ArrayList<>();
        
        
        for(BookingDTO bookingDTO: bookingDtos) {
        	if("female".equalsIgnoreCase(bookingDTO.getGender()) || "f".equalsIgnoreCase(bookingDTO.getGender())) {
        		femalePassenger.add(bookingDTO);
        	} else {
        		malePassenger.add(bookingDTO);
        	}
        }
        
        for(int i =0; i< malePassenger.size()-1; i++) {
        	for(int j = 0; j < malePassenger.size()-i-1; j++) {
        		if(malePassenger.get(j).getFare() < malePassenger.get(j+1).getFare()) {
        			BookingDTO tempDto = malePassenger.get(j);
        			malePassenger.set(j, malePassenger.get(j+1));
        			malePassenger.set(j+1, tempDto);
        		}
        	}
        }
        
        int maleCount = Math.min(20, malePassenger.size());
        List<BookingDTO> maleBookings = new ArrayList<>();
        for(int i=0; i< maleCount; i++) {
        	maleBookings.add(malePassenger.get(i));
        }
        
        int femaleCount = Math.min(5, femalePassenger.size());
        List<BookingDTO> femaleBookings = new ArrayList<>();
        for(int i = 0; i <femaleCount;i++) {
        	femaleBookings.add(femalePassenger.get(i));
        }
        
        selectedBookings.addAll(maleBookings);
        selectedBookings.addAll(femaleBookings);
        
        
        for(BookingDTO booking: selectedBookings) {
        	booking.setStatus("accepted");
//        	BookingEntity bookingEntity = bookingRepository.findByEmail(booking.getEmail());
//        	bookingEntity.setBookingstatus("accepted");
//        	System.out.println(bookingEntity);
//        	bookingRepository.save(bookingEntity);
        }
        
//        for(int i=0; i < selectedBookings.size(); i++) {
//        	BookingEntity bookingEntity = bookingRepository.findByEmail(selectedBookings.get(i).getEmail());
//        	bookingEntity.setBookingstatus("accepted");
//        }
        

        return selectedBookings;
    }



}
