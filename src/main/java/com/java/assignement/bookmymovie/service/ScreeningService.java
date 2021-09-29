package com.java.assignement.bookmymovie.service;

import java.time.LocalDate;
import java.util.List;

import com.java.assignement.bookmymovie.entity.Screening;
import com.java.assignement.bookmymovie.entity.Seat;

public interface ScreeningService {
    List<Screening> getAllScreenings();

    Screening getScreeningById(Long screening_id);

    Screening createScreening(Screening newScreening);

    List<Seat> getSeatsByScreeningId(Long screening_id);

    List<Screening> getAllScreenings(LocalDate startDate, LocalDate endDate);
}
