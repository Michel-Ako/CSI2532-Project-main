package com.example.myhotel.service;

import com.example.myhotel.model.Reservation;

import java.util.List;

public interface IReservationService {
    List<Reservation> getAllReservations();
    Reservation getReservationById(Integer id);
    Reservation saveOrUpdateReservation(Reservation reservation);
    void deleteReservation(Integer id);
}