package com.example.myhotel.service;

import com.example.myhotel.model.Reservation;

import java.time.LocalDate;
import java.util.List;

public interface IReservationService {
    Reservation save(Reservation reservation);
    void delete(Reservation reservation);
    Reservation findByID(Long id);
    List<Reservation> findAll();
    List<Reservation> findByStartDate(LocalDate startDate);
    List<Reservation> findByEndDate(LocalDate endDate);
    List<Reservation> findConflictingReservations(int roomNumber, LocalDate startDate, LocalDate endDate, Long reservationID);
}
