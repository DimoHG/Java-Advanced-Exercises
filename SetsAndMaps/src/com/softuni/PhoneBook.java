package com.softuni;

import java.util.HashMap;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        HashMap<String, String> phonebook = new HashMap<>();

        while(!input.equals("search")){
            String[] personInfo = input.split("-");
            String name = personInfo[0];
            String phoneNumber = personInfo[1];
            phonebook.put(name, phoneNumber);
            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while(!input.equals("stop")){
            if(phonebook.containsKey(input)){
                System.out.printf("%s -> %s%n", input, phonebook.get(input));
            } else {
                System.out.printf("Contact %s does not exist.%n", input);
            }
            input = scanner.nextLine();
        }
    }
}
