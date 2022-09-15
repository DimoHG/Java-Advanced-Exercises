package com.softuni;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        a(10);
    }

    public static int a(int number){
        if(number == 0){
            return 0;
        }
        System.out.println(number);
        return a(number - 1);
    }


}
