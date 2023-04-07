package com.example.myhotel.service.implementation;

import com.example.myhotel.model.Room;
import com.example.myhotel.repository.RoomRepository;
import com.example.myhotel.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService implements IRoomService {

    @Autowired
    private RoomRepository chambreRepository;

    @Override
    public List<Room> getAllChambres() {
        return chambreRepository.findAll();
    }

    @Override
    public Room getChambreById(Integer id) {
        return chambreRepository.findById(id).orElse(null);
    }

    @Override
    public Room saveOrUpdateChambre(Room chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public void deleteChambre(Integer id) {
        chambreRepository.deleteById(id);
    }
}