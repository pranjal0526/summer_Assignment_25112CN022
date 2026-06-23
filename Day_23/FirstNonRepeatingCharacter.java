// Write a program to find first non-repeating character.

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        LinkedHashMap<Character, Integer> frequencyMap = new LinkedHashMap<>();

        for (char ch : input.toCharArray()) {
            if (ch != ' ') {
                frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
            }
        }

        char firstNonRepeatingCharacter = '\0';

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == 1) {
                firstNonRepeatingCharacter = entry.getKey();
                break;
            }
        }

        if (firstNonRepeatingCharacter != '\0') {
            System.out.println("First non-repeating character: " + firstNonRepeatingCharacter);
        } else {
            System.out.println("No non-repeating character found.");
        }

        sc.close();
    }
}
