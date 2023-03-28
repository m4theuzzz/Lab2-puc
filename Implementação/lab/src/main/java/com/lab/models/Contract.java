package com.lab.models;

public class Contract {
    protected int idContract;
    protected int type;
    protected boolean evaluated;
    protected boolean positive;

    Contract(int idContract, int type){
        this.idContract = idContract;
        this.type = type;

    }
}
