package com.example.RESTapi_Airline.services.flightService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.RESTapi_Airline.DTOs.FlightDTO;
import com.example.RESTapi_Airline.models.Flight;
import com.example.RESTapi_Airline.repositories.Utils.Command;
import com.example.RESTapi_Airline.repositories.FlightRepository;

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
