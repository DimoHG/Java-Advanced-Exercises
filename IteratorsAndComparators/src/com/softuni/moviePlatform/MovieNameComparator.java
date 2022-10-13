package com.softuni.moviePlatform;

import java.util.Comparator;

public class MovieNameComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie first, Movie second) {
        return first.getName().compareTo(second.getName());
    }
}
