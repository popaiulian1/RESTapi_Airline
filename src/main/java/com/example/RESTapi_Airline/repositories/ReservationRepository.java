package com.example.RESTapi_Airline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.RESTapi_Airline.models.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
