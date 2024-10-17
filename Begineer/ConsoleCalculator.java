import java.util.Scanner;

public class ConsoleCalculator {

    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        int userChoice;
        do {
            System.out.println("### Multi-Functional Console Calculator ###");
            System.out.println("1. Perform Arithmetic");
            System.out.println("2. Scientific Operations");
            System.out.println("3. Conversion Options");
            System.out.println("4. Close Application");
            System.out.print("Please choose an option: ");
            userChoice = userInput.nextInt();

            switch (userChoice) {
                case 1:
                    arithmeticOperations();
                    break;
                case 2:
                    scientificCalculations();
                    break;
                case 3:
                    conversionOptions();
                    break;
                case 4:
                    System.out.println("Exiting the program. Have a great day!");
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        } while (userChoice != 4);

        userInput.close();
    }

    public static void arithmeticOperations() {
        System.out.println("### Arithmetic Calculations ###");
        System.out.print("Enter the first value: ");
        double firstValue = userInput.nextDouble();
        System.out.print("Enter the second value: ");
        double secondValue = userInput.nextDouble();

        System.out.println("Select an arithmetic operation:");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");
        System.out.print("Enter your choice: ");
        int operationChoice = userInput.nextInt();

        switch (operationChoice) {
            case 1:
                System.out.println("Result: " + (firstValue + secondValue));
                break;
            case 2:
                System.out.println("Result: " + (firstValue - secondValue));
                break;
            case 3:
                System.out.println("Result: " + (firstValue * secondValue));
                break;
            case 4:
                if (secondValue != 0) {
                    System.out.println("Result: " + (firstValue / secondValue));
                } else {
                    System.out.println("Error: Cannot divide by zero.");
                }
                break;
            default:
                System.out.println("Invalid operation selection.");
        }
    }

    public static void scientificCalculations() {
        System.out.println("### Advanced Scientific Operations ###");
        System.out.println("1. Calculate Square Root");
        System.out.println("2. Power Calculation");
        System.out.print("Select a scientific function: ");
        int sciOperation = userInput.nextInt();

        switch (sciOperation) {
            case 1:
                System.out.print("Enter a number to find the square root: ");
                double number = userInput.nextDouble();
                if (number >= 0) {
                    System.out.println("Square Root: " + Math.sqrt(number));
                } else {
                    System.out.println("Error: Negative number has no real square root.");
                }
                break;
            case 2:
                System.out.print("Enter the base value: ");
                double baseValue = userInput.nextDouble();
                System.out.print("Enter the exponent value: ");
                double exponentValue = userInput.nextDouble();
                System.out.println("Result: " + Math.pow(baseValue, exponentValue));
                break;
            default:
                System.out.println("Invalid selection for scientific operation.");
        }
    }

    public static void conversionOptions() {
        System.out.println("### Conversion Options ###");
        System.out.println("1. Convert Temperature");
        System.out.print("Choose a conversion option: ");
        int conversionChoice = userInput.nextInt();

        switch (conversionChoice) {
            case 1:
                temperatureConversion();
                break;
            default:
                System.out.println("Invalid conversion option.");
        }
    }

    public static void temperatureConversion() {
        System.out.println("### Temperature Conversion ###");
        System.out.println("1. Convert Celsius to Fahrenheit");
        System.out.println("2. Convert Fahrenheit to Celsius");
        System.out.print("Select a temperature conversion: ");
        int tempOption = userInput.nextInt();

        System.out.print("Enter the temperature value: ");
        double tempValue = userInput.nextDouble();

        switch (tempOption) {
            case 1:
                System.out.println("Temperature in Fahrenheit: " + ((tempValue * 9/5) + 32));
                break;
            case 2:
                System.out.println("Temperature in Celsius: " + ((tempValue - 32) * 5/9));
                break;
            default:
                System.out.println("Invalid temperature conversion option.");
        }
    }
}