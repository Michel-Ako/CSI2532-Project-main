package com.example.myhotel.controller;

import com.example.myhotel.model.Chain;
import com.example.myhotel.service.implementation.ChainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chain")
public class ChainController {

    @Autowired
    private ChainService chaineHoteliereService;

    @GetMapping("/")
    public List<Chain> getAllChaineHotelieres() {
        return chaineHoteliereService.getAllChaineHotelieres();
    }

    @GetMapping("/{id}")
    public Chain getChaineHoteliereById(@PathVariable String id) {
        return chaineHoteliereService.getChaineHoteliereById(id);
    }

    @PostMapping("/")
    public Chain saveOrUpdateChaineHoteliere(@RequestBody Chain chaineHoteliere) {
        return chaineHoteliereService.saveOrUpdateChaineHoteliere(chaineHoteliere);
    }

    @DeleteMapping("/{id}")
    public void deleteChaineHoteliere(@PathVariable Integer id) {
        chaineHoteliereService.deleteChaineHoteliere(id);
    }
}
