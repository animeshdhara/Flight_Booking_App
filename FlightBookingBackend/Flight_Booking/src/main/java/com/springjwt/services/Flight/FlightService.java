package com.springjwt.services.Flight;


import com.springjwt.Error.DuplicateFlightFoundException;
import com.springjwt.Error.FlightNotFoundException;
import com.springjwt.entities.Flight;
import com.springjwt.requests.FlightRequest;

import java.util.List;

public interface FlightService {
    Flight saveFlight(FlightRequest flight) throws DuplicateFlightFoundException;

    List<Flight> fetchFlights();

    Flight fetchFlightById(Long flightId) throws FlightNotFoundException;

    Flight updateFlight(Long flightId, Flight updatedFlight) throws FlightNotFoundException;

    String deleteFlight(Long flightId) throws FlightNotFoundException;

    List<Flight> fetchFlightByArrivalCity(String arrivalcity) throws FlightNotFoundException;

    List<Flight> fetchFlightByDepartureCity(String departurecity) throws FlightNotFoundException;

    List<Flight> fetchFlightByCity(String arrivalcity, String departurecity) throws FlightNotFoundException;

    List<Flight> getSpecialFlights();
}
