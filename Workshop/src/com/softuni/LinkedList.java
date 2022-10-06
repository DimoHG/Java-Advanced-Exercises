package com.softuni;

import java.util.function.Consumer;

public class LinkedList {
    private Node head;
    private int size;

    public void addFirst(int number) {
        Node newNode = new Node(number);

        if(!isEmpty()){
            newNode.next = head;
        }
        head = newNode;
        size++;
    }

    public void addLast(int number){
        if(isEmpty()){
            addFirst(number);
            return;
        }
        Node newNode = new Node(number);
        Node currentNode = head;
        while(currentNode.next != null){
            currentNode = currentNode.next;
        }

        currentNode.next = newNode;
        size++;


    }

    public int removeFirst(){
        if(isEmpty()){
            throw new IllegalStateException("Can't remove from empty list!");
        }
        int result = head.value;
        head = head.next;
        size--;
        return result;
    }

    public int removeLast(){
        if(size < 2){
            return removeFirst();
        }

        Node currentNode = head;
        while(currentNode.next.next != null){
            currentNode = currentNode.next; //Стигаме до предпоследния node
        }

        int result = currentNode.next.value; //взимаме стойността на последния node
        currentNode.next = null;
        size--;
        return result;
    }

    private boolean isEmpty(){
        return this.size == 0;
    }

    public int get(int searchIndex){
        checkIndex(searchIndex);
        int currentIndex = 0;
        Node currentNode = head;

        while(currentIndex < searchIndex){
            currentNode = currentNode.next;
            currentIndex++;
        }

        return currentNode.value;
    }

    public void checkIndex(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("No such index in the list");
        }
    }

    public void forEach(Consumer<Integer> consumer){
        Node currentNode = head;
        while(currentNode != null){
            consumer.accept(currentNode.value);
            currentNode = currentNode.next;
        }
    }

    public int[] toArray(){
        int[] arr = new int[size];
        int counter = 0;
        Node currentNode = head;
        while(currentNode != null){
            arr[counter] = currentNode.value;
            counter++;
            currentNode = currentNode.next;
        }
        return arr;
    }
}
