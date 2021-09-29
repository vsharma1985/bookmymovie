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
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "city")
@JsonIgnoreProperties(ignoreUnknown = true) 
public class City {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "city_id")
    private Long id;
	
	 @Column(name = "city")
	 private String city;
	  
	  @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
	  @JsonBackReference
	  private Set<Theatre> theatre;
	  
	  

}
