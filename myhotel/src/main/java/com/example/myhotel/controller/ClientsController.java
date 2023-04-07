package com.example.myhotel.controller;

import com.example.myhotel.model.Clients;
import com.example.myhotel.service.implementation.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientsController {

    @Autowired
    private ClientsService clientService;

    @GetMapping("/")
    public List<Clients> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public Clients getClientById(@PathVariable Integer id) {
        return clientService.getClientById(id);
    }

    @PostMapping("/")
    public Clients saveOrUpdateClient(@RequestBody Clients client) {
        return clientService.saveOrUpdateClient(client);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Integer id) {
        clientService.deleteClient(id);
    }
}
