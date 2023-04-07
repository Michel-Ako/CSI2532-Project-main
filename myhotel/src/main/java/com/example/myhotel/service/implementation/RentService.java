package com.example.myhotel.service;

import com.example.myhotel.model.Rent;
import com.example.myhotel.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentService {

    @Autowired
    private RentRepository rentRepository;

    public List<Rent> getAllRents() {
        return rentRepository.findAll();
    }

    public Optional<Rent> getRentById(int id) {
        return rentRepository.findById(id);
    }

    public Rent createRent(Rent rent) {
        return rentRepository.save(rent);
    }

    public Rent updateRent(int id, Rent rentDetails) {
        Optional<Rent> optionalRent = rentRepository.findById(id);
        if (optionalRent.isPresent()) {
            Rent rent = optionalRent.get();
            rent.setRentdate(rentDetails.getRentdate());
            rent.setStartrent(rentDetails.getStartrent());
            rent.setEnddate(rentDetails.getEnddate());
            rent.setNoRoom(rentDetails.getNoRoom());
            rent.setClient(rentDetails.getClient());
            rent.setNoArchives(rentDetails.getNoArchives());
            return rentRepository.save(rent);
        }
        return null;
    }

    public void deleteRent(int id) {
        rentRepository.deleteById(id);
    }

}
