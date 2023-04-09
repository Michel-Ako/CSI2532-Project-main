package com.example.myhotel.service;

import com.example.myhotel.model.Chain;

import java.util.List;

public interface IChainService {
    List<Chain> getAllChaineHotelieres();
    Chain getChaineHoteliereById(String id);
    Chain saveOrUpdateChaineHoteliere(Chain chaineHoteliere);
    void deleteChaineHoteliere(Integer id);
}
