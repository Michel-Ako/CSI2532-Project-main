package com.example.myhotel.controller;

import com.example.myhotel.model.Clients;
import com.example.myhotel.service.IClientsService;
import com.example.myhotel.service.implementation.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/client")
public class ClientsController {

    @Autowired
    private IClientsService clientService;;

    @GetMapping("/byNomComplet/{nomComplet}")
    public ResponseEntity<Clients> getClientBynomComplet(@PathVariable String nomComplet) {
        Optional<Clients> client = clientService.getClientBynomComplet(nomComplet);
        return client.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

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

    @PostMapping("/add")
    public void addClient(@RequestBody Clients client) {
        clientService.addClient(client);
    }


    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Integer id) {
        clientService.deleteClient(id);
    }
}
