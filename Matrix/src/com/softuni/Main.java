package com.softuni;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = 2;
        int cols = 3;
        int[][] matrix = new int[2][3];
        //read with for loop
        readMatrixWithForLoop(scanner, rows, cols, matrix);

        //read matrix with Stream API
        readMatrixWithStreamAPI(scanner, rows, matrix);

        //print with for loop
        printMatrixWithLoop(rows, cols, matrix);

        //print with forEach
        printMatrixWithForeach(matrix);
    }

    private static void printMatrixWithForeach(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static void printMatrixWithLoop(int rows, int cols, int[][] matrix) {
        for (int row = 0; row < rows; row++) { // rows loop
            for (int col = 0; col < cols; col++) { // columns loop
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void readMatrixWithStreamAPI(Scanner scanner, int rows, int[][] matrix) {
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine()
                            .split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }

    private static void readMatrixWithForLoop(Scanner scanner, int rows, int cols, int[][] matrix) {
        for (int row = 0; row < rows; row++) {
            String[] rowFromConsole = scanner.nextLine().split(" ");

            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(rowFromConsole[col]);;
            }
        }
    }
}
