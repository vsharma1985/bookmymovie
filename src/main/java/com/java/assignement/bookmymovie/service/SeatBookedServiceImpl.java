package com.java.assignement.bookmymovie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.java.assignement.bookmymovie.entity.SeatBooked;
import com.java.assignement.bookmymovie.repo.SeatBookedRepository;

@Service
@Primary
public class SeatBookedServiceImpl implements SeatBookedService {
    private SeatBookedRepository seatBookedRepository;

    @Autowired
    public SeatBookedServiceImpl(SeatBookedRepository seatBookedRepository) {
        this.seatBookedRepository = seatBookedRepository;
    }

    @Override
    public List<SeatBooked> getAllSeatBooked() {
        return seatBookedRepository.findAll();
    }

    @Override
    public SeatBooked getSeatBookedById(Long seat_booked_id) {
        return seatBookedRepository.getById(seat_booked_id);
    }

    @Override
    public SeatBooked createSeatBooked(SeatBooked newSeatBooked) {
        return seatBookedRepository.save(newSeatBooked);
    }

    @Override
    public void deleteSeatBookedById(Long seat_booked_id) {
    	seatBookedRepository.delete(getSeatBookedById(seat_booked_id));
    }
}