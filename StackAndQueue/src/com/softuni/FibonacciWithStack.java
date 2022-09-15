package com.softuni;

import java.util.ArrayDeque;
import java.util.Scanner;

public class FibonacciWithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Long> stack = new ArrayDeque<>();
        stack.push(0l);
        stack.push(1l);

        if(n < 2){
            System.out.println(1);
            return;
        }

        for (int i = 0; i < n; i++) {
            long num1 = stack.pop();
            long num2 = stack.pop();
            stack.push(num1);
            stack.push(num1 + num2);
        }

        System.out.println(stack.pop());
    }
}
