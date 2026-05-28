// Write a program to Count digits in a number.

import java.util.Scanner;

public class CountDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int count = 0;

        // Count digits
        while (num != 0) {
            num = num / 10;
            count++;
        }

        // Display result
        System.out.println("Number of digits: " + count);

        sc.close();
    }
}