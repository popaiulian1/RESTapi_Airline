package com.example.flightsAppBackend.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private int reservationId;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "flight_id")
    private int flightId;

    @Column(name = "seat_number")
    private String seatNumber;

    @Column(name = "status")
    private String status;

}
