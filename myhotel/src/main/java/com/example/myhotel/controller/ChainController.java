package com.example.myhotel.controller;

import com.example.myhotel.model.Chain;
import com.example.myhotel.model.Chain;
import com.example.myhotel.service.implementation.ChainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chaine_hoteliere")
public class ChainController {

    @Autowired
    private ChainService chaineHoteliereService;

    @GetMapping
    public ResponseEntity<List<Chain>> getAllChaines() {
        return ResponseEntity.ok(chaineHoteliereService.getAllChaines());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chain> getChaineById(@PathVariable int id) {
        return chaineHoteliereService.getChaineById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Chain> createChaine(@RequestBody ChaineHoteliere chaineHoteliere) {
        return ResponseEntity.status(HttpStatus.CREATED).body(chaineHoteliereService.createChaine(chaineHoteliere));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Chain> updateChaine(@PathVariable int id, @RequestBody ChaineHoteliere chaineHoteliere) {
        return chaineHoteliereService.updateChain(id, chaineHoteliere)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChaine(@PathVariable int id) {
        if (chaineHoteliereService.deleteChain(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
