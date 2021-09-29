package com.java.assignement.bookmymovie.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.java.assignement.bookmymovie.entity.Screening;
import com.java.assignement.bookmymovie.entity.Seat;
import com.java.assignement.bookmymovie.exception.ScreeningNotFoundException;
import com.java.assignement.bookmymovie.repo.ScreeningRepository;

@Service
@Primary
public class ScreeningServiceImpl implements ScreeningService {
    private ScreeningRepository screeningRepository;

    @Autowired
    public ScreeningServiceImpl(ScreeningRepository screeningRepository) {
        this.screeningRepository = screeningRepository;
    }

    @Override
    public List<Screening> getAllScreenings() {
        return screeningRepository.findAll();
    }

    @Override
    public List<Screening> getAllScreenings(LocalDate startDate, LocalDate endDate) {
        return screeningRepository.findAll().stream().filter(screening -> screening.getMovie_date().isAfter(startDate) && screening.getMovie_date().isBefore(endDate)).collect(Collectors.toList());
    }

    @Override
    public Screening getScreeningById(Long screening_id) {
        return screeningRepository.findById(screening_id).orElseThrow(ScreeningNotFoundException :: new);
    }

    @Override
    public Screening createScreening(Screening newScreening) {
    	return screeningRepository.save(newScreening);
    }

    
    @Override
    public List<Seat> getSeatsByScreeningId(Long screening_id) {
        Screening screening = getScreeningById(screening_id);
        if (screening.getIsFull()) {
            return new ArrayList<>();
        }
        return new ArrayList<>(screening.getAuditorium().getSeats());
    }
}