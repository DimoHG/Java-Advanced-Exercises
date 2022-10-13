package com.comparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Person> people = new ArrayList<>();

        while (!input.equals("END")) {
            String[] peopleData = input.split(" ");
            String name = peopleData[0];
            int age = Integer.parseInt(peopleData[1]);
            String town = peopleData[2];

            Person person = new Person(name, age, town);
            people.add(person);
            input = scanner.nextLine();
        }

        int mainPersonIndex = Integer.parseInt(scanner.nextLine());
        int samePeople = 0;
        int differentPeople = 0;
        Person mainPerson = people.get(mainPersonIndex - 1);

        for (Person person : people) {
            if (person.equals(mainPerson)) {
                samePeople++;
            } else {
                differentPeople++;
            }
        }

        if (samePeople == 1) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d", samePeople, differentPeople, people.size());
        }

    }
}
