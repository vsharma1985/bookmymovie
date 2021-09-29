package com.java.assignement.bookmymovie.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.assignement.bookmymovie.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {
	
	Seat getSeatById(Long theatre_id);
}