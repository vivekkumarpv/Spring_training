package com.airline.flights.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Airline {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String code;
	private boolean is_lowcost;
	private String logo;

//	@Id
//	private int id;
//	private String callsign;
//	private String ICAO;
//	private String IATA;
//	private String name;
//	private String country;
//	private int flights_last_24_hours;
//	private int airbourne;
//	private String url;
//	private LocalDateTime createdAt;
//	private LocalDateTime UpdatedAt;
}
