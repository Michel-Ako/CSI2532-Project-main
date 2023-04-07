package com.example.myhotel.service;

import com.example.myhotel.model.Location;

import java.util.List;

public interface ILocationService {
    List<Location> getAllLocations();
    Location getLocationById(int id);
    Location createLocation(Location location);
    Location updateLocation(int id, Location location);
    void deleteLocation(int id);
}
