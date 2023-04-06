package com.example.myhotel.controller;

import com.example.myhotel.model.Rent;
import com.example.myhotel.model.Reservation;
import com.example.myhotel.model.Room;
import com.example.myhotel.service.IRentService;
import com.example.myhotel.service.IReservationService;
import com.example.myhotel.service.IRoomService;
import com.example.myhotel.service.implementation.EmployeeService;
import com.example.myhotel.service.implementation.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private IRoomService roomService;

    @Autowired
    private IReservationService reservationService;

    @Autowired
    private IRentService rentService;

    // Find available rooms for a given date range and room type

    // Get all rooms

    @GetMapping("/available")
    public ResponseEntity<List<Room>> findAvailableRooms(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate,
                                                         @RequestParam String roomType) {
        int minCapacity = 0;
        int maxCapacity = Integer.MAX_VALUE;
        boolean extent = false;
        String view = null;
        String hotelChain = null;
        int hotelCategory = 0;
        BigDecimal minPrice = BigDecimal.ZERO;
        BigDecimal maxPrice = BigDecimal.valueOf(Double.MAX_VALUE);

        List<Room> availableRooms = roomService.findAvailableRooms(minCapacity, maxCapacity, roomType, extent, view, hotelChain, minPrice, maxPrice, startDate, endDate);
        return ResponseEntity.ok().body(availableRooms);
    }

    // Update a room's information
    @PutMapping("/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable int roomNumber, @RequestBody Room updatedRoom) {
        Room room = roomService.findByRoomNumber(roomNumber);
        if (room == null) {
            return ResponseEntity.notFound().build();
        }

        // Update the room's type, if it was provided in the request body
        String roomType = updatedRoom.getRoomType();
        if (roomType != null) {
            room.setRoomType(roomType);
        }

        // Update the room's price, if it was provided in the request body
        Double price = updatedRoom.getPrice();
        if (price != null) {
            room.setPrice(price);
        }

        // Update the room's capacity, if it was provided in the request body
        String capacity = updatedRoom.getCapacity();
        if (capacity != null) {
            room.setCapacity(capacity);
        }

        // Update the room's view, if it was provided in the request body
        String view = updatedRoom.getView();
        if (view != null) {
            room.setView(view);
        }

        // Update the room's extent, if it was provided in the request body
        Boolean extent = updatedRoom.isExtent();
        if (extent != null) {
            room.setExtent(extent);
        }

        // Update the room's damage status, if it was provided in the request body
        String damage = updatedRoom.getDamage();
        if (damage != null) {
            room.setDamage(damage);
        }

        // Update the room's amenities, if they were provided in the request body
        String amenities = updatedRoom.getAmenities();
        if (amenities != null) {
            room.setAmenities(amenities);
        }

        // Save the updated room to the repository
        roomService.save(room);

        return ResponseEntity.ok().body(room);
    }

    @PostMapping
    public ResponseEntity<?> addRoom(@RequestBody Room room) {
        roomService.save(room);
        return ResponseEntity.ok().build();
    }

    // Book a room for a given date range
    @PostMapping("/{roomId}/book")
    public ResponseEntity<?> bookRoom(@PathVariable int roomNumber,
                                      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
                                      @RequestParam int guests) {
        Room room = roomService.findByRoomNumber(roomNumber);
        if (room == null) {
            return ResponseEntity.notFound().build();
        }
        Reservation booking = new Reservation(startDate, endDate,room.getRoomNumber(), null, room.getClientID());
        reservationService.save(booking);
        roomService.changeRoomStatus(roomNumber, "reserved");
        return ResponseEntity.ok().build();
    }


        @PostMapping("/{roomId}/rent")
        public ResponseEntity<?> rentRoom(@PathVariable int roomNumber,
                                          @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                          @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
                                          @RequestParam int guests) {
            Room room = roomService.findByRoomNumber(roomNumber);
            if (room == null) {
                return ResponseEntity.notFound().build();
            }
            Rent rental = new Rent(LocalDate.now(),startDate, endDate,room.getRoomNumber(),room.getClientID(), null);
            rentService.save(rental);
            roomService.changeRoomStatus(roomNumber, "rented");
            return ResponseEntity.ok().build();
        }



        @PostMapping("/{roomId}/payment")
        public ResponseEntity<?> updatePaymentStatus(@PathVariable int roomId, @RequestParam String paid) {
            Room room = roomService.findByRoomNumber(roomId);
            if (room == null) {
                return ResponseEntity.notFound().build();
            }

            room.setStatus("paid");
            roomService.save(room);
            return ResponseEntity.ok().build();
        }
    }
