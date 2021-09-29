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

import com.java.assignement.bookmymovie.entity.Auditorium;
import com.java.assignement.bookmymovie.service.AuditoriumService;

@RestController
@RequestMapping(path = "/bookmymovieapp")
public class AuditoriumController {
    private AuditoriumService auditoriumService;

    @Autowired
    public AuditoriumController(AuditoriumService auditoriumService) {
        this.auditoriumService = auditoriumService;
    }
    
    @RequestMapping(value ="/audi",method=RequestMethod.GET)
	public String hello() {
		return "Welcome to Auditorium Controller";
	}

    @GetMapping("/auditoriums")
    public List<Auditorium> getAllAuditoriums() {
        return auditoriumService.getAllAuditoriums();
    }
    
    @PostMapping("/audi")
    public Auditorium addAudi(@RequestBody Auditorium  auditorium) {
        return auditoriumService.addAuditorium(auditorium);
    }
    
    @DeleteMapping("/audi/{audiId}")
    public void deleteAuditorium(@PathVariable Long  audiId) {
    	auditoriumService.deleteAuditoriumById(audiId);
    }
    
}