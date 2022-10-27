package com.greedyTimes;

import java.util.LinkedHashMap;
import java.util.List;

public class Bag {
    private List<Item> items;
    private int capacity;
    //put

    @Override
    public String toString() {
       //printLogic
        return "";
    }

    public void put(Item item) {

        if(weCanStore(item)){
            //check if we should update value, or create a new one
            items.add(item);
        }
    }

    private boolean weCanStore(Item item){
        if (capacity < getTotalAmount() + item.getAmount()) {
            return false;
        }
        switch (item.getItemType()) {
            case GEM:
                if (getAmount(ItemType.GEM) + item.getAmount() > getAmount(ItemType.GOLD)) {
                    return false;
                }
                break;
            case CASH:
                if (getAmount(ItemType.CASH) + item.getAmount() > getAmount(ItemType.GEM)) {
                    return false;
                }
                break;
        }
        return true;
    }

    public long getTotalAmount() {
        return getAmount(ItemType.GEM) + getAmount(ItemType.GOLD) + getAmount(ItemType.CASH)
    }

    public long getAmount(ItemType itemType) {
        return this.items.stream()
                .filter(e -> e.getItemType().equals(itemType))
                .mapToLong(e -> e.getAmount())
                .sum();
    }
}
