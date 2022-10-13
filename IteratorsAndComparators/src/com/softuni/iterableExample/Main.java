package com.softuni.iterableExample;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Shelf shelf = new Shelf("Apple", "Banana", "Orange", "Watermelon");
        for (String s : shelf) {
            System.out.println(s);
        }
    }

    //Iterable -> Нещо, което може да се итерира (Щанд)
    //Iterator -> Нещото, което извършва итерацията (Продавача)
}
