package com.java.assignement.bookmymovie.controller;

import java.util.ArrayList;
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

import com.java.assignement.bookmymovie.entity.Theatre;
import com.java.assignement.bookmymovie.service.TheatreService;

@RestController
@RequestMapping(path = "/bookmymovieapp")
public class TheatreController {
    private TheatreService theatreService;

    @Autowired
    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    @RequestMapping(value ="/theatre",method=RequestMethod.GET)
	public String hello() {
		return "Welcome to Theatre Controller";
	}

    @GetMapping("/theatres")
    public List<Theatre> getAllTheatres() {
    	List<Theatre> theaterList = new ArrayList<>();
    	Iterable<Theatre> theatres = theatreService.getAllTheatres();
    	for (Theatre theater : theatres) {
    		theaterList.add(theater);
        }
     return theaterList;
    }
    
    @PostMapping("/theatre")
    public Theatre addTheatre(@RequestBody Theatre  theatre) {
        return theatreService.addTheatre(theatre);
    }
    
    @GetMapping("/theatres/{theatre_id}")
    public Theatre getTheaterById(@PathVariable Long  theatre_id) {
        return theatreService.getTheatreById(theatre_id);
    }
    
    @DeleteMapping("/theatres/{theatre_id}")
    public void deleteBooking(@PathVariable Long  theatre_id) {
    	theatreService.deleteTheatreById(theatre_id);
    }
    
    @GetMapping("/theatres/city")
    public List<Theatre> getAllTheatresInCity(@PathVariable("city") String city) {
    	List<Theatre> theaterList = new ArrayList<>();
    	Iterable<Theatre> theatres = theatreService.getAllTheatresInCity(city);
    	for (Theatre theater : theatres) {
    		theaterList.add(theater);
        }
     return theaterList;
    	
    }
    
    
    
}