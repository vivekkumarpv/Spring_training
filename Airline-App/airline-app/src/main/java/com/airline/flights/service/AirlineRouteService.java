package com.airline.flights.service;

import java.time.LocalDate;
import java.util.List;

import com.airline.flights.Model.AirlineRoute;
import com.airline.routes.dto.GetDetailedItineraryResponse;
import com.airline.routes.dto.MultiCityRouteRequestBody;
import com.airline.routes.dto.MultiCityRouteResponse;
import com.airline.routes.dto.OneWayRoundTripRequestBody;
import com.airline.routes.dto.OneWayRoundTripResponse;

public interface AirlineRouteService {
	public List<AirlineRoute> getAllAirlineRoutes();

	public List<AirlineRoute> searchAirline(String destination, String arrival, LocalDate date, String category);

	public List<AirlineRoute> searchRouteForGivenSourceDestination(String arrival, String destination);

	public List<GetDetailedItineraryResponse> getDetailedItinerary(List<Integer> routeId);
	
	public List<MultiCityRouteResponse> getMultiCityRouteSearch(MultiCityRouteRequestBody multiCityReqBody);
	
	public List<OneWayRoundTripResponse> getOneWayRoundTripSearch(OneWayRoundTripRequestBody oneWayRoundTripReqBody);
 }
