package com.java.assignement.bookmymovie.service;

import java.time.LocalDate;
import java.util.List;

import com.java.assignement.bookmymovie.entity.Movie;
import com.java.assignement.bookmymovie.entity.Screening;

public interface MovieService {
    List<Movie> getAllMovies();

    Movie getMovieById(Long movie_id);

    Movie addMovie(Movie newMovie);

    void deleteMovie(Long movie_id);

    List<Screening> getAllScreeningByMovieId(Long movie_id);

    List<Screening> getAllScreeningByMovieIdAndDate(Long movie_id, LocalDate localDate);
}