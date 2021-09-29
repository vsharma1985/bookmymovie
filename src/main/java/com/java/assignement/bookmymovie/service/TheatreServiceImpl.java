package com.java.assignement.bookmymovie.service;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.java.assignement.bookmymovie.entity.Theatre;
import com.java.assignement.bookmymovie.repo.TheatreRepository;

@Service
@Primary
public class TheatreServiceImpl implements TheatreService {
    private TheatreRepository theatreRepository;

    public TheatreServiceImpl(TheatreRepository theatreRepository) {
        this.theatreRepository = theatreRepository;
    }


    @Override
    public List<Theatre> getAllTheatres() {
        return theatreRepository.findAll();
    }

    @Override
    public Theatre getTheatreById(Long theatre_id) {
        return theatreRepository.getById(theatre_id);
    }

    @Override
    public Theatre addTheatre(Theatre newTheatre) {
    	Theatre theatre = theatreRepository.save(newTheatre);
        return theatre;
    }

    @Override
    public Theatre updateTheatre(Theatre updatedTheatre, Long theatre_id) {
    	 return theatreRepository.findById(theatre_id).map(theatre -> {
    		 theatre.setName(updatedTheatre.getName());
    		 theatre.setCity(updatedTheatre.getCity());
    		 theatre.setAuditoriums(updatedTheatre.getAuditoriums());
    		 
             return theatreRepository.save(theatre);
         }).orElseGet(() -> {
        	 updatedTheatre.setId(theatre_id);
             return theatreRepository.save(updatedTheatre);
         });
    }

    @Override
    public void deleteTheatreById(Long theatre_id) {
    	 theatreRepository.delete(getTheatreById(theatre_id));
    }


	@Override
	public List<Theatre> getAllTheatresInCity(String cityName) {
		
		return theatreRepository.findByCity(cityName);
	}
}