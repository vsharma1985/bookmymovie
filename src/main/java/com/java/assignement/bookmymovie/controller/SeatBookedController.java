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

import com.java.assignement.bookmymovie.entity.SeatBooked;
import com.java.assignement.bookmymovie.service.SeatBookedService;

@RestController
@RequestMapping(path = "/bookmymovieapp")
public class SeatBookedController {
    private SeatBookedService seatBookedService;

    @RequestMapping(value ="/seatBooking",method=RequestMethod.GET)
	public String hello() {
		return "Welcome to seatBooking Controller";
	}
    
    @Autowired
    public SeatBookedController(SeatBookedService seatBookedService) {
        this.seatBookedService = seatBookedService;
    }

    @GetMapping("/seatbooked")
    public List<SeatBooked> getAllSeatBooked() {
        return seatBookedService.getAllSeatBooked();
    }
    
    @PostMapping("/")
    public SeatBooked createSeatBooking(@RequestBody SeatBooked  seatBooked) {
        return seatBookedService.createSeatBooked(seatBooked);
    }
    
    @GetMapping("/seatbooked/{seatBookingId}")
    public SeatBooked getSeatBooking(@PathVariable Long  seatBookingId) {
        return seatBookedService.getSeatBookedById(seatBookingId);
    }
    
    @DeleteMapping("/seatbooked/{seatBookingId}")
    public void deleteBooking(@PathVariable Long  seatBookingId) {
    	seatBookedService.deleteSeatBookedById(seatBookingId);
    }
    
    
}