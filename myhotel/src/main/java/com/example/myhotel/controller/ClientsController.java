package com.example.myhotel.controller;

import com.example.myhotel.model.Clients;
import com.example.myhotel.service.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientsController {

    @Autowired
    private ClientsService clientsService;

    @GetMapping
    public ResponseEntity<List<Clients>> getAllClients() {
        return ResponseEntity.ok(clientsService.getAllClients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clients> getClientById(@PathVariable Long id) {
        return ResponseEntity.ok(clientsService.getClientById(id));
    }

    @PostMapping
    public ResponseEntity<Clients> createClient(@RequestBody Clients client) {
        return ResponseEntity.ok(clientsService.createClient(client));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clients> updateClient(@PathVariable Long id, @RequestBody Clients client) {
        return ResponseEntity.ok(clientsService.updateClient(id, client));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientsService.deleteClient(id);
        return ResponseEntity.ok().build();
    }
}
