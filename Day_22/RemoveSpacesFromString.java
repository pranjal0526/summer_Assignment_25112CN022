// Write a program to remove spaces from string.

import java.util.Scanner;

public class RemoveSpacesFromString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String stringWithoutSpaces = "";

        for (char ch : input.toCharArray()) {
            if (ch != ' ') {
                stringWithoutSpaces += ch;
            }
        }

        System.out.println("String after removing spaces: " + stringWithoutSpaces);

        sc.close();
    }
}
