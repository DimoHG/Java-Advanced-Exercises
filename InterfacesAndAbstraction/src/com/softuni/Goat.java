package com.softuni;

public class Goat extends Mammal implements Animal, Swimmer {
    private String name;

    public Goat(String name) {
        this.name = name;
    }


    public void walk() {
        System.out.println("Goat is walking");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void swim() {
        System.out.println("Goat is swimming");
    }
}
