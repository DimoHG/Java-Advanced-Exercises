package com.softuni;

public class Main {

    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        System.out.println(list.get(0));
        System.out.println(list.removeFirst());
        System.out.println(list.removeFirst());

        System.out.println();


    }
}
