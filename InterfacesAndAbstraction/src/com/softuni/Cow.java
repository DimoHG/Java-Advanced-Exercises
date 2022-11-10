package com.softuni;

public class Cow extends Mammal implements Animal{
    private String name;

    public Cow(String name) {
        this.name = name;
    }
    public void walk(){
        System.out.println("Goat is walking");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
