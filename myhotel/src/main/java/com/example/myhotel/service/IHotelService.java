package com.example.myhotel.service;

import com.example.myhotel.model.Hotel;

import java.util.List;
import java.util.Map;

public interface IHotelService {
    List<Hotel> getAllHotels();
    Hotel getHotelById(Integer id);
    Hotel saveOrUpdateHotel(Hotel hotel);
    void deleteHotel(Integer id);
    List<Map<String, Object>> getAvailableRoomsByHotel();
    Map<String, Object> getHotelRoomCapacity(Integer id);

}
