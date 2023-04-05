package com.example.myhotel.service;

import com.example.myhotel.model.Chain;

import java.util.Collection;
import java.util.List;

public interface IChainService {
    Chain findById(String name);

    Collection<String[]> findAllChains();

    Chain save(Chain chain);

    void delete(Chain chain);

    //void changeNumberOfHotels(String chain, int numberHotels);

    List<Chain> findAll();
}

