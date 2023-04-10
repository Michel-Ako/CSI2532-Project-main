package com.example.myhotel.service;

import com.example.myhotel.model.Clients;

import java.util.List;
import java.util.Optional;

public interface IClientsService {
    List<Clients> getAllClients();
    Clients getClientById(Integer id);
    Clients saveOrUpdateClient(Clients client);
    void deleteClient(Integer id);
    Optional<Clients> getClientBynom_complet(String nom_complet);
}

