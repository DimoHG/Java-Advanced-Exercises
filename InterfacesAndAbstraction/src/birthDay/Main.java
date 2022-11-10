package birthDay;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<Birthable> thingsWithBirthday = new ArrayList<>();

        while(!"End".equals(input)){
            String[] commandParts = input.split(" ");
            String objectType = commandParts[0];
            switch (objectType){
                case "Citizen":
                    String personName = commandParts[1];
                    int personAge = Integer.parseInt(commandParts[2]);
                    String personId = commandParts[3];
                    String personBirthDate = commandParts[4];
                    Citizen citizen = new Citizen(personName, personAge, personId, personBirthDate);
                    thingsWithBirthday.add(citizen);
                    break;
                case "Pet":
                    String petName = commandParts[1];
                    String petBirthDate = commandParts[2];
                    Pet pet = new Pet(petName, petBirthDate);
                    thingsWithBirthday.add(pet);
                    break;
                case "Robot":
                    break;
            }
            input = scanner.nextLine();
        }

        String year = scanner.nextLine();


        boolean isFound = false;
        for (Birthable birthable : thingsWithBirthday) {
            if(birthable.getBirthDate().endsWith(year)){
                System.out.println(birthable.getBirthDate());
                isFound = true;
            }
        }

        if(!isFound){
            System.out.println("<no output>");
        }
    }
}
