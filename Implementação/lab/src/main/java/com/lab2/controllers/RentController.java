package com.lab2.controllers;

import com.lab2.models.Rent;
import com.lab2.services.RentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rents")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RentController {

    @Autowired
    private RentService rentService;

    @GetMapping
    public List<Rent> getRents() {
        return rentService.findAll();
    }

    @GetMapping("/{id}")
    public Rent getRents(
            @PathVariable Integer id
    ) {
        Optional<Rent> rent = rentService.findById(id);
        return rent.orElse(null);
    }

    @PostMapping
    public ResponseEntity<Rent> postRent(@RequestBody Rent rent) {
        Rent newRent = rentService.saveRent(rent);
        return ResponseEntity.created(UriComponentsBuilder.fromPath("/rents").buildAndExpand(newRent.getId()).toUri()).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rent> putRent(
            @PathVariable Integer id,
            @RequestBody Rent rent
    ) {
        Rent newRent = rentService.updateRent(id, rent);
        return ResponseEntity.created(UriComponentsBuilder.fromPath("/rents").buildAndExpand(newRent.getId()).toUri()).build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        rentService.delete(id);
        return ResponseEntity.ok().build();
    }
}
