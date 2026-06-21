// Write a program to find string length without strlen().

import java.util.Scanner;

public class StringLengthWithoutStrlen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        int count = 0;
        for (char ignored : input.toCharArray()) {
            count++;
        }

        System.out.println("Length of the string is: " + count);

        sc.close();
    }
}
