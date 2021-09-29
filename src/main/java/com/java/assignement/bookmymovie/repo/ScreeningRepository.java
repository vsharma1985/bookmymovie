package com.java.assignement.bookmymovie.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.assignement.bookmymovie.entity.Screening;

public interface ScreeningRepository extends JpaRepository<Screening, Long> {}
