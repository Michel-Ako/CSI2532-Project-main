package com.example.myhotel.service.implementation;

import com.example.myhotel.model.Clients;
import com.example.myhotel.repository.ClientsRepository;
import com.example.myhotel.service.IClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientsService implements IClientsService {

    @Autowired
    private ClientsRepository clientRepository;

    @Override
    public List<Clients> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Clients getClientById(Integer id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public Clients saveOrUpdateClient(Clients client) {
        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(Integer id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Optional<Clients> getClientByNomComplet(String nomComplet) {
        return clientRepository.findByNomComplet(nomComplet);
    }
}

