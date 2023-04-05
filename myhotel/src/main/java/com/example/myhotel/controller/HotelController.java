package com.example.myhotel.controller;
import com.example.myhotel.service.implementation.HotelService;

import com.example.myhotel.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/{id}")
    public Hotel getHotel(@PathVariable Long id) {
        return hotelService.findById(id);
    }


    @PutMapping("/hotels/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Hotel updatedHotel) {
        Hotel hotel = hotelService.findById(id);
        if (hotel == null) {
            return ResponseEntity.notFound().build();
        }

        // Update the hotel's name, if it was provided in the request body
        String name = updatedHotel.getName();
        if (name != null) {
            hotel.setName(name);
        }

        // Update the hotel's address, if it was provided in the request body
        String address = updatedHotel.getAddress();
        if (address != null) {
            hotel.setAddress(address);
        }

        // Update the hotel's rating, if it was provided in the request body
        Integer rating = updatedHotel.getRating();
        if (rating != null) {
            hotel.setRating(rating);
        }

        String Chain = updatedHotel.getName();
        if (Chain != null) {
            hotel.setName(Chain);
        }


        String GestionnaireID = updatedHotel.getGestionnaireID();
        if (GestionnaireID != null) {
            hotel.setGestionnaireID(GestionnaireID);
        }


        String email = updatedHotel.getEmail();
        if (email != null) {
            hotel.setEmail(email);
        }

        String phone = updatedHotel.getPhone();
        if (phone != null) {
            hotel.setPhone(phone);
        }

        // Save the updated hotel to the repository
        hotelService.save(hotel);

        return ResponseEntity.ok().body(hotel);
    }


    @PostMapping
    public void addHotel(@RequestBody Hotel hotel) {
        hotelService.save(hotel);
    }

    @DeleteMapping("/{id}")
    public void deleteHotel(@PathVariable Long id) {
        Hotel hotel = hotelService.findById(id);
        if (hotel != null) {
            hotelService.delete(hotel);
        }
    }

    @GetMapping("/hotels/search")
    public ResponseEntity<List<Hotel>> search(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "address", required = false) String address,
            @RequestParam(name = "rating", required = false) Integer rating,
            @RequestParam(name = "chain", required = false) String chain
    ) {
        List<Hotel> hotels = hotelService.findByNameOrChainOrRating(name, address, rating);
        if (hotels.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(hotels);
    }


}
