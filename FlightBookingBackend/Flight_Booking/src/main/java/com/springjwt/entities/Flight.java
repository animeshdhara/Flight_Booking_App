package com.springjwt.entities;

import com.springjwt.requests.FlightRequest;
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

    private Long allocatedSeats;
    private Long totalSeats;
    private Long costPerSeat;

    private Double discount = 0D;
    private Integer time;
    private String airline;

    public Flight(FlightRequest request){
        this.arrivalCity = request.getArrivalCity();
        this.arrivalDate = request.getArrivalDate();
        this.arrivalTime = request.getArrivalTime();
        this.departureCity = request.getDepartureCity();
        this.departureDate = request.getDepartureDate();
        this.departureTime = request.getDepartureTime();
        this.allocatedSeats = request.getAllocatedSeats();
        this.totalSeats = request.getTotalSeats();
        this.costPerSeat = request.getCostPerSeat();
        this.discount = request.getDiscount();
        this.time = request.getTime();
        this.airline = request.getAirline();
    }

}
