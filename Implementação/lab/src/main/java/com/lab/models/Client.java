package com.lab.models;

public class Client extends User {
    protected String clientName;
    protected int CPF;
    protected String RG;
    protected String profission;
    protected String company;
    protected double monthlyIncome;

    Client(String name, String email) {
        super(name, email);
    }

    public int getById(int id) {
        return 0;

    }
}
