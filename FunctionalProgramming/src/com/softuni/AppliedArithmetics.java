package com.softuni;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
//        Consumer<List<Integer>> kani = numbers -> numbers.replaceAll(e -> e + 1);

        UnaryOperator<List<Integer>> add = numbers -> numbers.stream().map(number -> number + 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> subtract = numbers -> numbers.stream().map(number -> number - 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> multiply = numbers -> numbers.stream().map(number -> number * 2).collect(Collectors.toList());

        Consumer<List<Integer>> printer = numbers -> numbers.forEach(number -> System.out.print(number + " "));
        String command = scanner.nextLine();

        while(!command.equals("end")){
            switch (command) {
                case "add":
                    list = add.apply(list);
                    break;
                case "subtract":
                    list = subtract.apply(list);
                    break;
                case "multiply":
                    list = multiply.apply(list);
                    break;
                case "print":
                    printer.accept(list);
                    System.out.println();
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
