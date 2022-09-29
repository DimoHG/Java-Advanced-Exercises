package com.softuni;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CustomComparing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Comparator<Integer> comparator =  (first, second) -> {
            if(first % 2 == 0 && second % 2 != 0){
                return -1;
                //първото е четно
                //второто е нечетно
            } else if(first %2 != 0 && second % 2 == 0){
                return 1;
                //първото е нечетно
                //второто е четно
            }
            //и двете са четни
            //и двете са нечетни

            return first.compareTo(second);
        };

        Arrays.sort(numbers, comparator);

        Arrays.stream(numbers).forEach(e -> System.out.print(e + " "));
    }
}
