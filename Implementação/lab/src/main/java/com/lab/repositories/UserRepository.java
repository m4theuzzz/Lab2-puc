package com.lab.repositories;

import java.util.Optional;

import com.lab.models.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

    Optional<User> findByCpf(String cpf);

    Optional<User> findById(Long id);

    User save(User newObj);

    void delete(User obj);
}
