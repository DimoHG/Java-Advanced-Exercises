package collection;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myList = new MyListImpl();

        String[] words = scanner.nextLine().split(" ");
        int numberRemoveOperation = Integer.parseInt(scanner.nextLine());

        performAddOperations(words, addCollection);
        performAddOperations(words, addRemoveCollection);
        performAddOperations(words, myList);

        performRemoveOperations(numberRemoveOperation, addRemoveCollection);
        performRemoveOperations(numberRemoveOperation, myList);

    }

    public static void performRemoveOperations(int counter, AddRemovable addRemovable) {
        for (int i = 0; i < counter; i++) {
            System.out.print(addRemovable.remove() + " ");
        }
        System.out.println();
    }

    public static void performAddOperations(String[] words, Addable addable) {
        for (String word : words) {
            System.out.print(addable.add(word) + " ");
        }
        System.out.println();
    }
}
