package com.example.flightsAppBackend.DTOs;

import com.example.flightsAppBackend.models.Flight;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.sql.Timestamp;

@Data
@JsonSerialize
public class FlightDTO {
    private Integer flightId;
    private String flightOrigin;
    private String flightDestination;
    private Timestamp flightDepartureTime;
    private Timestamp flightArrivalTime;
    private Integer capacity;
    private Double price;

    public FlightDTO(Flight flight) {
        this.flightId = flight.getFlightId();
        this.flightOrigin = flight.getFlightOrigin();
        this.flightDestination = flight.getFlightDestination();
        this.flightDepartureTime = flight.getFlightDepartureTime();
        this.flightArrivalTime = flight.getFlightArrivalTime();
        this.capacity = flight.getCapacity();
        this.price = flight.getPrice();
    }
}
