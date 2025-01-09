package com.example.RESTapi_Airline.services.reservationService;

import com.example.RESTapi_Airline.DTOs.ReservationDTO;
import com.example.RESTapi_Airline.models.Reservation;
import com.example.RESTapi_Airline.repositories.ReservationRepository;
import com.example.RESTapi_Airline.repositories.Utils.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetAllReservationsService implements Query<Void, List<ReservationDTO>> {

    private final ReservationRepository reservationRepository;

    public GetAllReservationsService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public ResponseEntity<List<ReservationDTO>> execute(Void input) {
        List<Reservation> reservations = reservationRepository.findAll();
        List<ReservationDTO> reservationDTOS = new ArrayList<>();

        for (Reservation reservation : reservations) {
            reservationDTOS.add(new ReservationDTO(reservation));
        }
        return ResponseEntity.status(HttpStatus.OK).body(reservationDTOS);
    }
}
