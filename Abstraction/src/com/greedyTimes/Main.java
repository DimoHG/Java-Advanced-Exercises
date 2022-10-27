
package com.greedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long capacity = Long.parseLong(scanner.nextLine());
        String[] safe = scanner.nextLine().split("\\s+");

        Bag myBag = new Bag();

        for (int i = 0; i < safe.length; i += 2) {
            String itemName = safe[i];
            long amount = Long.parseLong(safe[i + 1]);

            Item item = createItem(itemName, amount);

            myBag.put(item);
        }

        System.out.println(myBag);
    }

    private static Item createItem(String itemName, long amount){
        ItemType itemType;

        //create Item
        if (itemName.length() == 3) {
            itemType = ItemType.CASH;
        } else if (itemName.toLowerCase().endsWith("gem")) {
            itemType = ItemType.GEM;
        } else if (itemName.toLowerCase().equals("gold")) {
            itemType = ItemType.GOLD;
        } else {
            return null;
        }

        return new Item(itemType, itemName, amount);
    }
}