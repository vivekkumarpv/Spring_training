package com.airline.routes.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OneWayRoundTripRequestBody {
	private List<String> classList;
    private List<RouteInput> routesList;

}
