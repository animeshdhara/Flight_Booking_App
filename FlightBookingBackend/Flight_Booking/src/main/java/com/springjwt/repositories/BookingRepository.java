package com.springjwt.repositories;

import com.springjwt.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,Long> {
    public List<Booking> findByUserId(Long userId);
    public List<Booking> findByFlightId(Long flightId);
}

