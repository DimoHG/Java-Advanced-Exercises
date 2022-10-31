package shopping;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] people = scanner.nextLine().split(";");
        Map<String, Person> peopleMap = new LinkedHashMap<>();
        for (String personString : people) {
            String personData[] = personString.split("=");
            String name = personData[0];
            double money = Double.parseDouble(personData[1]);

            try {
                Person person = new Person(name, money);
                peopleMap.put(name, person);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                return;
            }
        }

        String[] products = scanner.nextLine().split(";");
        Map<String, Product> productMap = new LinkedHashMap<>();
        for (String productString : products) {
            String[] productData = productString.split("=");
            String name = productData[0];
            double cost = Double.parseDouble(productData[1]);

            try{
                Product product = new Product(name, cost);
                productMap.put(name, product);
            } catch(IllegalArgumentException ex){
                System.out.println(ex.getMessage());
                return;
            }
        }

        String command = scanner.nextLine();
        while(!"END".equals(command)){
            String[] commandParts = command.split(" ");
            String personName = commandParts[0];
            String productName = commandParts[1];

            Person buyer = peopleMap.get(personName);
            Product product = productMap.get(productName);
            try{
                buyer.buyProduct(product);
                System.out.printf("%s bought %s%n", personName, productName);
            } catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
            command = scanner.nextLine();
        }

        peopleMap.values().forEach(System.out::println);

    }
}
