package com.example.myhotel.service;

import com.example.myhotel.model.Hotel;

import java.util.List;

public interface IHotelService {

    void save(Hotel hotel);

    List<Hotel> findByRatings(int rating);

    Hotel findById(Long id);

    List<Hotel> findByName(String name);

    List<Hotel> findAll();

    void changeManager(Long id, String manager);

    List<Hotel> findByNameOrChainOrRating (String name, String chain, int rating);



}

