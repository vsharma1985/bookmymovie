package com.java.assignement.bookmymovie.service;

import java.util.List;

import com.java.assignement.bookmymovie.entity.Booking;

public interface BookingService {
    List<Booking> getAllBookings();

    Booking getBookingById(Long booking_id);

    Booking createBooking(Booking newBooking);

    Booking updateBooking(Booking updatedBooking, Long booking_id);

    void deleteBookingById(Long booking_id);
}