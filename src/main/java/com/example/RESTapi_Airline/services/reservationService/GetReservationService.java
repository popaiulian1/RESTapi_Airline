package com.example.RESTapi_Airline.services.reservationService;

import com.example.RESTapi_Airline.DTOs.ReservationDTO;
import com.example.RESTapi_Airline.exceptions.ReservationNotFoundException;
import com.example.RESTapi_Airline.models.Reservation;
import com.example.RESTapi_Airline.repositories.ReservationRepository;
import com.example.RESTapi_Airline.repositories.Utils.Query;
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
