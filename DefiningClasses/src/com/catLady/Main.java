package com.catLady;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        HashMap<String, Cat> cats = new HashMap<>();

        while (!line.equals("End")) {
            String[] catData = line.split(" ");

            String catBreed = catData[0];
            String catName = catData[1];
            Cat cat = null;
            switch (catBreed) {
                case "Siamese":
                    double earSize = Double.parseDouble(catData[2]);
                    cat = new Siamese(catName, earSize);
                    break;
                case "Cymric":
                    double furLength = Double.parseDouble(catData[2]);
                    cat = new Cymric(catName, furLength);
                    break;
                case "StreetExtraordinaire":
                    double decibels = Double.parseDouble(catData[2]);
                    cat = new StreetExtraordinaire(catName, decibels);
                    break;
            }
            cats.put(catName, cat);
            line = scanner.nextLine();
        }


        String catNameToSearch = scanner.nextLine();
        if(cats.containsKey(catNameToSearch)){
            System.out.println(cats.get(catNameToSearch));
        }

    }
}
