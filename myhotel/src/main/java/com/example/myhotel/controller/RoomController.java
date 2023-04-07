package com.example.myhotel.controller;

import com.example.myhotel.model.Room;
import com.example.myhotel.service.implementation.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Rooms")
public class RoomController {

    @Autowired
    private RoomService chambreService;

    @GetMapping
    public ResponseEntity<List<Room>> getAllChambres() {
        return ResponseEntity.ok(chambreService.getAllChambres());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getChambreById(@PathVariable int id) {
        return chambreService.getChambreById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Room> createChambre(@RequestBody Room chambre) {
        return ResponseEntity.status(HttpStatus.CREATED).body(chambreService.createChambre(chambre));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Room> updateChambre(@RequestBody Room chambre) {
        return chambreService.saveOrUpdateChambre(chambre)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChambre(@PathVariable int id) {
        if (chambreService.deleteChambre(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
