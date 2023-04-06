package com.example.myhotel.service;

import com.example.myhotel.exception.ResourceNotFoundException;
import com.example.myhotel.model.Rent;
import com.example.myhotel.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentService {
    @Autowired
    private RentRepository rentRepository;

    public List<Rent> getAllRents() {
        return rentRepository.findAll();
    }

    public Rent getRentById(Long id) {
        return rentRepository.findById(id).orElse(null);
    }

    public Rent createRent(Rent rent) {
        return rentRepository.save(rent);
    }

    public Rent updateRent(Long id, Rent rentDetails) {
        Rent rent = rentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Rent not found with id: " + id));
        rent.setRentdate(rentDetails.getRentdate());
        rent.setStartrent(rentDetails.getStartrent());
        rent.setEnddate(rentDetails.getEnddate());
        rent.setNoRoom(rentDetails.getNoRoom());
        rent.setClient(rentDetails.getClient());
        rent.setNoArchives(rentDetails.getNoArchives());
        return rentRepository.save(rent);
    }

    public void deleteRent(Long id) {
        rentRepository.deleteById(id);
    }
}
