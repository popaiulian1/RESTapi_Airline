package com.example.flightsAppBackend.services.reservationService;

import com.example.flightsAppBackend.exceptions.ReservationNotFoundException;
import com.example.flightsAppBackend.repositories.ReservationRepository;
import com.example.flightsAppBackend.repositories.Utils.Command;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.flightsAppBackend.models.Reservation;
import java.util.Optional;

@Service
public class DeleteReservationService implements Command<Integer, Void> {

    private final ReservationRepository reservationRepository;

    public DeleteReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public ResponseEntity<Void> execute(Integer input) {
        Optional<Reservation> reservation = reservationRepository.findById(input);
        if (reservation.isPresent()) {
            reservationRepository.deleteById(input);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        throw new ReservationNotFoundException();
    }
}
