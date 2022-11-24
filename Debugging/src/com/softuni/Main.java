package com.softuni;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int a = 7;
        int[] arr = new int[5];
        changeArr(arr);
        System.out.println(arr[2]);
    }

    public static void changeA(int a){
        a = 200;
    }

    public static void changeArr(int[] arr){
        arr[2] = 200;
    }

    public static double sum(){
            return getA() + getB();
    }


    public static int getA(){
        return 5;
    }

    public static int getB(){
        return 5;
    }
}
