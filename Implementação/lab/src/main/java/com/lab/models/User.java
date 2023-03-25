package com.lab.models;

import java.util.List;
import java.util.Objects;

import static com.lab.Lab.Users;

public class User {
    protected String name;
    protected String email;
    private String password;

    User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    User (String name, String email) {
        this.name = name;
        this.email = email;
    }

    public static <T extends User> T login(String email, String password) throws Exception {
        List<T> foundUser = Users.stream().filter(user -> {
            return Objects.equals(user.email, email) && Objects.equals(user.password, password);
        }).map(user -> (T) user).toList();

        if (foundUser.size() == 0) {
            throw new Exception("Incorrect email or password.");
        }

        return foundUser.get(0);
    }
}
