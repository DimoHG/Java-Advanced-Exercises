package com.softuni.moviePlatform;

import java.util.Comparator;

public class MovieBudgetComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie first, Movie second) {
        return first.getBudget() - second.getBudget();
    }
}
