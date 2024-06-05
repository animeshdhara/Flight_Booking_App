package com.springjwt.controllers;

import com.springjwt.Error.*;
import com.springjwt.entities.Booking;
import com.springjwt.services.booking.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping("/booking/add")
    private Booking saveBooking(@RequestBody Booking booking) throws DuplicateBookingIdFoundException, FlightNotFoundException, UserFoundException {
        return bookingService.saveBooking(booking);
    }

    @GetMapping("/booking/getall")
    private List<Booking> fetchAllBooking(){
        return bookingService.fetchAllBooking();
    }

    @GetMapping("/booking/getbyid/{id}")
    private Booking fetchBookingById(@PathVariable ("id") Long Id) throws BookingIdNotFoundException {
        return bookingService.fetchBookingById(Id);
    }

    @GetMapping("/booking/getbyuserid/{userId}")
    private List<Booking> fetchBookingByUserId(@PathVariable("userId") Long userId) throws BookingIdNotFoundException, UserNotFoundException {
        return bookingService.fetchBookingByUserId(userId);
    }

    @GetMapping("/booking/getbyflightid/{flightId}")
    private List<Booking> fetchBookingByFlightId(@PathVariable("flightId") Long flightId) throws BookingIdNotFoundException, FlightNotFoundException {
        return bookingService.fetchBookingByFlightId(flightId);
    }


    @DeleteMapping("/booking/deletebyid/{id}")
    private String deleteBookingById(@PathVariable ("id") Long Id) throws BookingIdNotFoundException {
        return bookingService.deleteBookingById(Id);
    }

    @DeleteMapping("/booking/deleteall")
    private String deleteAllBooking() throws BookingIdNotFoundException {
        return bookingService.deleteAllBooking();
    }


}
