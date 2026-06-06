// Write a program to Write function to find sum of two numbers.

import java.util.Scanner;

public class FunctionSumOfTwoNumbers {
    public static int addNumbers(int first, int second) {
        return first + second;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int first = sc.nextInt();

        System.out.print("Enter second number: ");
        int second = sc.nextInt();

        int sum = addNumbers(first, second);

        System.out.println("Sum is: " + sum);

        sc.close();
    }
}
