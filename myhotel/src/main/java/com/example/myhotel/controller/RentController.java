package com.example.myhotel.controller;

import com.example.myhotel.model.Clients;
import com.example.myhotel.model.Rent;
import com.example.myhotel.service.implementation.ClientsService;
import com.example.myhotel.service.implementation.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rents")
public class RentController {

    @Autowired
    private RentService rentService;

    @Autowired
    private ClientsService clientsService;

    @PostMapping
    public ResponseEntity<Rent> addRent(@RequestBody Rent rent) {
        Rent addedRent = rentService.save(rent);
        return ResponseEntity.ok(addedRent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRent(@PathVariable Long id) {
        if( rentService.findByNumber(id) != null){
            rentService.delete( rentService.findByNumber(id) );
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rent> updateRent(@PathVariable Long id, @RequestBody Rent updatedRent) {
        Rent rent = rentService.findByNumber(id);
        if (rent == null) {
            return ResponseEntity.notFound().build();
        }

        // Update the rent's start date, if it was provided in the request body
        LocalDate startDate = updatedRent.getStartrent();
        if (startDate != null) {
            rent.setStartrent(startDate);
        }

        // Update the rent's end date, if it was provided in the request body
        LocalDate endDate = updatedRent.getEnddate();
        if (endDate != null) {
            rent.setEnddate(endDate);
        }

        // Update the rent's room number, if it was provided in the request body
        Integer roomNumber = updatedRent.getNoRoom();
        if (roomNumber != null) {
            rent.setNoRoom(roomNumber);
        }

        // Update the rent's client ID, if it was provided in the request body
        Long clientId = updatedRent.getCustomer().getID();
        if (clientId != null) {
            rent.setCustomer(clientsService.findById(clientId));
        }

        Rent updatedRentObj = rentService.save(rent);
        return ResponseEntity.ok(updatedRentObj);
    }

    @GetMapping("/date")
    public ResponseEntity<List<Rent>> getRentsByDate(@RequestParam(name = "date") LocalDate date) {
        List<Rent> rents = rentService.findByDate(date);
        if (rents.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rents);
    }

    @GetMapping("/startdate")
    public ResponseEntity<List<Rent>> getRentsByStartDate(@RequestParam(name = "startdate") LocalDate startDate) {
        List<Rent> rents = rentService.findByStartDate(startDate);
        if (rents.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rents);
    }

    @GetMapping("/enddate")
    public ResponseEntity<List<Rent>> getRentsByEndDate(@RequestParam(name = "enddate") LocalDate endDate) {
        List<Rent> rents = rentService.findByEndDate(endDate);
        if (rents.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rents);
    }

    @GetMapping("/roomnumber")
    public ResponseEntity<Rent> getRentsByRoomNumber(@RequestParam(name = "roomNumber") Integer roomNumber) {
        Rent rents = rentService.findByRoomNumber(roomNumber);
        if (rents == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rents);
    }

    @GetMapping("/clientid")
    public ResponseEntity<List<Rent>> getRentsByClientId(@RequestParam(name = "clientID") long clientId) {
        List<Rent> rents = rentService.findByClientID(clientId);
        if (rents.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rents);
    }


    @GetMapping("/rents/{id}")
    public ResponseEntity<Rent> getRentById(@PathVariable Long id) {
        Rent rent = rentService.findByNumber(id);
        if (rent == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rent);
    }




}