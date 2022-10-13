package com.strategyPattern;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        TreeSet<Person> nameSet = new TreeSet<>(new PersonNameComparator());
        TreeSet<Person> ageSet = new TreeSet<>(new PersonAgeComparator());


        for (int i = 0; i < numberOfPeople; i++) {
            String[] personData = scanner.nextLine().split(" ");
            String name = personData[0];
            int age = Integer.parseInt(personData[1]);
            Person person = new Person(name, age);

            nameSet.add(person);
            ageSet.add(person);
        }

        for (Person person : nameSet) {
            System.out.println(person);
        }

        for (Person person : ageSet) {
            System.out.println(person);
        }
    }
}
