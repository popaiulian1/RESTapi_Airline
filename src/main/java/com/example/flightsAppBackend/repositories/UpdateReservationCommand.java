package com.example.flightsAppBackend.repositories;

import com.example.flightsAppBackend.models.Reservation;
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
