// Write a program to Calculate sum of first N natural numbers.

import java.util.Scanner;

public class SumNaturalNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input value of N
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        int sum = 0;

        // Calculate sum
        for (int i = 1; i <= n; i++) {
            sum = sum + i;
        }

        // Display result
        System.out.println("Sum of first " + n + " natural numbers is: " + sum);

        sc.close();
    }
}