package com.example.myhotel.service;

import com.example.myhotel.model.Rent;
import java.time.LocalDate;
import java.util.List;

public interface IRentService {
    List<Rent> findAll();

    Rent findByNumber(int ID);

    List<Rent> findByDate(LocalDate Date);

    List<Rent> findByStartDate(LocalDate StartDate);

    List<Rent> findByEndDate(LocalDate EndDate);

    List<Rent> findByClientID(int clientID);

    void changeDate(int ID, LocalDate Date);

    void changeStartDate(int ID, LocalDate StartDate);

    void changeEndDate(int ID,LocalDate EndDate);

    Rent save(Rent rent);

    void delete(Rent rent);
}