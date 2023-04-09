package com.example.myhotel.service.implementation;

import com.example.myhotel.model.Chain;
import com.example.myhotel.repository.ChainRepository;
import com.example.myhotel.service.IChainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChainService implements IChainService {

    @Autowired
    private ChainRepository chaineHoteliereRepository;

    @Override
    public List<Chain> getAllChaineHotelieres() {
        return (List<Chain>) chaineHoteliereRepository.findAll();
    }

    @Override
    public Chain getChaineHoteliereById(String nomChaine) {
        return chaineHoteliereRepository.findById(nomChaine).orElse(null);
    }

    @Override
    public Chain saveOrUpdateChaineHoteliere(Chain chaineHoteliere) {
        return chaineHoteliereRepository.save(chaineHoteliere);
    }

    @Override
    public void deleteChaineHoteliere(Integer id) {
        chaineHoteliereRepository.deleteById(String.valueOf(id));
    }
}
