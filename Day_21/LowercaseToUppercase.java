// Write a program to convert lowercase to uppercase.

import java.util.Scanner;

public class LowercaseToUppercase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String upperCaseString = "";

        for (char ch : input.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                upperCaseString += (char) (ch - ('a' - 'A'));
            } else {
                upperCaseString += ch;
            }
        }

        System.out.println("String after converting to uppercase: " + upperCaseString);

        sc.close();
    }
}
