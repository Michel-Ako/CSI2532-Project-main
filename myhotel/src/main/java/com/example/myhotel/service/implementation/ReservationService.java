package com.example.myhotel.service.implementation;

import com.example.myhotel.model.Reservation;
import com.example.myhotel.repository.ReservationRepository;
import com.example.myhotel.service.IReservationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationService implements IReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void delete(Reservation reservation) {
        reservationRepository.delete(reservation);
    }

    @Override
    public Reservation findByID(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Reservation> findAll() {
        return (List<Reservation>) reservationRepository.findAll();
    }

    @Override
    public List<Reservation> findByStartDate(LocalDate startDate) {
        return reservationRepository.findByStartDate(startDate);
    }

    @Override
    public List<Reservation> findByEndDate(LocalDate endDate) {
        return reservationRepository.findByEndDate(endDate);
    }

    @Override
    public List<Reservation> findConflictingReservations(int roomNumber, LocalDate startDate, LocalDate endDate, Long reservationID) {
        return reservationRepository.findConflictingReservations(roomNumber, startDate, endDate, Math.toIntExact(reservationID));
    }
}
