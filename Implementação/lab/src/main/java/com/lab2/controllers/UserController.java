package com.lab2.controllers;

import com.lab2.models.User;
import com.lab2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getUsers(
            @PathVariable Integer id
    ) {
        Optional<User> user = userService.findById(id);
        return user.orElse(null);
    }

    @PostMapping
    public ResponseEntity<User> postUser(@RequestBody User users) {
        User newUser = userService.saveUser(users);
        return ResponseEntity.created(UriComponentsBuilder.fromPath("/users").buildAndExpand(newUser.getId()).toUri()).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> putUser(
            @PathVariable Integer id,
            @RequestBody User user
    ) {
        User newUser = userService.updateUser(id, user);
        return ResponseEntity.created(UriComponentsBuilder.fromPath("/users").buildAndExpand(newUser.getId()).toUri()).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
