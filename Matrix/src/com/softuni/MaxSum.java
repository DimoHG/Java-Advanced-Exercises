package com.softuni;

import java.util.Scanner;

public class MaxSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] matrixSize = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(matrixSize[0]);
        int cols = Integer.parseInt(matrixSize[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] inputRow = scanner.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(inputRow[col]);
            }
        }
        int maxSum = Integer.MIN_VALUE;
        int bestStartingRow = 0;
        int bestStartingCol = 0;
        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2]
                        + matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];

//                for (int currentRow = row; currentRow < row + 3; currentRow++) {
//                    for (int currentCol = col; currentCol < col + 3; currentCol++) {
//                        sum += matrix[currentRow][currentCol];
//                    }
//                }
                if(sum > maxSum){
                    maxSum = sum;
                    bestStartingRow = row;
                    bestStartingCol = col;
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        for (int row = bestStartingRow; row < bestStartingRow + 3; row++) {
            for (int col = bestStartingCol; col < bestStartingCol + 3; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

    }
}
