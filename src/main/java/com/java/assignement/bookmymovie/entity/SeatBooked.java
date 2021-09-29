package com.java.assignement.bookmymovie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "seat_booked")
@JsonIgnoreProperties(ignoreUnknown = true) 
public class SeatBooked {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "seat_booked_id")
    private Long id;

    
    @ManyToOne
    @JoinColumn(name = "seat_id")
    @JsonManagedReference
    private Seat seat;

    
    @ManyToOne
    @JoinColumn(name = "booking_id")
    @JsonManagedReference
    private Booking booking;

    
    @ManyToOne
    @JoinColumn(name = "screening_id")
    @JsonManagedReference
    private Screening screening;
}