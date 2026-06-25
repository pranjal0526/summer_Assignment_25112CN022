// Write a program to find common characters in strings.

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class CommonCharactersInStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first string: ");
        String firstString = sc.nextLine().toLowerCase();

        System.out.print("Enter the second string: ");
        String secondString = sc.nextLine().toLowerCase();

        Set<Character> secondStringCharacters = new LinkedHashSet<>();
        Set<Character> commonCharacters = new LinkedHashSet<>();

        for (int i = 0; i < secondString.length(); i++) {
            char currentCharacter = secondString.charAt(i);
            if (!Character.isWhitespace(currentCharacter)) {
                secondStringCharacters.add(currentCharacter);
            }
        }

        for (int i = 0; i < firstString.length(); i++) {
            char currentCharacter = firstString.charAt(i);
            if (!Character.isWhitespace(currentCharacter) && secondStringCharacters.contains(currentCharacter)) {
                commonCharacters.add(currentCharacter);
            }
        }

        if (commonCharacters.isEmpty()) {
            System.out.println("No common characters found.");
        } else {
            System.out.print("Common characters are: ");
            for (char character : commonCharacters) {
                System.out.print(character + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
