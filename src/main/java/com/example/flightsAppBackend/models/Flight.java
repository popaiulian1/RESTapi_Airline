package com.example.flightsAppBackend.models;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id")
    private Integer flightId;

    @Column(name = "flight_origin")
    private String flightOrigin;

    @Column(name = "flight_destination")
    private String flightDestination;

    @Column(name = "flight_departure_time")
    private Timestamp flightDepartureTime;

    @Column(name = "flight_arrival_time")
    private Timestamp flightArrivalTime;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "price")
    private Double price;
}
