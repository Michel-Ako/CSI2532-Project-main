package com.example.myhotel.service;

import com.example.myhotel.model.Room;

import java.util.List;

public interface IRoomService {
    List<Room> getAllChambres();
    Room getChambreById(Integer id);
    Room saveOrUpdateChambre(Room chambre);
    void deleteChambre(Integer id);
}
