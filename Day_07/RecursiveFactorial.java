//  Write a program to Recursive factorial.

import java.util.Scanner;

public class RecursiveFactorial {
    public static long findFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * findFactorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a non-negative number: ");
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
        } else {
            long answer = findFactorial(n);
            System.out.println("Factorial of " + n + " is: " + answer);
        }

        sc.close();
    }
}
