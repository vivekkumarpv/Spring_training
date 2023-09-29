package com.airline.flights.contoller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.airline.flights.Model.AirlineRoute;
import com.airline.flights.service.AirlineRouteService;
import com.airline.routes.dto.GetDetailedItineraryResponse;
import com.airline.routes.dto.MultiCityRouteRequestBody;
import com.airline.routes.dto.MultiCityRouteResponse;
import com.airline.routes.dto.OneWayRoundTripRequestBody;
import com.airline.routes.dto.OneWayRoundTripResponse;

@RestController
@RequestMapping("/api/airline/routes")
@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "http://localhost:3000")
public class AirlineRouteController {

	@Autowired
	AirlineRouteService airlineRouteService;

	@GetMapping
	public List<AirlineRoute> fetchAllAirlineRoute() {
		return airlineRouteService.getAllAirlineRoutes();

	}

	
	@PostMapping("/filter")
	public List<AirlineRoute> searchAirlineRoutes(@RequestParam String destination, @RequestParam String source,
			@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestParam String category) {
		return airlineRouteService.searchAirline(destination, source, date, category);

	}


	@PostMapping("/search")
	public List<AirlineRoute> searchRouteForGivenSourceDestination(@RequestParam String source,
			@RequestParam String destination) {
		return airlineRouteService.searchRouteForGivenSourceDestination(source, destination);
	}

	@PostMapping("/getdetaileditinerary")
	public List<GetDetailedItineraryResponse> fetchDetailedItinerary(@RequestBody List<Integer> routeIds) {
		return airlineRouteService.getDetailedItinerary(routeIds);
	}

	@PostMapping("/multicity")
	public List<MultiCityRouteResponse> fetchMulticityAirlineRoutes(
			@RequestBody MultiCityRouteRequestBody multiCityReqBody) {
		return airlineRouteService.getMultiCityRouteSearch(multiCityReqBody);
	}

	@PostMapping("/onewayround")
	public List<OneWayRoundTripResponse> fetchOneWayRoundTripAirlineRoute(
			@RequestBody OneWayRoundTripRequestBody oneWayRoundTripReqBody) {
		return airlineRouteService.getOneWayRoundTripSearch(oneWayRoundTripReqBody);
	}
}
