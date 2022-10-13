package com.softuni.moviePlatform;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();
        Movie movie1 = new Movie("Titanic", 15, 10);
        Movie movie2 = new Movie("Lord Of The Ringts", 25, 9);
        Movie movie3 = new Movie("A Softuni Movie", 35, 8);

        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);

        MovieNameComparator byName = new MovieNameComparator();
        MovieBudgetComparator byBudget = new MovieBudgetComparator();

        Collections.sort(movies, byName);
        Collections.sort(movies, byBudget);

        List<String> list = new ArrayList<>();
        list.add("Asen");
        list.add("Gogoooo");
        list.add("Stef");

        Collections.sort(list, new StringCompareByLength());
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println();
    }

    //Comparable -> compareTo -> Сравним
        //Пишем в самия клас
        //- имаме само един начин на сравнение
    //Comparator -> compare -> Сравнител
        //Създаваме си допълнителни класове
        //Можем да имаме колко си искаме начини за сравнение
}
