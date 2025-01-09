package com.example.flightsAppBackend.services.flightService;

import com.example.flightsAppBackend.repositories.FlightRepository;
import com.example.flightsAppBackend.repositories.Utils.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.flightsAppBackend.models.Flight;
import com.example.flightsAppBackend.DTOs.FlightDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetAllFlightsService implements Query<Void, List<FlightDTO>> {

    private final FlightRepository flightRepository;

    public GetAllFlightsService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public ResponseEntity<List<FlightDTO>> execute(Void input) {
        List<Flight> flights = flightRepository.findAll();
        List<FlightDTO> flightDTOS = new ArrayList<>();

        for(Flight flight : flights) {
            flightDTOS.add(new FlightDTO(flight));
        }

        return ResponseEntity.status(HttpStatus.OK).body(flightDTOS);
    }
}
