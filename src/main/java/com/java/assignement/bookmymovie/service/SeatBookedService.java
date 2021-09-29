package com.java.assignement.bookmymovie.service;

import java.util.List;

import com.java.assignement.bookmymovie.entity.SeatBooked;

public interface SeatBookedService {
    List<SeatBooked> getAllSeatBooked();

    SeatBooked getSeatBookedById(Long seat_booked_id);

    SeatBooked createSeatBooked(SeatBooked newSeatBooked);

    void deleteSeatBookedById(Long seat_booked_id);
}