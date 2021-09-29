package com.java.assignement.bookmymovie.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.assignement.bookmymovie.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
	Booking getBookingById(Long id);
}
