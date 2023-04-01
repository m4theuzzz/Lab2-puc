package com.lab2.services;

import com.lab2.models.Rent;
import com.lab2.repositories.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentService {

    @Autowired
    private RentRepository rentRepository;

    public Rent saveRent(Rent rent) {
        return rentRepository.save(rent);
    }

    public Optional<Rent> findById(Integer id) {
        return rentRepository.findById(id);
    }

    public Rent updateRent(Integer id, Rent rent) {
        Optional<Rent> optionalRent = rentRepository.findById(id);
        if (optionalRent.isPresent()) {
            Rent existingRent = optionalRent.get();
            existingRent.setRequester(rent.getRequester());
            existingRent.setVehicleId(rent.getVehicleId());
            existingRent.setExpireAt(rent.getExpireAt());
            existingRent.setStatus(rent.getStatus());

            return rentRepository.save(existingRent);
        } else {
            return null;
        }
    }

    public void delete(Integer id) {
        rentRepository.deleteById(id);
    }

    public List<Rent> findAll() {
        return rentRepository.findAll();
    }
}
