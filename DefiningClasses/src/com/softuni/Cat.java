package com.softuni;


public class Cat {
    private String EGN;
    private String name;
    private String lastName;
    private int age;
    public static int averageLifespan = 15;
    public static String favouriteFood;

    public Cat(String name, int age){
        setAge(age);
        this.name = name;
    }

    public Cat(String EGN, String name, String lastName, int age) {
        this.EGN = EGN;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public Cat(String EGN, String name, String lastName) {
        this.EGN = EGN;
        this.name = name;
        this.lastName = lastName;
    }

    public void meow(){
        System.out.printf("Meow from: %s%n", this.name);
    }

    public void setAge(int newAge){
        if(newAge < 0){
            throw new IllegalArgumentException("Age must be positive number");
        }
        age = newAge;
    }

    public String getEGN() {
        return this.EGN;
    }

    public void setEGN(String EGN) {
        this.EGN = EGN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }
}
