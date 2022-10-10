package com.list;

public class Sorter {

    public static <T extends Comparable<T>> void sort(CustomList<T> customList) {
        for (int i = 0; i < customList.size(); i++) {
            for (int j = 1; j < (customList.size() - i); j++) {
                if (customList.get(j - 1).compareTo(customList.get(j)) > 0) {
                    customList.swap(j - 1, j);
                }
            }
        }
    }

}
