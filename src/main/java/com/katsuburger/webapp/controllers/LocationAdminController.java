package com.katsuburger.webapp.controllers;

import com.katsuburger.webapp.domain.Location;
import com.katsuburger.webapp.repository.LocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class LocationAdminController {
    private final LocationRepository locationRepository;

    @GetMapping("/admin/locations")
    public String displayLocations(Model model) {
        List<Location> locations = locationRepository.findAll();
        model.addAttribute("locations", locations);
        System.out.println(model);
        return "locations";
    }
    @GetMapping("/admin/locations/{name}")
    public String displayLocation(@PathVariable String name, Model model) {
        Location location = locationRepository.findById(name).orElseThrow();
        model.addAttribute("location", location);
        return "location";
    }
    @GetMapping("/admin/locations/{name}/edit")
    public String displayEditLocationDetails(@PathVariable String name, Model model) {
        Location location = locationRepository.findById(name).orElseThrow();
        model.addAttribute("location", location);
        return "location-edit";
    }

    @PostMapping("/admin/locations/{name}/edit/submit")
    public String updateLocationDetails(@PathVariable String name, Location updatedLocation, Model model) {
        Location location = locationRepository.findById(name).orElseThrow();
        location.updateLocation(updatedLocation);
        locationRepository.save(location);
        model.addAttribute("location", location);
        return "location";
    }

//    @PostMapping("/admin/locations/{city}")
//    public String
}
