package com.softuni;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TPRF {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Read names
        List<String> guests = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        Set<String> filters = new HashSet<>();

        String command = scanner.nextLine();
        while (!command.equals("Print")) {
            String[] commandParts = command.split(";");
            String addOrRemove = commandParts[0];
            String type = commandParts[1];
            String parameter = commandParts[2];
            if (addOrRemove.equals("Add filter")) {
                filters.add(type + ";" + parameter);
            } else {
                filters.remove(type + ";" + parameter);
            }
            command = scanner.nextLine();
        }
        filters.forEach(filter -> {
            Predicate<String> filterToApply = getPredicate(filter);
            guests.removeIf(filterToApply);
        });


        guests.forEach(name -> System.out.print(name + " "));
    }

    private static Predicate<String> getPredicate(String filter) {
        String[] filterParts = filter.split(";");
        String filterType = filterParts[0];
        String parameter = filterParts[1];
        switch (filterType) {
            case "Starts with":
                return s -> s.startsWith(parameter);
            case "Ends with":
                return s -> s.endsWith(parameter);
            case "Length":
                return s -> s.length() == Integer.parseInt(parameter);
            case "Contains":
                return s -> s.contains(parameter);
        }
        return null;
    }
}
