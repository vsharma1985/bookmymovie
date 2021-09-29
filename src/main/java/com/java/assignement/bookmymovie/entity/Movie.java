package com.java.assignement.bookmymovie.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "MOVIE")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {

	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "movie_id")
	    private Long id;

	    @Column(name = "title")
	    private String title;

	    @Column(name = "genre")
	    private String genre;

	    @Column(name = "duration")
	    private Integer duration;

	    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
	    @JsonBackReference
	    private Set<Screening> screenings;
	    
	
}


