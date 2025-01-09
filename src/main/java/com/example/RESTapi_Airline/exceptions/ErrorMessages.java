package com.example.RESTapi_Airline.exceptions;

import lombok.Getter;

@Getter
public enum ErrorMessages {
    FLIGHT_NOT_FOUND("Flight not found"),
    RESERVATION_NOT_FOUND("Reservation not found");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }
}
