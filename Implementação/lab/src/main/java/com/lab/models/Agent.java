package com.lab.models;

public class Agent extends User {

    protected int type;
    protected int idContract;

    Agent(String name, String email) {
        super(name, email);
    }

    public int evaluateContract(int id) {
        return 0;
    }

}
