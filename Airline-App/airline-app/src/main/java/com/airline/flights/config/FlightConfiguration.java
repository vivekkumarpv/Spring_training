package com.airline.flights.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class FlightConfiguration {
	@Bean
	public RestTemplate getRestTemplate() {
		RestTemplate restClient = new RestTemplate();
		return restClient;
	}
}
