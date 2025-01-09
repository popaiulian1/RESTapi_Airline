package com.example.flightsAppBackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.flightsAppBackend.models.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
}
