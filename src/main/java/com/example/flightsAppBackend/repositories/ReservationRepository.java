package com.example.flightsAppBackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.flightsAppBackend.models.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
