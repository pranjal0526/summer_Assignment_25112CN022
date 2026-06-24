// Write a program to check string rotation.

import java.util.Scanner;

public class CheckStringRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first string: ");
        String firstString = sc.nextLine().toLowerCase();

        System.out.print("Enter the second string: ");
        String secondString = sc.nextLine().toLowerCase();

        if (firstString.length() != secondString.length()) {
            System.out.println("The second string is not a rotation of the first string.");
            sc.close();
            return;
        }

        String combinedString = firstString + firstString;

        if (combinedString.contains(secondString)) {
            System.out.println("The second string is a rotation of the first string.");
        } else {
            System.out.println("The second string is not a rotation of the first string.");
        }

        sc.close();
    }
}
