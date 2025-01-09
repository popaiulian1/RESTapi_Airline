package com.example.RESTapi_Airline.services.reservationService;

import com.example.RESTapi_Airline.exceptions.ReservationNotFoundException;
import com.example.RESTapi_Airline.repositories.ReservationRepository;
import com.example.RESTapi_Airline.repositories.Utils.Command;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.RESTapi_Airline.models.Reservation;
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
