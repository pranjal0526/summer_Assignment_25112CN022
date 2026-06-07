// Write a program to Write function for Fibonacci.

import java.util.Scanner;

public class FunctionFibonacciSeries {
    public static int fibonacciTerm(int n) {
        if (n <= 1) {
            return n;
        }

        int first = 0;
        int second = 1;
        int next = 0;

        for (int i = 2; i <= n; i++) {
            next = first + second;
            first = second;
            second = next;
        }

        return second;
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
