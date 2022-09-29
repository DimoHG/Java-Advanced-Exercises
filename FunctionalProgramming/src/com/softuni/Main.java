package com.softuni;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("Pesho", 2);
        map.put("Ivan", 3);
        map.put("Georgi", 4);

        map.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + entry.getValue()));
        map.keySet().stream().forEach(System.out::println);
        map.values().stream().forEach(System.out::println);
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
