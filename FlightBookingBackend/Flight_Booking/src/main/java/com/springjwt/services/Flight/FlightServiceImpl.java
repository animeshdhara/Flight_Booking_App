package com.springjwt.services.Flight;

import com.springjwt.Error.DuplicateFlightFoundException;
import com.springjwt.Error.FlightNotFoundException;
import com.springjwt.entities.Flight;
import com.springjwt.repositories.FlightRepository;
import com.springjwt.requests.FlightRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class FlightServiceImpl implements FlightService{

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public Flight saveFlight(FlightRequest request) throws DuplicateFlightFoundException {

//        List<Flight> flights = flightRepository.findByArrivalCity(flight.getArrivalCity());


//        for(Flight fl : flights){
//            if(Objects.equals(fl.getArrivalDate(), flight.getArrivalDate())
//                    && Objects.equals(fl.getArrivalTime(), flight.getArrivalTime())
//                    && Objects.equals(fl.getDepartureCity(), flight.getDepartureCity())
//                    && Objects.equals(fl.getDepartureTime(), flight.getDepartureTime())
//                    && Objects.equals(fl.getDepartureDate(), flight.getDepartureDate()))
//            {
//                throw  new DuplicateFlightFoundException("FLight with same attributes already exists.");
//            }
//        }

        Flight flight = new Flight(request);

        return flightRepository.save(flight);
    }

    @Override
    public List<Flight> fetchFlights() {
        return flightRepository.findAll();
    }

    @Override
    public Flight fetchFlightById(Long flightId) throws FlightNotFoundException {
        Optional<Flight> flight = flightRepository.findById(flightId);
        if(flight.isEmpty()){
            throw new FlightNotFoundException("Flight with given id does not exists.");
        }
        return flight.get();
    }

    @Override
    public Flight updateFlight(Long flightId, Flight updatedFlight) throws FlightNotFoundException {
        Optional<Flight> flight = flightRepository.findById(flightId);
        if(flight.isEmpty()){
            throw new FlightNotFoundException("Flight with given id does not exists.");
        }

        return flightRepository.save(updatedFlight);
    }

    @Override
    public String deleteFlight(Long flightId) throws FlightNotFoundException {
        if(flightRepository.findById(flightId).isEmpty()){
            throw new FlightNotFoundException("Flight with given id does not exists.");
        }
        flightRepository.deleteById(flightId);
        return "Flight with id " + flightId + " deleted successfully";
    }

    @Override
    public List<Flight> fetchFlightByArrivalCity(String arrivalcity) throws FlightNotFoundException {
        List<Flight> flights = flightRepository.findByArrivalCity(arrivalcity);
        if(flights.isEmpty()){
            throw new FlightNotFoundException("Flight with given arrival city does not exists.");
        }
        return flights;
    }

    @Override
    public List<Flight> fetchFlightByDepartureCity(String departurecity) throws FlightNotFoundException {
        List<Flight> flights = flightRepository.findByDepartureCity(departurecity);
        if(flights.isEmpty()){
            throw new FlightNotFoundException("Flight with given departure city does not exists.");
        }
        return flights;
    }

    @Override
    public List<Flight> fetchFlightByCity(String arrivalcity, String departurecity) throws FlightNotFoundException {
        List<Flight> flights = flightRepository.findByCity(arrivalcity,departurecity);
        if(flights.isEmpty()){
            throw new FlightNotFoundException("Flight with given arrival and departure city does not exists.");
        }
        return flights;
    }

    @Override
    public List<Flight> getSpecialFlights() {
        return flightRepository.findBySpecialDeal();
    }
}
