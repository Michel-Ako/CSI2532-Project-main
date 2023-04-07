package com.example.myhotel.controller;

import com.example.myhotel.model.Reservation;
import com.example.myhotel.service.implementation.ClientsService;
import com.example.myhotel.service.implementation.ReservationService;
import com.example.myhotel.service.implementation.RoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private ClientsService clientsService;

    @PostMapping("/makeReservation")
    public ResponseEntity<String> makeReservation(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam("customerID") Long customerID, @RequestParam("roomNumber") int roomNumber) {

        List<Reservation> reservations = new ArrayList<>();
        List<Reservation> startReservations = reservationService.findByStartDate(startDate);
        List<Reservation> endReservations = reservationService.findByEndDate(endDate);
        for (Reservation startReservation : startReservations) {
            if (endReservations.contains(startReservation)) {
                reservations.add(startReservation);
            }
        }
        if (reservations.isEmpty()) {
            Reservation reservation = new Reservation(startDate, endDate, roomNumber, clientsService.findById(customerID));
            reservationService.save(reservation);
            return ResponseEntity.ok("Reservation made successfully");
        } else {
            return ResponseEntity.ok("Reservation not available for selected dates");
        }
    }

    @PostMapping("/cancelReservation")
    public ResponseEntity<String> cancelReservation(
            @RequestParam("reservationID") Long reservationID ) {

        Reservation reservation = reservationService.findByID(reservationID);
        if (reservation != null) {
            reservationService.delete(reservation);
            return ResponseEntity.ok("Reservation canceled successfully");
        } else {
            return ResponseEntity.ok("Reservation not found");
        }
    }

    @PostMapping("/reserveRoom")
    public ResponseEntity<String> reserveRoom(
            @RequestParam("reservationID") Long reservationID, @RequestParam("roomNumber") int roomNumber) {

        Reservation reservation = reservationService.findByID(reservationID);
        if (reservation != null) {
            // set reservation status to "reserved"
            roomService.getRoomById(roomNumber).setStatus("Reserved");
            reservationService.save(reservation);
            return ResponseEntity.ok("Room reserved successfully");
        } else {
            return ResponseEntity.ok("Reservation not found");
        }
    }

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) {
        Reservation reservation = reservationService.findByID(id);
        if (reservation == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reservation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateReservation(@PathVariable Long id, @RequestBody Reservation updatedReservation) {
        Reservation reservation = reservationService.findByID(id);
        if (reservation == null) {
            return ResponseEntity.notFound().build();
        }

        // Check if the new room number is available for the reservation's dates
        List<Reservation> conflictingReservations = reservationService.findConflictingReservations(
                updatedReservation.getRoomNumber(),
                updatedReservation.getStartDate(),
                updatedReservation.getEndDate(),
                reservation.getReservationID()
        );
        if (!conflictingReservations.isEmpty()) {
            return ResponseEntity.badRequest().body("The selected room is not available for the selected dates.");
        }

        // Update the reservation's room number, if it was provided in the request body
        Integer roomNumber = updatedReservation.getRoomNumber();
        if (roomNumber != null) {
            reservation.setRoomNumber(roomNumber);
        }

        // Check if the new start and end dates are available for the reservation's room number
        conflictingReservations = reservationService.findConflictingReservations(
                reservation.getRoomNumber(),
                updatedReservation.getStartDate(),
                updatedReservation.getEndDate(),
                reservation.getReservationID()
        );
        if (!conflictingReservations.isEmpty()) {
            return ResponseEntity.badRequest().body("The selected dates are not available for the selected room.");
        }

        // Update the reservation's start date, if it was provided in the request body
        LocalDate startDate = updatedReservation.getStartDate();
        if (startDate != null) {
            reservation.setStartDate(startDate);
        }

        // Update the reservation's end date, if it was provided in the request body
        LocalDate endDate = updatedReservation.getEndDate();
        if (endDate != null) {
            reservation.setEndDate(endDate);
        }

        // Save the updated reservation to the repository
        reservationService.save(reservation);

        return ResponseEntity.ok().body(reservation);
    }
}
