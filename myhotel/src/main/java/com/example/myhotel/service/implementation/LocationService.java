package com.example.myhotel.service.implementation;

import com.example.myhotel.model.Location;
import com.example.myhotel.repository.LocationRepository;
import com.example.myhotel.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService implements ILocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    @Override
    public Location getLocationById(int id) {
        Optional<Location> location = locationRepository.findById(id);
        return location.orElse(null);
    }

    @Override
    public Location createLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location updateLocation(int id, Location location) {
        Optional<Location> existingLocation = locationRepository.findById(id);
        if (existingLocation.isPresent()) {
            location.setId(id);
            return locationRepository.save(location);
        } else {
            return null;
        }
    }

    @Override
    public void deleteLocation(int id) {
        locationRepository.deleteById(id);
    }
}
