package com.softuni;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();

        Goat goat1 = new Goat("Goat 1");
        Goat goat2 = new Goat("Goat 2");
        animals.add(goat1);
        animals.add(goat2);

        Cow cow1 = new Cow("Cow 1");
        Cow cow2 = new Cow("Cow 2");
        animals.add(cow1);
        animals.add(cow2);

        for (Animal animal : animals) {
            animal.walk();
        }

        Animal animal = createAnimal();
        Animal animal2 = new Cow("Pepa");

        //Поведение, което задължаваме да бъде имплементирано в наследниците -> Interface
        //Искаме общи полета, конструктори, но все още имаме методи, които не можем да импл -> Abstract Class
        //Всичко е ясно. И методи и констр и полета -> Class
    }

    public static Animal createAnimal(){
        return new Cow("Pepa");
    }
}
