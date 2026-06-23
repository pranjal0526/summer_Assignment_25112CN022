// Write a program to check anagram strings.

import java.util.Arrays;
import java.util.Scanner;

public class CheckAnagramStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String firstString = sc.nextLine().replace(" ", "").toLowerCase();

        System.out.print("Enter second string: ");
        String secondString = sc.nextLine().replace(" ", "").toLowerCase();

        if (firstString.length() != secondString.length()) {
            System.out.println("The strings are not anagrams.");
            sc.close();
            return;
        }

        char[] firstCharacters = firstString.toCharArray();
        char[] secondCharacters = secondString.toCharArray();

        Arrays.sort(firstCharacters);
        Arrays.sort(secondCharacters);

        if (Arrays.equals(firstCharacters, secondCharacters)) {
            System.out.println("The strings are anagrams.");
        } else {
            System.out.println("The strings are not anagrams.");
        }

        sc.close();
    }
}
