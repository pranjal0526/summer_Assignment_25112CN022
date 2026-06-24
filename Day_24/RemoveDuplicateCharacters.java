// Write a program to remove duplicate characters.

import java.util.Scanner;

public class RemoveDuplicateCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char currentCharacter = input.charAt(i);

            if (result.indexOf(String.valueOf(currentCharacter)) == -1) {
                result.append(currentCharacter);
            }
        }

        System.out.println("String after removing duplicate characters: " + result);

        sc.close();
    }
}
