package com.java.assignement.bookmymovie.service;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.java.assignement.bookmymovie.entity.Booking;
import com.java.assignement.bookmymovie.repo.BookingRepository;

@Service
@Primary
public class BookingServiceImpl implements BookingService {
    private BookingRepository bookingRepository;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getBookingById(Long booking_id) {
        return bookingRepository.getBookingById(booking_id);
    }

    @Override
    public Booking createBooking(Booking newBooking) {
    	LocalTime  st_time = newBooking.getBookingTime();
    	Double discount=  .5*newBooking.getScreening().getPrice();
    	int seatBooked = newBooking.getBookedSeats().size();
    	
    	if(st_time.isAfter(LocalTime.NOON)) {
    		
    		double offered_price = .2*(seatBooked*newBooking.getScreening().getPrice());
    		newBooking.getScreening().setPrice(offered_price);
    	}
    	if(seatBooked>3) {
    		newBooking.getScreening().setPrice(seatBooked*newBooking.getScreening().getPrice()-discount);
    	}
    	
    	
        return bookingRepository.save(newBooking);
    }

    @Override
    public Booking updateBooking(Booking updatedBooking, Long booking_id) {
    	 return bookingRepository.findById(booking_id).map(booking -> {
    		 updatedBooking.setScreening(booking.getScreening());
    		 updatedBooking.setBookedSeats(booking.getBookedSeats());
    		 updatedBooking.setBookingTime(booking.getBookingTime());
    		 updatedBooking.setIsActive(booking.getIsActive());
    		 updatedBooking.setIsBooked(booking.getIsBooked());
    		 
             return bookingRepository.save(updatedBooking);
         }).orElseGet(() -> {
        	 updatedBooking.setId(booking_id);
             return bookingRepository.save(updatedBooking);
         });
    }

    @Override
    public void deleteBookingById(Long booking_id) {

    }
}