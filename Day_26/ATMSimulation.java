// Write a program to create ATM simulation.

import java.util.Scanner;

public class ATMSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double balance = 10000.0;
        int correctPin = 1234;
        boolean isAuthenticated = false;

        System.out.println("Welcome to the ATM.");

        for (int attempts = 1; attempts <= 3; attempts++) {
            System.out.print("Enter your 4-digit PIN: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid PIN. Please enter digits only.");
                sc.next();
                continue;
            }

            int enteredPin = sc.nextInt();

            if (enteredPin == correctPin) {
                isAuthenticated = true;
                break;
            }

            System.out.println("Incorrect PIN. Attempts remaining: " + (3 - attempts));
        }

        if (!isAuthenticated) {
            System.out.println("Too many incorrect attempts. Access denied.");
            sc.close();
            return;
        }

        int choice = 0;

        do {
            System.out.println();
            System.out.println("ATM Menu");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Please enter a valid menu option.");
                sc.next();
                continue;
            }

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.printf("Current balance: Rs. %.2f%n", balance);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    if (!sc.hasNextDouble()) {
                        System.out.println("Please enter a valid amount.");
                        sc.next();
                        break;
                    }

                    double depositAmount = sc.nextDouble();

                    if (depositAmount <= 0) {
                        System.out.println("Deposit amount must be greater than 0.");
                    } else {
                        balance += depositAmount;
                        System.out.printf("Deposit successful. Updated balance: Rs. %.2f%n", balance);
                    }
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    if (!sc.hasNextDouble()) {
                        System.out.println("Please enter a valid amount.");
                        sc.next();
                        break;
                    }

                    double withdrawAmount = sc.nextDouble();

                    if (withdrawAmount <= 0) {
                        System.out.println("Withdrawal amount must be greater than 0.");
                    } else if (withdrawAmount > balance) {
                        System.out.println("Insufficient balance.");
                    } else {
                        balance -= withdrawAmount;
                        System.out.printf("Withdrawal successful. Updated balance: Rs. %.2f%n", balance);
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select between 1 and 4.");
            }
        } while (choice != 4);

        sc.close();
    }
}
