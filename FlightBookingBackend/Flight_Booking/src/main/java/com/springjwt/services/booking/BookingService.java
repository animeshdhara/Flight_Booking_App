package com.springjwt.services.booking;

import com.springjwt.Error.*;
import com.springjwt.entities.Booking;

import java.util.List;

public interface BookingService {
    Booking saveBooking(Booking booking) throws DuplicateBookingIdFoundException, UserFoundException, FlightNotFoundException;

    List<Booking> fetchAllBooking();

    Booking fetchBookingById(Long id) throws BookingIdNotFoundException;

    List<Booking> fetchBookingByUserId(Long userid) throws UserNotFoundException;

    List<Booking> fetchBookingByFlightId(Long flightid) throws FlightNotFoundException;

    String deleteBookingById(Long id) throws BookingIdNotFoundException;

    String deleteAllBooking();
}
