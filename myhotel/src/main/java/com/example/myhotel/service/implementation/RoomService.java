package com.example.myhotel.service;

import com.example.myhotel.model.Room;
import com.example.myhotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getRoomById(int id) {
        return roomRepository.findById(id).orElse(null);
    }

    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room updateRoom(int id, Room roomDetails) {
        Room room = getRoomById(id);
        if (room != null) {
            room.setRoomType(roomDetails.getRoomType());
            room.setPrice(roomDetails.getPrice());
            room.setCapacity(roomDetails.getCapacity());
            room.setView(roomDetails.getView());
            room.setExtent(roomDetails.getExtent());
            room.setDamage(roomDetails.getDamage());
            room.setAmenities(roomDetails.getAmenities());
            room.setAvailability(roomDetails.isAvailability());
            room.setStatus(roomDetails.getStatus());
            room.setHotelID(roomDetails.getHotelID());
            room.setClientID(roomDetails.getClientID());
            room.setEmployeeID(roomDetails.getEmployeeID());
            return roomRepository.save(room);
        }
        return null;
    }

    public void deleteRoom(int id) {
        roomRepository.deleteById(id);
    }
}

