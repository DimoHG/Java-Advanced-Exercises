package com.speedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCars = Integer.parseInt(scanner.nextLine());
        Map<String, Car> cars = new LinkedHashMap<>();

        for (int i = 0; i < numberOfCars; i++) {
            String[] carData = scanner.nextLine().split(" ");

            String model = carData[0];
            double fuelAmount = Double.parseDouble(carData[1]);
            double fuelConsumptionPer1KM = Double.parseDouble(carData[2]);

            Car car = new Car(model, fuelAmount, fuelConsumptionPer1KM);
            cars.put(model, car);
        }

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] commandParts = command.split(" ");

            String model = commandParts[1];
            int distance = Integer.parseInt(commandParts[2]);

            Car carToDrive = cars.get(model);
            carToDrive.drive(distance);
            command = scanner.nextLine();
        }

        cars.values().forEach(System.out::println);
    }
}
