package com.springjwt.repositories;

import com.springjwt.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;


public interface FlightRepository extends JpaRepository<Flight,Long> {

    public List<Flight> findByArrivalCity(String arrivalCity);
    public List<Flight> findByDepartureCity(String departureCity);

    @Query("SELECT f FROM Flight f WHERE f.arrivalCity = ?1 AND f.departureCity = ?2")
    public List<Flight> findByCity(String arrivalCity,String departureCity);

    @Query("SELECT f FROM Flight f WHERE f.discount != 0")
    public List<Flight> findBySpecialDeal();
}

