package com.java.assignement.bookmymovie.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.assignement.bookmymovie.entity.SeatBooked;

public interface SeatBookedRepository extends JpaRepository<SeatBooked, Long> {
}