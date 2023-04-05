package com.example.myhotel.service.implementation;

import com.example.myhotel.model.Reservation;
import com.example.myhotel.model.Room;
import com.example.myhotel.model.RoomType;
import com.example.myhotel.repository.RoomRepository;
import com.example.myhotel.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService implements IRoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }


    public List<Room> findAvailableRooms(int minCapacity, int maxCapacity, String roomType, boolean extent,
                                         String view, String hotelChain, BigDecimal minPrice,
                                         BigDecimal maxPrice, LocalDate startDate, LocalDate endDate) {
        return roomRepository.findAvailableRooms(minCapacity, maxCapacity, roomType, extent, view, hotelChain, minPrice, maxPrice, startDate, endDate);
    }


    @Override
    public Room findByRoomNumber(int roomNumber) {
        return roomRepository.findByRoomNumber(roomNumber);
    }

    @Override
    public List<Room> findByView(String view) {
        return roomRepository.findByView(view);
    }

    @Override
    public List<Room> findByExtent(boolean extent) {
        return roomRepository.findByExtent(extent);
    }





    @Override
    public List<Room> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice) {
        return roomRepository.findByPriceBetween(minPrice, maxPrice);
    }

    @Override
    public List<Room> findByCapacityBetween(int minCapacity, int maxCapacity) {
        return roomRepository.findByCapacityBetween(minCapacity, maxCapacity);
    }




    public List<Room> findByRoomType(String roomType) {
        return roomRepository.findByRoomType(roomType);
    }

    @Override
    public List<Room> findByAvailability(boolean availability) {
        return roomRepository.findByAvailability(availability);
    }

    @Override
    public void changeRoomStatus(int roomNumber, String status) {
        Room room = roomRepository.findByRoomNumber(roomNumber);
        room.setStatus(status);
        roomRepository.save(room);
    }

    @Override
    public void changeRoomAvailability(int roomNumber, boolean availability) {
        Room room = roomRepository.findByRoomNumber(roomNumber);
        room.setAvailability(availability);
        roomRepository.save(room);
    }

    @Override
    public Room save(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public List<Room> findAll() {
        Iterable<Room> roomIterable = roomRepository.findAll();
        return roomIterable != null ? (List<Room>) roomIterable : new ArrayList<>();
    }


    @Override
    public void delete(Room room) {
        roomRepository.delete(room);
    }


}
