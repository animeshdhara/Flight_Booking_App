package com.springjwt.services.booking;

import com.springjwt.Error.*;
import com.springjwt.entities.Booking;
import com.springjwt.entities.Flight;
import com.springjwt.entities.User;
import com.springjwt.repositories.BookingRepository;
import com.springjwt.repositories.FlightRepository;
import com.springjwt.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Booking saveBooking(Booking booking) throws DuplicateBookingIdFoundException, UserFoundException, FlightNotFoundException {

        List<Booking> bookings = bookingRepository.findByUserId(booking.getUserId());

        // check for userid
        Optional<User> user = userRepository.findById(booking.getUserId());
        if(user.isEmpty()){
            throw new UserFoundException("User id does not exists in given booking.");
        }

        // check for flightId
        Optional<Flight> flight = flightRepository.findById(booking.getFlightId());
        if(flight.isEmpty()){
            throw new FlightNotFoundException("Flight id does not exists in flight.");
        }
        // check for booking ID
        for(Booking bk : bookings){
            if(Objects.equals(bk.getFlightId(), booking.getFlightId())){
                throw new DuplicateBookingIdFoundException("Duplicate Booking Id Found");
            }
        }




        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> fetchAllBooking() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking fetchBookingById(Long id) throws BookingIdNotFoundException {
        Optional<Booking> booking = bookingRepository.findById(id);
        if(booking.isEmpty()){
            throw new BookingIdNotFoundException("Booking id does not exists.");
        }
        return booking.get();
    }

    @Override
    public List<Booking> fetchBookingByUserId(Long userid) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(userid);
        if(user.isEmpty()){
            throw new UserNotFoundException("User id does not exists in given booking.");
        }

        return bookingRepository.findByUserId(userid);

    }

    @Override
    public List<Booking> fetchBookingByFlightId(Long flightid) throws FlightNotFoundException {
        Optional<Flight> flight = flightRepository.findById(flightid);
        if(flight.isEmpty()){
            throw new FlightNotFoundException("Flight id does not exists in given booking.");
        }

        return bookingRepository.findByFlightId(flightid);
    }

    @Override
    public String deleteBookingById(Long id) throws BookingIdNotFoundException {
        Optional<Booking> booking = bookingRepository.findById(id);
        if(booking.isEmpty()){
            throw new BookingIdNotFoundException("Booking id does not exists.");
        }
        bookingRepository.deleteById(id);
        return "Booking with id " + id + " deleted successfully";
    }

    @Override
    public String deleteAllBooking() {
        bookingRepository.deleteAll();
        return "All Booking id deleted successfully";
    }
}

