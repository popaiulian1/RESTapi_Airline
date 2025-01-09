package com.example.RESTapi_Airline.services.flightService;

import com.example.RESTapi_Airline.DTOs.FlightDTO;
import com.example.RESTapi_Airline.exceptions.FlightNotFoundException;
import com.example.RESTapi_Airline.repositories.FlightRepository;
import com.example.RESTapi_Airline.repositories.Utils.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.RESTapi_Airline.models.Flight;
import java.util.Optional;

@Service
public class GetFlightService implements Query<Integer, FlightDTO> {

    private final FlightRepository flightRepository;

    public GetFlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public ResponseEntity<FlightDTO> execute(Integer input) {

        Optional<Flight> flightOptional = flightRepository.findById(input);

        if (flightOptional.isPresent()) {
            return ResponseEntity.ok(new FlightDTO(flightOptional.get()));
        }

        throw  new FlightNotFoundException();
    }
}
