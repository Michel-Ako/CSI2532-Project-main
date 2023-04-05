package com.example.myhotel.controller;

import com.example.myhotel.model.Clients;
import com.example.myhotel.model.Clients;
import com.example.myhotel.service.IClientsService;
import com.example.myhotel.service.IClientsService;
import com.example.myhotel.service.IHotelService;
import com.example.myhotel.service.implementation.ClientsService;
import com.example.myhotel.service.implementation.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientsController {

    @Autowired
    private ClientsService clientService;

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Clients> addClient(@RequestBody Clients client) {
        clientService.save(client);
        return ResponseEntity.ok(client);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable Long id) {
        Clients client = clientService.findById(id);
        if (client == null) {
            return ResponseEntity.notFound().build();
        }
        clientService.delete(client);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clients> updateClient(@PathVariable Long id, @RequestBody Clients updatedClient) {
        Clients client = clientService.findById(id);
        if (client == null) {
            return ResponseEntity.notFound().build();
        }

        // Update the client's name, if it was provided in the request body
        String name = updatedClient.getName();
        if (name != null) {
            client.setName(name);
        }

        // Update the client's address, if it was provided in the request body
        String address = updatedClient.getAddress();
        if (address != null) {
            client.setAddress(address);
        }

        // Update the client's social security number, if it was provided in the request body
        Integer ssn = updatedClient.getSSN();
        if (ssn != null) {
            client.setSSN(ssn);
        }

        // Update the client's payment status, if it was provided in the request body
        String paymentStatus = updatedClient.getPayment();
        if (paymentStatus != null) {
            client.setPayment(paymentStatus);
        }

        // Update the client's hotel ID, if it was provided in the request body
        Long hotelId = updatedClient.getHotel().getHotelID();
        if (hotelId != null) {
            client.setHotel(hotelService.findById(hotelId));
        }

        // Save the updated client to the repository
        clientService.save(client);

        return ResponseEntity.ok().body(client);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clients> getClientById(@PathVariable Long id) {
        Clients client = clientService.findById(id);
        if (client == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(client);
    }

    @GetMapping("/ssn/{ssn}")
    public ResponseEntity<List<Clients>> getClientBySsn(@PathVariable int ssn) {
        List<Clients> clients = clientService.findBySSN(ssn);
        if (clients.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/hotel/{id}")
    public ResponseEntity<List<Clients>> getClientsByHotelId(@PathVariable Long id) {
        List<Clients> clients = clientService.findByHotelID(id);
        if (clients.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/payment-status/{status}")
    public ResponseEntity<List<Clients>> getClientsByPaymentStatus(@PathVariable String status) {
        List<Clients> clients = clientService.findByPaymentStatus(status);
        if (clients.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clients);
    }


}
