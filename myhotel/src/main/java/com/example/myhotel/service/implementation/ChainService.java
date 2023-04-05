package com.example.myhotel.service.implementation;

import com.example.myhotel.model.Archives;
import com.example.myhotel.model.Chain;
import com.example.myhotel.repository.ChainRepository;
import com.example.myhotel.service.IChainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ChainService implements IChainService {

    @Autowired
    private ChainRepository chainRepository;

    @Override
    public Chain findById(String name) {
        return chainRepository.findById(name).orElse(null);
    }

    @Override
    public Collection<String[]> findAllChains() {
        return chainRepository.findAllChains();
    }

    @Override
    public Chain save(Chain chain) {
        return chainRepository.save(chain);
    }

    @Override
    public void delete(Chain chain){
        chainRepository.delete(chain);
    }

//    @Override
//    public void changeNumberOfHotels(String chain, int numberHotels) {
//        chainRepository.changeNumberOfHotels(chain, numberHotels);
//    }

    @Override
    public List<Chain> findAll() {
        Iterable<Chain> chainIterable = chainRepository.findAll();
        return chainIterable != null ? (List<Chain>) chainIterable : new ArrayList<>();
    }
}

