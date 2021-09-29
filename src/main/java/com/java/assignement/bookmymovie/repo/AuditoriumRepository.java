package com.java.assignement.bookmymovie.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.assignement.bookmymovie.entity.Auditorium;

public interface AuditoriumRepository extends JpaRepository<Auditorium, Long> {
}