package com.example.myhotel.controller;

import com.example.myhotel.model.Hotel;
import com.example.myhotel.service.implementation.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/")
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
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
