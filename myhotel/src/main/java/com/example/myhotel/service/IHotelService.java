package com.example.myhotel.service;

import com.example.myhotel.model.Hotel;

import java.util.List;

public interface IHotelService {
    List<Hotel> getAllHotels();
    Hotel getHotelById(Integer id);
    Hotel saveOrUpdateHotel(Hotel hotel);
    void deleteHotel(Integer id);
}
