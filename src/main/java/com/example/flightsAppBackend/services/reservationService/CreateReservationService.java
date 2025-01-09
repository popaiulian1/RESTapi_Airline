package com.example.flightsAppBackend.services.reservationService;

import com.example.flightsAppBackend.DTOs.ReservationDTO;
import com.example.flightsAppBackend.models.Reservation;
import com.example.flightsAppBackend.repositories.ReservationRepository;
import com.example.flightsAppBackend.repositories.Utils.Command;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateReservationService implements Command<Reservation, ReservationDTO>
{
    private final ReservationRepository reservationRepository;

    public CreateReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public ResponseEntity<ReservationDTO> execute(Reservation reservation) {
        Reservation savedReservation = reservationRepository.save(reservation);
        return ResponseEntity.status(HttpStatus.OK).body(new ReservationDTO(savedReservation));
    }

}
