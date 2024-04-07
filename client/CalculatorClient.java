package client;

import java.rmi.Naming;
import java.util.Scanner;

import shared.CalculatorService;

public class CalculatorClient {
    /**
     * Main method of the client. It connects to the remote object
     * and starts the calculation process.
     *
     * @param args Not used
     */
    public static void main(String[] args) {
        try {
            // Lookup the remote object
            CalculatorService calculator = (CalculatorService) Naming.lookup("rmi://localhost/CalculatorService");

            // Create a new Scanner to read user input
            Scanner scanner = new Scanner(System.in);

            // Main loop
            while (true) {
                System.out.println("Choose an operation:");
                System.out.println("1. Addition");
                System.out.println("2. Subtraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");
                System.out.println("5. Exit");
                System.out.print("Enter the number of the desired operation: ");

                // Read the user choice
                int choice = scanner.nextInt();

                // Exit if the user wants to
                if (choice == 5) {
                    System.out.println("Exiting the client.");
                    break;
                }

                // Read the two numbers
                System.out.print("Enter the first number: ");
                int num1 = (int) scanner.nextDouble();
                System.out.print("Enter the second number: ");
                int num2 = (int) scanner.nextDouble();

                int result = 0;

                // Perform the operation
                switch (choice) {
                    case 1:
                        result = calculator.add(num1, num2);
                        break;
                    case 2:
                        result = calculator.subtract(num1, num2);
                        break;
                    case 3:
                        result = calculator.multiply(num1, num2);
                        break;
                    case 4:
                        if (num2 != 0) {
                            result = calculator.divide(num1, num2);
                        } else {
                            System.out.println("Can't divide by zero.");
                            continue;
                        }
                        break;
                    default:
                        System.out.println("Invalid operation.");
                        continue;
                }

                // Print the result
                System.out.println("Result: " + result);
            }

            // Close the scanner
            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
