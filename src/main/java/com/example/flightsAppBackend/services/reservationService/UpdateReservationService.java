package com.example.flightsAppBackend.services.reservationService;

import com.example.flightsAppBackend.DTOs.ReservationDTO;
import com.example.flightsAppBackend.exceptions.ReservationNotFoundException;
import com.example.flightsAppBackend.models.Reservation;
import com.example.flightsAppBackend.repositories.ReservationRepository;
import com.example.flightsAppBackend.repositories.UpdateReservationCommand;
import com.example.flightsAppBackend.repositories.Utils.Command;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateReservationService implements Command<UpdateReservationCommand, ReservationDTO>
{
    private final ReservationRepository reservationRepository;

    public UpdateReservationService(ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }

    @Override
    public ResponseEntity<ReservationDTO> execute(UpdateReservationCommand input) {
        Optional<Reservation> reservationOptional = reservationRepository.findById(input.getReservationId());
        if(reservationOptional.isPresent()){
            Reservation reservation = input.getReservation();
            reservation.setReservationId(input.getReservationId());
            reservationRepository.save(reservation);
            return ResponseEntity.ok(new ReservationDTO(reservation));
        }

        throw new ReservationNotFoundException();
    }
}
