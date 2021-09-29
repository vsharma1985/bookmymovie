package com.java.assignement.bookmymovie.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "theatre")
@JsonIgnoreProperties(ignoreUnknown = true) 
public class Theatre {

	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "theatre_id")
	    private Long id;

	    @Column(name = "name")
	    private String name;

	    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
	    @JsonBackReference
	    private Set<Auditorium> auditoriums;
    
	  
	    @ManyToOne
	    @JoinColumn(name = "city_id")
	    @JsonManagedReference
	    private City city;
	    
}