package com.example.RESTapi_Airline.services.flightService;

import com.example.RESTapi_Airline.exceptions.FlightNotFoundException;
import com.example.RESTapi_Airline.repositories.Utils.Command;
import com.example.RESTapi_Airline.repositories.FlightRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.RESTapi_Airline.models.Flight;
import java.util.Optional;

@Service
public class DeleteFlightService implements Command<Integer, Void>{

    private final FlightRepository flightRepository;

    public DeleteFlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public ResponseEntity<Void> execute(Integer input) {
        Optional<Flight> flight = flightRepository.findById(input);
        if (flight.isPresent()) {
            flightRepository.deleteById(input);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        throw new FlightNotFoundException();
    }
}
