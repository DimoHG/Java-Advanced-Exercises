package com.softuni;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers= Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> function = list -> {
            int min = Integer.MAX_VALUE;
            int index = -1;

            for (int i = 0; i < list.size(); i++) {
                if(list.get(i) <= min){
                    min = list.get(i);
                    index = i;
                }
            }
            return index;
        };

//        Function<List<Integer>, Integer> alternativeFunction = list -> {
//            int min = list.stream().mapToInt(e -> e).min().getAsInt();
//            return list.lastIndexOf(min);
//        };

        System.out.println(function.apply(numbers));
    }
}
