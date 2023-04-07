package com.example.myhotel.controller;

import com.example.myhotel.model.Room;
import com.example.myhotel.service.implementation.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chambre")
public class RoomController {

    @Autowired
    private RoomService chambreService;

    @GetMapping("/")
    public List<Room> getAllChambres() {
        return chambreService.getAllChambres();
    }

    @GetMapping("/{id}")
    public Room getChambreById(@PathVariable Integer id) {
        return chambreService.getChambreById(id);
    }

    @PostMapping("/")
    public Room saveOrUpdateChambre(@RequestBody Room chambre) {
        return chambreService.saveOrUpdateChambre(chambre);
    }

    @DeleteMapping("/{id}")
    public void deleteChambre(@PathVariable Integer id) {
        chambreService.deleteChambre(id);
    }
}
