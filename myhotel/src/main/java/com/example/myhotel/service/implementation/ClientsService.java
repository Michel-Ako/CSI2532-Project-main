package com.example.myhotel.service.implementation;
import com.example.myhotel.model.Chain;
import com.example.myhotel.repository.ClientsRepository;

import com.example.myhotel.model.Clients;
import com.example.myhotel.service.IClientsService;
import com.example.myhotel.service.IClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientsService implements IClientsService {

    @Autowired
    private ClientsRepository clientsRepository;

    @Override
    public Clients findById(Long ID) {
        return clientsRepository.findById(ID).orElse(null);
    }

    public List<Clients> findByHotelID(Long ID) {
        return clientsRepository.findByHotelID(ID);
    }

    @Override
    public List<Clients> findByName(String name) {
        return clientsRepository.findByName(name);
    }

    @Override
    public List<Clients> findBySSN(int SSN) {
        return clientsRepository.findBySSN(SSN);
    }

    @Override
    public List<Clients> findByHotelID(long id) {
        return clientsRepository.findByHotelID(id);
    }

    @Override
    public void changeCheckInDate(Long ID, LocalDate checkin) {
        Clients client = findById(ID);
        client.setCheckin(checkin);
        clientsRepository.save(client);
    }

    @Override
    public void changePaymentStatus(Long ID, String paymentStatus) {
        Clients client = findById(ID);
        client.setPayment(paymentStatus);
        clientsRepository.save(client);
    }
    public List<Clients> findByPaymentStatus(String status){
        return clientsRepository.findByPaymentStatus(status);
    }

    @Override
    public Clients save(Clients client) {
        return clientsRepository.save(client);
    }

    @Override
    public void delete(Clients client) {
        clientsRepository.delete(client);
    }

    @Override
    public List<Clients> findAll() {
        Iterable<Clients> clientIterable = clientsRepository.findAll();
        return clientIterable != null ? (List<Clients>) clientIterable : new ArrayList<>();
    }
}
