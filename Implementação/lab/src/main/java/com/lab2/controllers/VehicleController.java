package com.lab2.controllers;

import com.lab2.models.Vehicle;
import com.lab2.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vehicles")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public List<Vehicle> getVehicles() {
        return vehicleService.findAll();
    }

    @GetMapping("/{id}")
    public Vehicle getVehicles(
            @PathVariable Integer id
    ) {
        Optional<Vehicle> vehicle = vehicleService.findById(id);
        return vehicle.orElse(null);
    }

    @PostMapping
    public ResponseEntity<Vehicle> postVehicle(@RequestBody Vehicle vehicle) {
        Vehicle newVehicle = vehicleService.saveVehicle(vehicle);
        return ResponseEntity.created(UriComponentsBuilder.fromPath("/vehicles").buildAndExpand(newVehicle.getId()).toUri()).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> putVehicle(
            @PathVariable Integer id,
            @RequestBody Vehicle vehicle
    ) {
        Vehicle newVehicle = vehicleService.updateVehicle(id, vehicle);
        return ResponseEntity.created(UriComponentsBuilder.fromPath("/vehicles").buildAndExpand(newVehicle.getId()).toUri()).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        vehicleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
