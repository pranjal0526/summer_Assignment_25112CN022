// Write a program to find first repeating character.

import java.util.HashSet;
import java.util.Scanner;

public class FirstRepeatingCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        HashSet<Character> seenCharacters = new HashSet<>();
        char firstRepeatingCharacter = '\0';

        for (char ch : input.toCharArray()) {
            if (ch == ' ') {
                continue;
            }

            if (seenCharacters.contains(ch)) {
                firstRepeatingCharacter = ch;
                break;
            }

            seenCharacters.add(ch);
        }

        if (firstRepeatingCharacter != '\0') {
            System.out.println("First repeating character: " + firstRepeatingCharacter);
        } else {
            System.out.println("No repeating character found.");
        }

        sc.close();
    }
}
