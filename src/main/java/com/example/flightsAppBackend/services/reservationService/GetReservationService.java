package com.example.flightsAppBackend.services.reservationService;

import com.example.flightsAppBackend.DTOs.ReservationDTO;
import com.example.flightsAppBackend.exceptions.ReservationNotFoundException;
import com.example.flightsAppBackend.models.Reservation;
import com.example.flightsAppBackend.repositories.ReservationRepository;
import com.example.flightsAppBackend.repositories.Utils.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetReservationService implements Query<Integer, ReservationDTO> {

    private final ReservationRepository reservationRepository;

    public GetReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public ResponseEntity<ReservationDTO> execute(Integer input) {
        Optional<Reservation> reservationOptional = reservationRepository.findById(input);
        if (reservationOptional.isPresent()) {
            return ResponseEntity.ok(new ReservationDTO(reservationOptional.get()));
        }

        throw new ReservationNotFoundException();
    }
}
