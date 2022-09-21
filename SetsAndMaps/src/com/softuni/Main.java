package com.softuni;

import java.util.*;
import java.util.function.ToIntFunction;

public class Main {

    public static void main(String[] args) {
        String cardPower = "J";
        int power = 0;
        try{
            power = Integer.parseInt(cardPower);
        } catch (Exception e){
            switch (cardPower){
                case "J":
                    power = 11;
                    break;
                case "Q":
                    power = 12;
                    break;
            }
        }
        System.out.println(power);
    }
}
