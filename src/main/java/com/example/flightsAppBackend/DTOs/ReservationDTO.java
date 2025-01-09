package com.example.flightsAppBackend.DTOs;

import com.example.flightsAppBackend.models.Reservation;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@Data
@JsonSerialize
public class ReservationDTO {
    private int reservationId;
    private int userId;
    private int flightId;
    private String seatNumber;
    private String status;

    public ReservationDTO(Reservation reservation) {
        this.reservationId = reservation.getReservationId();
        this.userId = reservation.getUserId();
        this.flightId = reservation.getFlightId();
        this.seatNumber = reservation.getSeatNumber();
        this.status = reservation.getStatus();
    }
}
