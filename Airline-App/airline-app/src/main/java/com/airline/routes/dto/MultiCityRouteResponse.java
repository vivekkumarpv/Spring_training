package com.airline.routes.dto;

import java.time.LocalDate;
import java.util.List;

import com.airline.flights.Model.AirlineRoute;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MultiCityRouteResponse {
	private LocalDate date;
	private String iataFrom;
	private String iataTo;
	private List<AirlineRoute> routeResults;

}
