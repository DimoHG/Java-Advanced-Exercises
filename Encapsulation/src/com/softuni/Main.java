package com.softuni;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    }
    private static  void printName(String name) {
        if ( name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        System.out.println(name);
    }
}
//public -> everywhere
//private -> only in current class
//protected -> in the same package, or child class
//default -> only in the same package
