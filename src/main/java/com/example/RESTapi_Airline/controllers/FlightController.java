package com.example.RESTapi_Airline.controllers;

import com.example.RESTapi_Airline.DTOs.FlightDTO;
import com.example.RESTapi_Airline.models.Flight;
import com.example.RESTapi_Airline.repositories.UpdateFlightCommand;
import com.example.RESTapi_Airline.services.flightService.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlightController {
    private final CreateFlightService createFlightService;
    private final DeleteFlightService deleteFlightService;
    private final GetFlightService getFlightService;
    private final GetAllFlightsService getAllFlightsService;
    private final UpdateFlightService updateFlightService;

    public FlightController(CreateFlightService createFlightService, DeleteFlightService deleteFlightService,
                            GetFlightService getFlightService, GetAllFlightsService getAllFlightsService,
                            UpdateFlightService updateFlightService)
    {
        this.createFlightService = createFlightService;
        this.deleteFlightService = deleteFlightService;
        this.getFlightService = getFlightService;
        this.getAllFlightsService = getAllFlightsService;
        this.updateFlightService = updateFlightService;
    }

    @GetMapping("/flights")
    public ResponseEntity<List<FlightDTO>> getFlights() { return getAllFlightsService.execute(null);}

    @GetMapping("/flight/{id}")
    public ResponseEntity<FlightDTO> getFlight(@PathVariable int id) {return getFlightService.execute(id);}

    @DeleteMapping("/flight/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable int id) {return deleteFlightService.execute(id);}

    @PostMapping("/flight")
    public ResponseEntity<FlightDTO> addFlight(@RequestBody Flight flight) {return createFlightService.execute(flight);}

    @PutMapping("/flight/{id}")
    public ResponseEntity<FlightDTO> updateFlight(@PathVariable Integer id, @RequestBody Flight flight)
    {
        return updateFlightService.execute(new UpdateFlightCommand(id, flight));
    }

}
