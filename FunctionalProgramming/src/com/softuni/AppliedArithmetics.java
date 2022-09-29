package com.softuni;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while(!command.equals("end")){
            switch (command) {
                case "add":
                    break;
                case "subtract":
                    break;
                case "multiply":
                    break;
                case "print":
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
