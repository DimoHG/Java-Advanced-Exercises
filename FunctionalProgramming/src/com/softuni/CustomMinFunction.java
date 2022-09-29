package com.softuni;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], Integer> function = arr -> {
            int min = Integer.MAX_VALUE;
            for (int number : arr) {
                if(number < min){
                    min = number;
                }
            }
            return min;
        };

//        Function<int[], Integer> minimum = elements -> Arrays.stream(elements).min().orElseThrow(() -> new IllegalArgumentException());
//        Function<int[], Integer> minFunction = elements -> Collections.min(Arrays.stream(elements).boxed().collect(Collectors.toList()));

        int min = function.apply(numbers);

        System.out.println(min);

    }
}
