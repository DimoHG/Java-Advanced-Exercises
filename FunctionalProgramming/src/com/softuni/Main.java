package com.softuni;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
//        list.add("-5"); //1.5
//        list.add("5"); //1.5

        Stream.of("cat", "dog", "elephant", "fox", "rabbit", "duck")
                .takeWhile(n -> n.length() % 2 != 0)
                .forEach(System.out::println);
    }
    //Function<приема, връща>
    //UnaryOperator<приема и връща>
    //Predicate<приемаме> връщаме винаги boolean
    //Consumer<приема> не връща нищо
    //Supplier<връща>

    public static Integer parseString(String text) {
        Integer result = Integer.parseInt(text);
        return result;
    }
}
