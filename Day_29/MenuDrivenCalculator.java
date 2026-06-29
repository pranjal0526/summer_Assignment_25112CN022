// Write a program to create menu-driven calculator.

import java.util.Scanner;

public class MenuDrivenCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("Menu-Driven Calculator");

        do {
            System.out.println();
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Modulus");
            System.out.println("6. Power");
            System.out.println("7. Exit");

            choice = readInt(sc, "Enter your choice: ");

            switch (choice) {
                case 1:
                    performAddition(sc);
                    break;
                case 2:
                    performSubtraction(sc);
                    break;
                case 3:
                    performMultiplication(sc);
                    break;
                case 4:
                    performDivision(sc);
                    break;
                case 5:
                    performModulus(sc);
                    break;
                case 6:
                    performPower(sc);
                    break;
                case 7:
                    System.out.println("Exiting calculator.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select between 1 and 7.");
            }
        } while (choice != 7);

        sc.close();
    }

    private static void performAddition(Scanner sc) {
        double firstNumber = readDouble(sc, "Enter first number: ");
        double secondNumber = readDouble(sc, "Enter second number: ");
        System.out.printf("Result: %.2f%n", firstNumber + secondNumber);
    }

    private static void performSubtraction(Scanner sc) {
        double firstNumber = readDouble(sc, "Enter first number: ");
        double secondNumber = readDouble(sc, "Enter second number: ");
        System.out.printf("Result: %.2f%n", firstNumber - secondNumber);
    }

    private static void performMultiplication(Scanner sc) {
        double firstNumber = readDouble(sc, "Enter first number: ");
        double secondNumber = readDouble(sc, "Enter second number: ");
        System.out.printf("Result: %.2f%n", firstNumber * secondNumber);
    }

    private static void performDivision(Scanner sc) {
        double firstNumber = readDouble(sc, "Enter first number: ");
        double secondNumber = readDouble(sc, "Enter second number: ");

        if (secondNumber == 0) {
            System.out.println("Division by zero is not allowed.");
            return;
        }

        System.out.printf("Result: %.2f%n", firstNumber / secondNumber);
    }

    private static void performModulus(Scanner sc) {
        double firstNumber = readDouble(sc, "Enter first number: ");
        double secondNumber = readDouble(sc, "Enter second number: ");

        if (secondNumber == 0) {
            System.out.println("Modulus by zero is not allowed.");
            return;
        }

        System.out.printf("Result: %.2f%n", firstNumber % secondNumber);
    }

    private static void performPower(Scanner sc) {
        double base = readDouble(sc, "Enter base number: ");
        double exponent = readDouble(sc, "Enter exponent: ");
        System.out.printf("Result: %.2f%n", Math.pow(base, exponent));
    }

    private static int readInt(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            if (sc.hasNextInt()) {
                int value = sc.nextInt();
                sc.nextLine();
                return value;
            }
            System.out.println("Please enter a valid integer.");
            sc.next();
        }
    }

    private static double readDouble(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            if (sc.hasNextDouble()) {
                double value = sc.nextDouble();
                sc.nextLine();
                return value;
            }
            System.out.println("Please enter a valid number.");
            sc.next();
        }
    }
}
