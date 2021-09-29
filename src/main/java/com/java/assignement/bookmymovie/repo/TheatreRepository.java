package com.java.assignement.bookmymovie.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.assignement.bookmymovie.entity.Theatre;

public interface TheatreRepository extends JpaRepository<Theatre, Long> {

	List<Theatre> findByCity(String city);
}