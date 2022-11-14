package solid;

import solid.calculator.CalorieCalculator;
import solid.calculator.ProteinCalculator;
import solid.output.ConsoleOutput;

public class Main {

    public static void main(String[] args) {
        CalorieCalculator calorieCalculator = new CalorieCalculator();
        ProteinCalculator proteinCalculator = new ProteinCalculator();
        ConsoleOutput printer = new ConsoleOutput();

//        printer.printAverage();
    }
}
