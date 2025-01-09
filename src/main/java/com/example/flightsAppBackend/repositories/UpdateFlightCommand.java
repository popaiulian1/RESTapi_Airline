package com.example.flightsAppBackend.repositories;

import com.example.flightsAppBackend.models.Flight;
import lombok.Getter;

@Getter
public class UpdateFlightCommand {
    private final Integer flightId;
    private final Flight flight;

    public UpdateFlightCommand(Integer flightId, Flight flight) {
        this.flightId = flightId;
        this.flight = flight;
    }
}
