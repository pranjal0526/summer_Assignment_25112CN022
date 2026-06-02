//  Write a program to Recursive Fibonacci.

import java.util.Scanner;

public class RecursiveFibonacci {
    public static int fibonacciTerm(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciTerm(n - 1) + fibonacciTerm(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of terms: ");
        int terms = sc.nextInt();

        if (terms <= 0) {
            System.out.println("Please enter a positive number of terms.");
        } else {
            System.out.print("Fibonacci series: ");
            for (int i = 0; i < terms; i++) {
                System.out.print(fibonacciTerm(i) + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
