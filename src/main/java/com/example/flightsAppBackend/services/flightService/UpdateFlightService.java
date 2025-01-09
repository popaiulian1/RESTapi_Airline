package com.example.flightsAppBackend.services.flightService;

import com.example.flightsAppBackend.exceptions.FlightNotFoundException;
import com.example.flightsAppBackend.models.Flight;
import com.example.flightsAppBackend.repositories.FlightRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.flightsAppBackend.repositories.UpdateFlightCommand;
import com.example.flightsAppBackend.DTOs.FlightDTO;
import com.example.flightsAppBackend.repositories.Utils.Command;
import java.util.Optional;

@Service
public class UpdateFlightService implements Command<UpdateFlightCommand, FlightDTO>{

    private final FlightRepository flightRepository;

    public UpdateFlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public ResponseEntity<FlightDTO> execute(UpdateFlightCommand command) {
        Optional<Flight> flightOptional = flightRepository.findById(command.getFlightId());
        if(flightOptional.isPresent()) {
            Flight flight = command.getFlight();
            flight.setFlightId(command.getFlightId());
            flightRepository.save(flight);
            return ResponseEntity.ok(new FlightDTO(flight));
        }

        throw new FlightNotFoundException();
    }
}
