package com.example.myhotel.service.implementation;

import com.example.myhotel.model.Clients;
import com.example.myhotel.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientsService {

    @Autowired
    private ClientsRepository clientsRepository;

    public Clients findById(Long id) {
        return clientsRepository.findById(Math.toIntExact(id)).orElse(null);
    }

    public List<Clients> getAllClients() {
        return clientsRepository.findAll();
    }

    public Optional<Clients> getClientById(Integer id) {
        return clientsRepository.findById(id);
    }

    public Clients createClient(Clients client) {
        return clientsRepository.save(client);
    }

    public Clients updateClient(Long id, Clients clientDetails) {
        Clients client = getClientById(Math.toIntExact(id)).orElse(null);
        if (client != null) {
            client.setFirstName(clientDetails.getFirstName());
            client.setLastName(clientDetails.getLastName());
            client.setPhoneNumber(clientDetails.getPhoneNumber());
            client.setEmail(clientDetails.getEmail());
            return clientsRepository.save(client);
        }
        return null;
    }

    public void deleteClient(Long id) {
        clientsRepository.deleteById(Math.toIntExact(id));
    }
}
