package com.softuni;

public class Person { //POJO -> Plain Old Java Object
    private String EGN;
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getEGN() {
        return EGN;
    }

    public void setEGN(String EGN) {

        this.EGN = EGN;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
