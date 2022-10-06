package com.softuni;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public void addFirst(int number) {
        Node newNode = new Node(number);

        if(!isEmpty()){
            newNode.next = head;
            head.prev = newNode;
        } else{
            tail = newNode;
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
        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public int removeFirst(){
        if(isEmpty()){
            throw new IllegalStateException("Can't remove from empty list!");
        }
        int result = head.value;
        size--;
        head = head.next;
        if(this.size > 1){
            head.prev = null;
        }
        if(isEmpty()){
            head = null;
            tail = null;
        }
        return result;
    }

    public int removeLast(){
        if(size < 2){
            return removeFirst();
        }
        int result = tail.value;
        tail = tail.prev;
        tail.next = null;
        this.size--;
        return result;
    }

    private boolean isEmpty(){
        return this.size == 0;
    }

    public int get(int searchIndex){
        checkIndex(searchIndex);
        int currentIndex = 0;
        Node currentNode;
        if(searchIndex > size / 2) {
            currentNode = tail;
            int lastIndex = size - 1;
            int countOfIterations = lastIndex - searchIndex;
            for (int i = 0; i < countOfIterations; i++) {
                currentNode = currentNode.prev;
            }
            //search from tail
        } else {
            currentNode = head;

            while(currentIndex < searchIndex){
                currentNode = currentNode.next;
                currentIndex++;
            }
            //search from head
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
        List<Integer> result = new ArrayList<>();
        forEach(result::add);
        return result.stream().mapToInt(e -> e).toArray();
    }

}
