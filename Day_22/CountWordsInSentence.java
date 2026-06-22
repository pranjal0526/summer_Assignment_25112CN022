// Write a program to count words in a sentence.

import java.util.Scanner;

public class CountWordsInSentence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String input = sc.nextLine().trim();

        int wordCount = 0;

        if (!input.isEmpty()) {
            String[] words = input.split("\\s+");
            wordCount = words.length;
        }

        System.out.println("Number of words in the sentence: " + wordCount);

        sc.close();
    }
}
