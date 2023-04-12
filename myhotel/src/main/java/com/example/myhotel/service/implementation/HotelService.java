package com.example.myhotel.service.implementation;

import com.example.myhotel.model.Hotel;
import com.example.myhotel.repository.HotelRepository;
import com.example.myhotel.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


@Service
public class HotelService implements IHotelService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelById(Integer id) {
        return hotelRepository.findById(id).orElse(null);
    }

    @Override
    public Hotel saveOrUpdateHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public void deleteHotel(Integer id) {
        hotelRepository.deleteById(id);
    }

    @Override
    public List<Map<String, Object>> getAvailableRoomsByHotel() {
        String sql = "SELECT * FROM available_rooms_by_hotel";
        return jdbcTemplate.queryForList(sql);
    }

    @Override
    public Map<String, Object> getHotelRoomCapacity(Integer id) {
        String sql = "SELECT * FROM hotel_room_capacity WHERE id_hotel = ?";
        try {
            return jdbcTemplate.queryForMap(sql, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

}
