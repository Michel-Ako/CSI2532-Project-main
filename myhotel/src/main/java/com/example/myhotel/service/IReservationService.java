package com.example.myhotel.service;

import com.example.myhotel.model.Reservation;

import java.time.LocalDate;
import java.util.List;

public interface IReservationService {

    Reservation findByID(Long id);

    List<Reservation> findByDate(LocalDate Date);

    List<Reservation> findByStartDate(LocalDate StartDate);

    List<Reservation> findByEndDate(LocalDate EndDate);

    List<Reservation> findConflictingReservations(int roomNumber, LocalDate startDate, LocalDate endDate, int ID);

    void changeDate(Long ID, LocalDate Date);

    void changeStartDate(Long ID, LocalDate StartDate);

    void changeEndDate(Long ID, LocalDate EndDate);

    void save(Reservation reservation);

    void delete(Reservation reservation);

    List<Reservation> findByCustomerID(Long ID);

    List<Reservation> findByArchiveNumber(int number);

    List<Reservation> findAll();

}

