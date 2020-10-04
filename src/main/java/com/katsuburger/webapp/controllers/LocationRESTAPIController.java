package com.katsuburger.webapp.controllers;

import com.katsuburger.webapp.repository.LocationRepository;
import com.katsuburger.webapp.domain.Location;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@AllArgsConstructor
public class LocationRESTAPIController {

    private final LocationRepository repository;
    @GetMapping("api/locations")
    List<Location> getAllLocations() {
        return repository.findAll();
    }
    @PostMapping("api/locations")
    Location postLocation(@RequestBody Location newLocation) {
        return repository.save(newLocation);
    }

    @GetMapping("api/locations/{id}")
    Location getLocation(@PathVariable String city) {
        return repository.findById(city)
                .orElseThrow(() -> new EntityNotFoundException());
    }
//    @PutMapping("/locations/{id}")
//    Location putLocation(@PathVariable Long id) {
//
//    }
}
