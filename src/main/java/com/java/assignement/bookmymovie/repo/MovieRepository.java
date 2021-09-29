package com.java.assignement.bookmymovie.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.assignement.bookmymovie.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}