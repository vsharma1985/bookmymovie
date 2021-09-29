package com.java.assignement.bookmymovie.service;

import java.util.List;

import com.java.assignement.bookmymovie.entity.Seat;

public interface SeatService {
    List<Seat> getAllSeats();

    Seat getSeatById(Long seat_id);

    Seat addSeat(Seat newSeat);
  
    void deleteSeatById(Long seat_id);
}