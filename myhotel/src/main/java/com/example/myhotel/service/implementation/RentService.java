package com.example.myhotel.service.implementation;
import com.example.myhotel.service.IRentService;

import com.example.myhotel.model.Hotel;
import com.example.myhotel.model.Rent;
import com.example.myhotel.repository.RentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
public class RentService implements IRentService {

    private final RentRepository rentRepository;

    public RentService(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }



    public List<Rent> findAll() {
        Iterable<Rent> rentIterable = rentRepository.findAll();
        return rentIterable != null ? (List<Rent>) rentIterable : new ArrayList<>();
    }


    public Rent findByNumber(Long ID) {
        return rentRepository.findByNumber(ID).orElse(null);
    }

    public Rent findByRoomNumber(int roomNumber) {
        return rentRepository.findByRoomNumber(roomNumber);
    }


    public List<Rent> findByDate(LocalDate Date) {
        return rentRepository.findByDate(Date);
    }


    public List<Rent> findByStartDate(LocalDate StartDate) {
        return rentRepository.findByStartDate(StartDate);
    }

    public List<Rent> findByClientID(long clientID){
        return rentRepository.findByClientID(clientID);
    }


    public List<Rent> findByEndDate(LocalDate EndDate) {
        return rentRepository.findByEndDate(EndDate);
    }


    public void changeDate(Long ID, LocalDate Date) {
        Rent rent = rentRepository.findByNumber(ID).orElse(null);
        rent.setRentdate(Date);
        rentRepository.save(rent);
    }


    public void changeStartDate(Long ID, LocalDate StartDate) {
        Rent rent = rentRepository.findByNumber(ID).orElse(null);
        rent.setStartrent(StartDate);
        rentRepository.save(rent);
    }


    public void changeEndDate(Long ID, LocalDate EndDate) {
        Rent rent = rentRepository.findByNumber(ID).orElse(null);
        rent.setEnddate(EndDate);
        rentRepository.save(rent);
    }


    public Rent save(Rent rent) {
        return rentRepository.save(rent);
    }


    public void delete(Rent rent) {
        rentRepository.delete(rent);
    }
}

