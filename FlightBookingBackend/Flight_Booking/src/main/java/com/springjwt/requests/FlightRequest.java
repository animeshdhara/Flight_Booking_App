package com.springjwt.requests;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FlightRequest {

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

    public FlightRequest(String arrivalCity, String arrivalTime, String arrivalDate, String departureCity, String departureTime, String departureDate, Long allocatedSeats, Long totalSeats, Long costPerSeat, Double discount, Integer time, String airline) {
        this.arrivalCity = arrivalCity;
        this.arrivalTime = arrivalTime;
        this.arrivalDate = arrivalDate;
        this.departureCity = departureCity;
        this.departureTime = departureTime;
        this.departureDate = departureDate;
        this.allocatedSeats = allocatedSeats;
        this.totalSeats = totalSeats;
        this.costPerSeat = costPerSeat;
        this.discount = discount;
        this.time = time;
        this.airline = airline;
    }
}
