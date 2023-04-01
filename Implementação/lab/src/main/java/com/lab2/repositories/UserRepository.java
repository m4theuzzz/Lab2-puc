package com.lab2.repositories;

import com.lab2.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByEmail(String login);

    Optional<User> findById(Integer id);

    List<User> findAllByType(String type);

    void deleteById(Integer id);

}