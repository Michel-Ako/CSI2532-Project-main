package com.example.myhotel.service;

import com.example.myhotel.model.Room;
import com.example.myhotel.model.RoomType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IRoomService {
    List<Room> findAvailableRooms(int minCapacity, int maxCapacity,
                                  String roomType, boolean extent, String view,
                                  String hotelChain,
                                  BigDecimal minPrice, BigDecimal maxPrice,
                                  LocalDate startDate, LocalDate endDate);

    Room findByRoomNumber(int roomNumber);

    List<Room> findByView(String view);

    List<Room> findByExtent(boolean extent);





    List<Room> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);

    List<Room> findByCapacityBetween(int minCapacity, int maxCapacity);

    List<Room> findByRoomType(String roomType);

    List<Room> findByAvailability(boolean availability);

    void changeRoomStatus(int roomNumber, String status);

    void changeRoomAvailability(int roomNumber, boolean availability);

    Room save(Room room);

    List<Room> findAll();

    void delete(Room room);
}
