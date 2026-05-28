// Write a program to Find factorial of a number. 

import java.util.Scanner;

public class factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        int fact = 1;

        // Calculate factorial
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }

        // Display result
        System.out.println("Factorial of " + n + " is: " + fact);

        sc.close();
    }
}