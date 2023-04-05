package com.example.myhotel.service.implementation;
import com.example.myhotel.model.Rent;
import com.example.myhotel.service.IReservationService;

import com.example.myhotel.model.Reservation;
import com.example.myhotel.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
public class ReservationService implements IReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Reservation findByID(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Reservation> findByDate(LocalDate Date) {
        return reservationRepository.findByDate(Date);
    }

    @Override
    public List<Reservation> findByStartDate(LocalDate StartDate) {
        return reservationRepository.findByStartDate(StartDate);
    }

    @Override
    public List<Reservation> findByEndDate(LocalDate EndDate) {
        return reservationRepository.findByEndDate(EndDate);
    }

    @Override
    public void changeDate(Long ID, LocalDate Date) {
        Reservation reservation = reservationRepository.findById(ID).orElse(null);
        reservation.setReservationDate(Date);
        reservationRepository.save(reservation);
    }

    @Override
    public void changeStartDate(Long ID, LocalDate StartDate) {
        Reservation reservation = reservationRepository.findById(ID).orElse(null);
        reservation.setStartDate(StartDate);
        reservationRepository.save(reservation);
    }

    @Override
    public void changeEndDate(Long ID, LocalDate EndDate) {
        Reservation reservation = reservationRepository.findById(ID).orElse(null);
        reservation.setEndDate(EndDate);
        reservationRepository.save(reservation);
    }

    @Override
    public void save(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    @Override
    public void delete(Reservation reservation) {
        reservationRepository.delete(reservation);
    }

    @Override
    public List<Reservation> findByCustomerID(Long ID) {
        return reservationRepository.findByCustomerID(ID);
    }

    @Override
    public List<Reservation> findByArchiveNumber(int number) {
        return reservationRepository.findByArchiveNumber(number);
    }

    public List<Reservation> findAll() {
        Iterable<Reservation> reservationIterable = reservationRepository.findAll();
        return reservationIterable != null ? (List<Reservation>) reservationIterable : new ArrayList<>();
    }

    public List<Reservation> findConflictingReservations(int roomNumber, LocalDate startDate, LocalDate endDate, int ID){
        return reservationRepository.findConflictingReservations(roomNumber, startDate, endDate, ID);
    }


}


