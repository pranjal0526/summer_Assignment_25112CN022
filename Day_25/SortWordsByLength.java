// Write a program to sort words by length.

import java.util.Scanner;

public class SortWordsByLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine().trim();

        if (sentence.isEmpty()) {
            System.out.println("Sentence cannot be empty.");
            sc.close();
            return;
        }

        String[] words = sentence.split("\\s+");

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words.length - i - 1; j++) {
                if (words[j].length() > words[j + 1].length()
                        || (words[j].length() == words[j + 1].length()
                        && words[j].compareToIgnoreCase(words[j + 1]) > 0)) {
                    String temp = words[j];
                    words[j] = words[j + 1];
                    words[j + 1] = temp;
                }
            }
        }

        System.out.println("Words sorted by length are:");
        for (int i = 0; i < words.length; i++) {
            System.out.print(words[i] + " ");
        }
        System.out.println();

        sc.close();
    }
}
