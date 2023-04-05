package com.example.myhotel.controller;

import com.example.myhotel.model.Chain;
import com.example.myhotel.model.Hotel;
import com.example.myhotel.service.IChainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chains")
public class ChainController {

    @Autowired
    private IChainService chainService;

    @GetMapping("/name/{name}")
    public ResponseEntity<Chain> findByName(@PathVariable String name) {
        Chain chain = chainService.findById(name);
        if (chain == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(chain);
    }

    @PostMapping
    public ResponseEntity<Chain> addChain(@RequestBody Chain chain) {
        chainService.save(chain);
        return new ResponseEntity<>(chain, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteChain(@PathVariable String name) {
        Chain chain = chainService.findById(name);
        if (chain == null) {
            return ResponseEntity.notFound().build();
        }
        chainService.delete(chain);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateChain(@PathVariable String name, @RequestBody Chain updatedChain) {
        Chain chain = chainService.findById(name);
        if (chain == null) {
            return ResponseEntity.notFound().build();
        }

        // Update the chain's address, if it was provided in the request body
        String address = updatedChain.getAddress();
        if (address != null) {
            chain.setAddress(address);
        }

        // Update the chain's email, if it was provided in the request body
        String email = updatedChain.getEmail();
        if (email != null) {
            chain.setEmail(email);
        }

        // Update the chain's phone number, if it was provided in the request body
        String phoneNumber = updatedChain.getNumber();
        if (phoneNumber != null) {
            chain.setNumber(phoneNumber);
        }

//        // Update the chain's hotels, if it was provided in the request body
//        Integer hotels = updatedChain.getNoHotels();
//        if (hotels != null) {
//            chain.setNoHotels(hotels);
//        }

        // Save the updated chain to the repository
        chainService.save(chain);

        return ResponseEntity.ok().body(chain);
    }
}
