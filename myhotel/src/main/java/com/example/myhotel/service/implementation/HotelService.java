package com.example.myhotel.service.implementation;

import com.example.myhotel.model.Clients;
import com.example.myhotel.service.IHotelService;
import com.example.myhotel.model.Hotel;
import com.example.myhotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService implements IHotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public void save(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> findByRatings(int rating) {
        return hotelRepository.findByRatings(rating);
    }

    @Override
    public Hotel findById(Long id) {
        return hotelRepository.findById(id).orElse(null);
    }

    @Override
    public List<Hotel> findByName(String name) {
        return hotelRepository.findByName(name);
    }

    @Override
    public List<Hotel> findAll() {
        Iterable<Hotel> hotelIterable = hotelRepository.findAll();
        return hotelIterable != null ? (List<Hotel>) hotelIterable : new ArrayList<>();
    }

    @Override
    public void changeManager(Long id, String manager) {
        Hotel hotel = hotelRepository.findById(id).orElse(null);
        if (hotel != null) {
            hotel.setGestionnaireID(manager);
            hotelRepository.save(hotel);
        }
    }
    public void delete(Hotel val){
        hotelRepository.delete(val);
    }

    public List<Hotel> findByNameOrChainOrRating(String name, String chain, int rating){
        return hotelRepository.findByNameOrChainOrRating(name, chain, rating);
    }
}
