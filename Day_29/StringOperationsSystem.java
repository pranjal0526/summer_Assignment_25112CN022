// Write a program to create menu-driven string operations system.

import java.util.Scanner;

public class StringOperationsSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String currentString = "";
        int choice;

        System.out.println("Menu-Driven String Operations System");

        do {
            System.out.println();
            System.out.println("1. Enter New String");
            System.out.println("2. Display Current String");
            System.out.println("3. Find Length");
            System.out.println("4. Reverse String");
            System.out.println("5. Check Palindrome");
            System.out.println("6. Convert to Uppercase");
            System.out.println("7. Convert to Lowercase");
            System.out.println("8. Count Vowels and Consonants");
            System.out.println("9. Search Character");
            System.out.println("10. Remove Spaces");
            System.out.println("11. Exit");

            choice = readInt(sc, "Enter your choice: ");

            switch (choice) {
                case 1:
                    currentString = readNonEmptyString(sc, "Enter a string: ");
                    System.out.println("String saved successfully.");
                    break;
                case 2:
                    if (isStringAvailable(currentString)) {
                        System.out.println("Current string: " + currentString);
                    }
                    break;
                case 3:
                    if (isStringAvailable(currentString)) {
                        System.out.println("Length of string: " + currentString.length());
                    }
                    break;
                case 4:
                    if (isStringAvailable(currentString)) {
                        System.out.println("Reversed string: " + reverseString(currentString));
                    }
                    break;
                case 5:
                    if (isStringAvailable(currentString)) {
                        if (isPalindrome(currentString)) {
                            System.out.println("The string is a palindrome.");
                        } else {
                            System.out.println("The string is not a palindrome.");
                        }
                    }
                    break;
                case 6:
                    if (isStringAvailable(currentString)) {
                        currentString = currentString.toUpperCase();
                        System.out.println("Updated string: " + currentString);
                    }
                    break;
                case 7:
                    if (isStringAvailable(currentString)) {
                        currentString = currentString.toLowerCase();
                        System.out.println("Updated string: " + currentString);
                    }
                    break;
                case 8:
                    if (isStringAvailable(currentString)) {
                        countVowelsAndConsonants(currentString);
                    }
                    break;
                case 9:
                    if (isStringAvailable(currentString)) {
                        searchCharacter(sc, currentString);
                    }
                    break;
                case 10:
                    if (isStringAvailable(currentString)) {
                        currentString = currentString.replace(" ", "");
                        System.out.println("Updated string: " + currentString);
                    }
                    break;
                case 11:
                    System.out.println("Exiting string operations system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select between 1 and 11.");
            }
        } while (choice != 11);

        sc.close();
    }

    private static String reverseString(String text) {
        StringBuilder reversedText = new StringBuilder();

        for (int i = text.length() - 1; i >= 0; i--) {
            reversedText.append(text.charAt(i));
        }

        return reversedText.toString();
    }

    private static boolean isPalindrome(String text) {
        String cleanedText = text.replace(" ", "").toLowerCase();
        int start = 0;
        int end = cleanedText.length() - 1;

        while (start < end) {
            if (cleanedText.charAt(start) != cleanedText.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    private static void countVowelsAndConsonants(String text) {
        int vowelCount = 0;
        int consonantCount = 0;
        String lowercaseText = text.toLowerCase();

        for (int i = 0; i < lowercaseText.length(); i++) {
            char ch = lowercaseText.charAt(i);

            if (Character.isLetter(ch)) {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            }
        }

        System.out.println("Number of vowels: " + vowelCount);
        System.out.println("Number of consonants: " + consonantCount);
    }

    private static void searchCharacter(Scanner sc, String text) {
        System.out.print("Enter character to search: ");
        String input = sc.nextLine();

        if (input.isEmpty()) {
            System.out.println("Input cannot be empty.");
            return;
        }

        char target = input.charAt(0);

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == target) {
                System.out.println("Character found at position " + (i + 1) + ".");
                return;
            }
        }

        System.out.println("Character not found in the string.");
    }

    private static boolean isStringAvailable(String currentString) {
        if (currentString.isEmpty()) {
            System.out.println("No string available. Enter a string first.");
            return false;
        }
        return true;
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

    private static String readNonEmptyString(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String value = sc.nextLine();
            if (!value.trim().isEmpty()) {
                return value;
            }
            System.out.println("Input cannot be empty.");
        }
    }
}
