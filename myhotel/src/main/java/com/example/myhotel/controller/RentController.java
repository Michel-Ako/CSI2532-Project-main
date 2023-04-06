package com.example.myhotel.controller;

import com.example.myhotel.model.Rent;
import com.example.myhotel.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rents")
public class RentController {

    @Autowired
    private RentService rentService;

    @GetMapping
    public List<Rent> getAllRents() {
        return rentService.getAllRents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rent> getRentById(@PathVariable Long id) {
        return rentService.getRentById(id);
    }

    @PostMapping
    public Rent createRent(@RequestBody Rent rent) {
        return rentService.createRent(rent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rent> updateRent(@PathVariable Long id, @RequestBody Rent rentDetails) {
        return rentService.updateRent(id, rentDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRent(@PathVariable Long id) {
        return rentService.deleteRent(id);
    }
}
