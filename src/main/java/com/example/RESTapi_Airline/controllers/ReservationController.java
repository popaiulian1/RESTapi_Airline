package com.example.RESTapi_Airline.controllers;

import com.example.RESTapi_Airline.DTOs.ReservationDTO;
import com.example.RESTapi_Airline.models.Reservation;
import com.example.RESTapi_Airline.repositories.UpdateReservationCommand;
import com.example.RESTapi_Airline.services.reservationService.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ReservationController {
    private final CreateReservationService createReservationService;
    private final DeleteReservationService deleteReservationService;
    private final GetReservationService getReservationService;
    private final GetAllReservationsService getAllReservationsService;
    private final UpdateReservationService updateReservationService;


    public ReservationController(CreateReservationService createReservationService, DeleteReservationService deleteReservationService,
                                 GetReservationService getReservationService, GetAllReservationsService getAllReservationsService,
                                 UpdateReservationService updateReservationService)
    {
        this.createReservationService = createReservationService;
        this.deleteReservationService = deleteReservationService;
        this.getReservationService = getReservationService;
        this.getAllReservationsService = getAllReservationsService;
        this.updateReservationService = updateReservationService;
    }

    @GetMapping("/reservations")
    public ResponseEntity<List<ReservationDTO>> getReservations(){
        return getAllReservationsService.execute(null);
    }

    @GetMapping("/reservation/{id}")
    public ResponseEntity<ReservationDTO> getReservation(@PathVariable int id){
        return getReservationService.execute(id);
    }

    @DeleteMapping("/reservation/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable int id){
        return deleteReservationService.execute(id);
    }

    @PostMapping("/reservation")
    public ResponseEntity<ReservationDTO> createReservation(@RequestBody Reservation reservation){
        return createReservationService.execute(reservation);
    }

    @PutMapping("/reservation/{id}")
    public ResponseEntity<ReservationDTO> updateReservation(@PathVariable int id, @RequestBody Reservation reservation){
        return updateReservationService.execute(new UpdateReservationCommand(id, reservation));
    }
}
