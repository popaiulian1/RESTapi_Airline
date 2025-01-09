package com.example.flightsAppBackend.services.flightService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.flightsAppBackend.DTOs.FlightDTO;
import com.example.flightsAppBackend.models.Flight;
import com.example.flightsAppBackend.repositories.Utils.Command;
import com.example.flightsAppBackend.repositories.FlightRepository;

@Service
public class CreateFlightService implements Command<Flight, FlightDTO>{

    private final FlightRepository flightRepository;

    public CreateFlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public ResponseEntity<FlightDTO> execute(Flight input) {
        Flight flight = flightRepository.save(input);
        return ResponseEntity.status(HttpStatus.OK).body(new FlightDTO(flight));
    }
}
