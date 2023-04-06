package com.example.myhotel.service;

import com.example.myhotel.model.Clients;
import com.example.myhotel.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientsService {

    @Autowired
    private ClientsRepository clientsRepository;

    public List<Clients> getAllClients() {
        return clientsRepository.findAll();
    }

    public Clients getClientById(Long id) {
        return clientsRepository.findById(id).orElse(null);
    }

    public Clients createClient(Clients client) {
        return clientsRepository.save(client);
    }

    public Clients updateClient(Long id, Clients clientDetails) {
        Clients client = getClientById(id);
        if (client != null) {
            client.setFirstName(clientDetails.getFirstName());
            client.setLastName(clientDetails.getLastName());
            client.setPhone(clientDetails.getPhone());
            client.setEmail(clientDetails.getEmail());
            return clientsRepository.save(client);
        }
        return null;
    }

    public void deleteClient(Long id) {
        clientsRepository.deleteById(id);
    }
}
