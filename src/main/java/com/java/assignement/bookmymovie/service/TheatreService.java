package com.java.assignement.bookmymovie.service;

import java.util.List;

import com.java.assignement.bookmymovie.entity.Theatre;

public interface TheatreService {
    List<Theatre> getAllTheatres();

    Theatre getTheatreById(Long theatre_id);

    Theatre addTheatre(Theatre newTheatre);

    Theatre updateTheatre(Theatre updatedTheatre, Long theatre_id);
    
    List<Theatre> getAllTheatresInCity(String cityName);

    void deleteTheatreById(Long theatre_id);
}