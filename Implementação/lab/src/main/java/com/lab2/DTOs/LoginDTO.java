package com.lab2.DTOs;

import java.util.Objects;

public class LoginDTO {
    private String email;
    private String password;

    LoginDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public Boolean matchPassword(String password) {
        return Objects.equals(this.password, password);
    }
}
