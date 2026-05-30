// Write a program to Find nth Fibonacci term.

import java.util.Scanner;

public class NthFibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter position: ");
        int n = sc.nextInt();

        int a = 0;
        int b = 1;

        if (n == 1) {
            System.out.println("Nth Fibonacci Term = " + a);
        } else if (n == 2) {
            System.out.println("Nth Fibonacci Term = " + b);
        } else {
            int term = 0;

            for (int i = 3; i <= n; i++) {
                term = a + b;
                a = b;
                b = term;
            }

            System.out.println("Nth Fibonacci Term = " + term);
        }
    }
}