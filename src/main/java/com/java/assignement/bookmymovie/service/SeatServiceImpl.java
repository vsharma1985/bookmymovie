package com.java.assignement.bookmymovie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.java.assignement.bookmymovie.entity.Seat;
import com.java.assignement.bookmymovie.repo.SeatRepository;

@Service
@Primary
public class SeatServiceImpl implements SeatService {
    private SeatRepository seatRepository;

    @Autowired
    public SeatServiceImpl(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    @Override
    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    @Override
    public Seat getSeatById(Long seat_id) {
    	return seatRepository.getSeatById(seat_id);
       
    }

    @Override
    public Seat addSeat(Seat newSeat) {
        return seatRepository.save(newSeat);
    }

  

    @Override
    public void deleteSeatById(Long seat_id) {
    	seatRepository.delete(getSeatById(seat_id));
    }
}