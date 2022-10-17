package com.softuni;

import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {
        //read size OK
        //read the whole matrix OK
        //Where is the bee? OK
        //move in all directions OK
        //is it a flower, is it a bonus? OK
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        char[][] teritory = new char[size][size];
        int beeRow = -1;
        int beeCol = -1;
        for (int i = 0; i < size; i++) {
            char[] singleRow = scanner.nextLine().toCharArray();
            for (int j = 0; j < size; j++) {
                teritory[i][j] = singleRow[j];
                if (teritory[i][j] == 'B') {
                    beeRow = i;
                    beeCol = j;
                }
            }
        }
        int flowers = 0;
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            teritory[beeRow][beeCol] = '.';
            if (command.equals("right") && beeCol != size - 1) {
                beeCol++;
            } else if (command.equals("left") && beeCol != 0) {
                beeCol--;
            } else if (command.equals("down") && beeRow != size - 1) {
                beeRow++;
            } else if (command.equals("up") && beeRow != 0) {
                beeRow--;
            } else{
                teritory[beeRow][beeCol] = '.';
                System.out.println("The bee got lost!");
                break;
            }

            if(teritory[beeRow][beeCol] == 'f'){
                flowers++;
            } else if (teritory[beeRow][beeCol] == 'O'){
                continue;
            }
            teritory[beeRow][beeCol] = 'B';
            command = scanner.nextLine();
        }

        if(flowers < 5){
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - flowers);
        } else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", flowers);
        }
        printTeritory(size, teritory, beeRow, beeCol);


    }

    private static void printTeritory(int size, char[][] teritory, int beeRow, int beeCol) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(teritory[i][j]);
            }
            System.out.println();
        }
    }
}
