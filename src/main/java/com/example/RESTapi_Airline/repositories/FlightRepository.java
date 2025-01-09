package com.example.RESTapi_Airline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.RESTapi_Airline.models.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
}
