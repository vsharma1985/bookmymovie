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

import com.java.assignement.bookmymovie.entity.Seat;
import com.java.assignement.bookmymovie.service.SeatService;

@RestController
@RequestMapping(path = "/bookmymovieapp")
public class SeatController {
    private SeatService seatService;

    @RequestMapping(value ="/seat",method=RequestMethod.GET)
   	public String hello() {
   		return "Welcome to seat Controller";
   	}
    
    @Autowired
    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping("/seats")
    public List<Seat> getAllSeats() {
        return this.seatService.getAllSeats();
    }
    
    @PostMapping("/seat")
    public Seat addSeat(@RequestBody Seat  seat) {
        return seatService.addSeat(seat);
    }
    
    @GetMapping("/seat/{seatId}")
    public Seat getBooking(@PathVariable Long  seatId) {
        return seatService.getSeatById(seatId);
    }
    
    @DeleteMapping("/seat/{seatId}")
    public void deleteBooking(@PathVariable Long  seatId) {
    	seatService.deleteSeatById(seatId);
    }
    
}