// Write a program to create voting eligibility system.

import java.util.Scanner;

public class VotingEligibilitySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your age: ");
        if (!sc.hasNextInt()) {
            System.out.println("Invalid age. Please enter a whole number.");
            sc.close();
            return;
        }

        int age = sc.nextInt();
        sc.nextLine();

        if (age < 0) {
            System.out.println("Age cannot be negative.");
            sc.close();
            return;
        }

        System.out.print("Are you a citizen? (yes/no): ");
        String citizenInput = sc.nextLine().trim().toLowerCase();

        if (!citizenInput.equals("yes") && !citizenInput.equals("no")
                && !citizenInput.equals("y") && !citizenInput.equals("n")) {
            System.out.println("Please enter yes or no for citizenship.");
            sc.close();
            return;
        }

        boolean isCitizen = citizenInput.equals("yes") || citizenInput.equals("y");

        if (age >= 18 && isCitizen) {
            System.out.println("You are eligible to vote.");
        } else if (age < 18 && isCitizen) {
            System.out.println("You are not eligible to vote because you are under 18.");
        } else if (age >= 18) {
            System.out.println("You are not eligible to vote because citizenship is required.");
        } else {
            System.out.println("You are not eligible to vote because you are under 18 and citizenship is required.");
        }

        sc.close();
    }
}
