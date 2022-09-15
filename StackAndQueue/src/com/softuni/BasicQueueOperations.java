package com.softuni;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        int countToOffer = Integer.parseInt(input[0]);
        int countToPoll = Integer.parseInt(input[1]);
        int elementToSearch = Integer.parseInt(input[2]);

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        String[] numbersToAdd = scanner.nextLine().split(" ");

        for (int i = 0; i < countToOffer; i++) {
            queue.offer(Integer.parseInt(numbersToAdd[i]));
        }

        for (int i = 0; i < countToPoll; i++) {
            queue.poll();
        }

        if (queue.isEmpty()) {
            System.out.println("0");
        } else if (queue.contains(elementToSearch)){
            System.out.println(true);
        } else {
            int minElement = queue.stream().mapToInt(e -> e).min().getAsInt();
            System.out.println(minElement);
        }
    }
}
