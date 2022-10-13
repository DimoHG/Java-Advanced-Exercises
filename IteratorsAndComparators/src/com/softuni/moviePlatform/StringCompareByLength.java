package com.softuni.moviePlatform;

import java.util.Comparator;

public class StringCompareByLength implements Comparator<String> {

    @Override
    public int compare(String first, String second) {
        return Integer.compare(first.length(), second.length());
    }
}
