package com.springjwt.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long flightId;

    private String arrivalCity;
    private String arrivalTime;
    private String arrivalDate;
    private String departureCity;
    private String departureTime;
    private String departureDate;
    private Integer allocatedSeats;
    private Integer totalSeats;
    private Integer costPerSeat;
    private Double discount;
    private Integer time;
    private String airline;

}
