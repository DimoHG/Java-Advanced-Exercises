package com.softuni;

import java.util.Scanner;

public class MatrixPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] matrixSize = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(matrixSize[0]);
        int cols = Integer.parseInt(matrixSize[1]);

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char outsideLetter = (char) ('a' + row);
                char middleLetter = (char) ('a' + row + col);
                matrix[row][col] = String.valueOf(outsideLetter) + middleLetter + outsideLetter;
            }
        }

        //print matrix
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
