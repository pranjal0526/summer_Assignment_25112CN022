// Write a program to find longest word.

import java.util.Scanner;

public class FindLongestWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String input = sc.nextLine().trim();

        if (input.length() == 0) {
            System.out.println("No words found in the sentence.");
            sc.close();
            return;
        }

        String[] words = input.split("\\s+");
        String longestWord = words[0];

        for (int i = 1; i < words.length; i++) {
            if (words[i].length() > longestWord.length()) {
                longestWord = words[i];
            }
        }

        System.out.println("Longest word is: " + longestWord);

        sc.close();
    }
}
