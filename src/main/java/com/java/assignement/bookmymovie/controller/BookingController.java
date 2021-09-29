package com.java.assignement.bookmymovie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.assignement.bookmymovie.entity.Booking;
import com.java.assignement.bookmymovie.service.BookingService;

@RestController
@RequestMapping(path = "/bookmymovieapp")
public class BookingController {
    private BookingService bookingService;
    
    @RequestMapping(value ="/booking",method=RequestMethod.GET)
	public String hello() {
		return "Welcome to Booking Controller";
	}

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/bookings")
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }
    
    @PostMapping("/booking")
    public Booking createBooking(@RequestBody Booking  newBooking) {
        return bookingService.createBooking(newBooking);
    }
    
    @GetMapping("/booking/{bookingId}")
    public Booking getBooking(@PathVariable Long  bookingId) {
        return bookingService.getBookingById(bookingId);
    }
    
    @DeleteMapping("/booking/{bookingId}")
    public void deleteBooking(@PathVariable Long  bookingId) {
         bookingService.deleteBookingById(bookingId);
    }
}