package com.softuni;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("1");
        list.add("1");
        Collections.sort(list);
    }

    public static void printName(int number, String city, String... names){
        for (String name : names) {
            System.out.println(name);
        }
    }

    public static <T extends Comparable<T>> void printLargest(T first, T second){
        if(first.compareTo(second) > 0){
            System.out.println(first);
        }
    }

    //1. Varargs
    //2. Comparable Comparator
}
