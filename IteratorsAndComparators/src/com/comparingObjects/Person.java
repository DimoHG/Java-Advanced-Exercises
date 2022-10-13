package com.comparingObjects;

import java.util.Objects;

public class Person implements Comparable<Person>{
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null || getClass() != otherObject.getClass()) return false;
        Person person = (Person) otherObject;
        return  age == person.age
                && Objects.equals(name, person.name)
                && Objects.equals(town, person.town);
    }

    @Override
    public int compareTo(Person otherPerson) {
        if(this.getName().equals(otherPerson.name)){
            //еднакви имена
            if(this.getAge() == otherPerson.getAge()){
                //еднаква възраст
                return this.getTown().compareTo(otherPerson.getTown());
            } else {
                return Integer.compare(this.getAge(), otherPerson.getAge());
            }
        }
        return this.getName().compareTo(otherPerson.getName());
    }
}
