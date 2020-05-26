package com.jpa.application.jpa.application;

public class CompanyNotFoundException extends Exception {
    private int id;
    public CompanyNotFoundException(int id)
    {
        super("User id not found : " + id);
    }
}
