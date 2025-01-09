package com.example.flightsAppBackend.services.reservationService;

import com.example.flightsAppBackend.DTOs.ReservationDTO;
import com.example.flightsAppBackend.models.Reservation;
import com.example.flightsAppBackend.repositories.ReservationRepository;
import com.example.flightsAppBackend.repositories.Utils.Query;
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
