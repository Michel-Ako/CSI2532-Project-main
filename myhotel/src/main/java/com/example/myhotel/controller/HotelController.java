package com.example.myhotel.controller;

import com.example.myhotel.model.Hotel;
import com.example.myhotel.service.implementation.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/")
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }
    @GetMapping("/availableRoomsByHotel")
    public ResponseEntity<List<Map<String, Object>>> getAvailableRoomsByHotel() {
        List<Map<String, Object>> result = hotelService.getAvailableRoomsByHotel();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/hotelRoomCapacity/{id}")
    public ResponseEntity<Map<String, Object>> getHotelRoomCapacity(@PathVariable Integer id) {
        Map<String, Object> result = hotelService.getHotelRoomCapacity(id);
        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public Hotel getHotelById(@PathVariable Integer id) {
        return hotelService.getHotelById(id);
    }

    @PostMapping("/")
    public Hotel saveOrUpdateHotel(@RequestBody Hotel hotel) {
        return hotelService.saveOrUpdateHotel(hotel);
    }

    @DeleteMapping("/{id}")
    public void deleteHotel(@PathVariable Integer id) {
        hotelService.deleteHotel(id);
    }
}
