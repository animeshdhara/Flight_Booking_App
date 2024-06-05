package com.springjwt.controllers;

import com.springjwt.Error.DuplicateFlightFoundException;
import com.springjwt.Error.FlightNotFoundException;
import com.springjwt.entities.Flight;
import com.springjwt.services.Flight.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping("/flight/add")
    public Flight saveFlight(@RequestBody Flight flight) throws DuplicateFlightFoundException {

        return flightService.saveFlight(flight);
    }

    @GetMapping("/flight/getall")
    public List<Flight> fetchFlights(){
        return flightService.fetchFlights();
    }

    @GetMapping("/flight/getbyid/{id}")
    public Flight fetchFlightById(@PathVariable("id") Long flightId) throws FlightNotFoundException {
        return flightService.fetchFlightById(flightId);
    }

    @GetMapping("/flight/getbyarrivalcity/{arrivalcity}")
    public List<Flight> fetchFlightByArrivalCity(@PathVariable("arrivalcity") String arrivalcity) throws FlightNotFoundException {
        return flightService.fetchFlightByArrivalCity(arrivalcity);
    }

    @GetMapping("/flight/getbydeparturecity/{departurecity}")
    public List<Flight> fetchFlightByDepartureCity(@PathVariable("departurecity") String departurecity) throws FlightNotFoundException {
        return flightService.fetchFlightByDepartureCity(departurecity);
    }

    @GetMapping("/flight/getbycity/{arrivalcity}-{departurecity}")
    public List<Flight> fetchFlightByCity(
            @PathVariable("arrivalcity") String arrivalcity
            ,@PathVariable("departurecity") String departurecity)
            throws FlightNotFoundException {
        System.out.println(arrivalcity);
        System.out.println(departurecity);
        return flightService.fetchFlightByCity(arrivalcity,departurecity);
    }



    @PutMapping("/flight/updatebyid/{id}")
    public Flight updateFlight(@PathVariable ("id") Long flightId,
                               @RequestBody Flight updatedFlight) throws FlightNotFoundException {
        return flightService.updateFlight(flightId,updatedFlight);
    }

    @DeleteMapping("/flight/deletebyid/{id}")
    public String deleteFlight(@PathVariable ("id") Long flightId) throws FlightNotFoundException {
        return flightService.deleteFlight(flightId);
    }

    @GetMapping("/flight/getspecialdeals")
    public List<Flight> getSpecialFlights(){
        return flightService.getSpecialFlights();
    }

}
