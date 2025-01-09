package com.example.RESTapi_Airline.services.reservationService;

import com.example.RESTapi_Airline.DTOs.ReservationDTO;
import com.example.RESTapi_Airline.exceptions.ReservationNotFoundException;
import com.example.RESTapi_Airline.models.Reservation;
import com.example.RESTapi_Airline.repositories.ReservationRepository;
import com.example.RESTapi_Airline.repositories.UpdateReservationCommand;
import com.example.RESTapi_Airline.repositories.Utils.Command;
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
