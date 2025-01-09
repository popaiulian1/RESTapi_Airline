package com.example.RESTapi_Airline.services.reservationService;

import com.example.RESTapi_Airline.DTOs.ReservationDTO;
import com.example.RESTapi_Airline.models.Reservation;
import com.example.RESTapi_Airline.repositories.ReservationRepository;
import com.example.RESTapi_Airline.repositories.Utils.Command;
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
