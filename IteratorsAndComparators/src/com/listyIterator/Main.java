package com.listyIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ListyIterator listyIterator = null;
        while(!input.equals("END")){
            String[] commandParts = input.split(" ");
            String commandName = commandParts[0];
            switch (commandName){
                case "Create":
                    if(commandParts.length > 1){
                        String[] elementArray = Arrays.copyOfRange(commandParts, 1, commandParts.length);
                        listyIterator = new ListyIterator(elementArray);
                    } else {
                        listyIterator = new ListyIterator();
                    }
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "Print":
                    try{
                        listyIterator.print();
                    } catch(IllegalStateException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "PrintAll":
                    listyIterator.printAll();
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
