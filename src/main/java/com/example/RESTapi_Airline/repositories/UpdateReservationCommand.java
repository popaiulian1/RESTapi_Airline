package com.example.RESTapi_Airline.repositories;

import com.example.RESTapi_Airline.models.Reservation;
import lombok.Getter;

@Getter
public class UpdateReservationCommand {
    private final int reservationId;
    private final Reservation reservation;

    public UpdateReservationCommand(int reservationId, Reservation reservation) {
        this.reservationId = reservationId;
        this.reservation = reservation;
    }
}
