package com.example.myhotel.controller;

import com.example.myhotel.model.Rent;
import com.example.myhotel.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        Optional<Rent> rent = rentService.getRentById(id);
        if (rent.isPresent()) {
            return new ResponseEntity<>(rent.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public Rent createRent(@RequestBody Rent rent) {
        return rentService.createRent(rent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rent> updateRent(@PathVariable Long id, @RequestBody Rent rentDetails) {
        Rent updatedRent = rentService.updateRent(id, rentDetails);
        if (updatedRent != null) {
            return new ResponseEntity<>(updatedRent, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRent(@PathVariable Long id) {
        rentService.deleteRent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
