package com.java.assignement.bookmymovie.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.assignement.bookmymovie.entity.Screening;
import com.java.assignement.bookmymovie.entity.Seat;
import com.java.assignement.bookmymovie.exception.HousefullException;
import com.java.assignement.bookmymovie.service.ScreeningService;

@RestController
@RequestMapping(path = "/bookmymovieapp")
public class ScreeningController {
    private ScreeningService screeningService;

    @Autowired
    public ScreeningController(ScreeningService screeningService) {
        this.screeningService = screeningService;
    }
    
    @RequestMapping(value ="/screening",method=RequestMethod.GET)
   	public String hello() {
   		return "Welcome to Screening Controller";
   	}

    @GetMapping("/screenings")
    public ResponseEntity<?> getAllScreenings(@RequestParam(required = false) Map<String, String> dates) {
        List<Screening> screenings = null;
        if(!dates.isEmpty()) {
            LocalDate startDate = LocalDate.parse(dates.get("startDate"));
            LocalDate endDate = LocalDate.parse(dates.get("endDate"));
            screenings = screeningService.getAllScreenings(startDate, endDate);
        } else {
            screenings = screeningService.getAllScreenings();
        }
        return ResponseEntity.status(HttpStatus.OK).body(screenings);
    }

    @GetMapping("/screenings/{screening_id}")
    public ResponseEntity<?> getScreenById(@PathVariable Long screening_id) {
        Screening screening = screeningService.getScreeningById(screening_id);
        return ResponseEntity.status(HttpStatus.OK).body(screening);
    }

    @GetMapping("/screenings/{screening_id}/seats")
    public ResponseEntity<?> getSeatsByScreeningId(@PathVariable Long screening_id) throws HousefullException {
        List<Seat> seats = screeningService.getSeatsByScreeningId(screening_id);
        if(seats.size() == 0) {
           throw new HousefullException();
        }
        return ResponseEntity.status(HttpStatus.OK).body(seats);
    }
}