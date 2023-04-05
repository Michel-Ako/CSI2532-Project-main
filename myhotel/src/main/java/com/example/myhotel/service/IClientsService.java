package com.example.myhotel.service;
import com.example.myhotel.model.Clients;

import com.example.myhotel.model.Clients;

import java.time.LocalDate;
import java.util.List;

public interface IClientsService {

    Clients findById(Long ID);

    List<Clients> findByName(String name);

    List<Clients> findBySSN(int SSN);
    List<Clients> findByHotelID(long id);

    void changeCheckInDate(Long ID, LocalDate checkin);

    void changePaymentStatus(Long ID, String paymentStatus);

    Clients save(Clients client);

    void delete(Clients client);

    List<Clients> findAll();

    List<Clients> findByPaymentStatus(String status);
}
