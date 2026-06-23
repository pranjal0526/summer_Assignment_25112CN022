// Write a program to find maximum occurring character.

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MaximumOccurringCharacter {
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

        if (frequencyMap.isEmpty()) {
            System.out.println("No character found.");
            sc.close();
            return;
        }

        char maximumOccurringCharacter = '\0';
        int maximumFrequency = 0;

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maximumFrequency) {
                maximumFrequency = entry.getValue();
                maximumOccurringCharacter = entry.getKey();
            }
        }

        System.out.println("Maximum occurring character: " + maximumOccurringCharacter);
        System.out.println("Frequency: " + maximumFrequency);

        sc.close();
    }
}
