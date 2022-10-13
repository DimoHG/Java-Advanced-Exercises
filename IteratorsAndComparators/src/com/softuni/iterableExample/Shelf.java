package com.softuni.iterableExample;

import java.util.Iterator;
import java.util.List;

public class Shelf implements Iterable<String>{
    private List<String> products;

    public Shelf(String... products) {
        this.products = List.of(products);
    }

    @Override
    public Iterator<String> iterator() {
       return new Seller();
    }

    class Seller implements Iterator<String>{
        int index = 0;
        @Override
        public boolean hasNext() {
            return index < products.size();
        }

        @Override
        public String next() {
            String product = products.get(index);
            index++;
            return product;
        }
    }
}