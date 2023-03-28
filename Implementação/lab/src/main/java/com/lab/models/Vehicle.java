package com.lab.models;

public class Vehicle {
    protected String register;
    protected int year;
    protected int model;
    protected String license;
    protected int owner;

    Vehicle(String register, int year, int model, String license, int owner){
        this.register = register;
        this.year = year;
        this.model = model;
        this.license = license;
        this.owner = owner;
    }
}
