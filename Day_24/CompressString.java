// Write a program to compress a string.

import java.util.Scanner;

public class CompressString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        if (input.length() == 0) {
            System.out.println("Compressed string: ");
            sc.close();
            return;
        }

        StringBuilder compressedString = new StringBuilder();
        int count = 1;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                compressedString.append(input.charAt(i - 1)).append(count);
                count = 1;
            }
        }

        compressedString.append(input.charAt(input.length() - 1)).append(count);

        System.out.println("Compressed string: " + compressedString);

        sc.close();
    }
}
