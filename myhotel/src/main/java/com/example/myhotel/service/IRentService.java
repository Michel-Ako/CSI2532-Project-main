package com.example.myhotel.service;

import com.example.myhotel.model.Rent;
import java.time.LocalDate;
import java.util.List;

public interface IRentService {
    List<Rent> findAll();

    Rent findByNumber(Long ID);

    List<Rent> findByDate(LocalDate Date);

    List<Rent> findByStartDate(LocalDate StartDate);

    List<Rent> findByEndDate(LocalDate EndDate);

    List<Rent> findByClientID(long clientID);

    void changeDate(Long ID, LocalDate Date);

    void changeStartDate(Long ID, LocalDate StartDate);

    void changeEndDate(Long ID,LocalDate EndDate);

    Rent save(Rent rent);

    void delete(Rent rent);
}