package com.lab.services;

import com.lab.models.User;
import com.lab.repositories.UserRepository;
import com.lab.services.exceptions.DataBindingViolationException;
import com.lab.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findById(Long id) throws ObjectNotFoundException {
        Optional<User> user = this.userRepository.findById(id);

        return user.orElseThrow(() -> new ObjectNotFoundException("User not found in database"));
    }

    public User findByCpf(String cpf) throws ObjectNotFoundException {
        Optional<User> user = this.userRepository.findByCpf(cpf);

        return user.orElseThrow(() -> new ObjectNotFoundException("User not found in database"));
    }

    public User create(User newObj) {
        return this.userRepository.save(newObj);
    }

    public User update(User obj) {
        return this.userRepository.save(obj);
    }

    public void delete(Long id) throws DataBindingViolationException, ObjectNotFoundException {
        try {
            User obj = findById(id);
            this.userRepository.delete(obj);
        } catch (Exception e) {
            throw new DataBindingViolationException("Entity loan depends on another entity");
        } catch (ObjectNotFoundException e) {
            throw new ObjectNotFoundException(e.getMessage());
        }
    }
}
