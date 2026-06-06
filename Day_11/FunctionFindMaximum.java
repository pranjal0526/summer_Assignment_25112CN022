//  Write a program to Write function to find maximum.

import java.util.Scanner;

public class FunctionFindMaximum {
    public static int findMaximum(int first, int second, int third) {
        int max = first;

        if (second > max) {
            max = second;
        }

        if (third > max) {
            max = third;
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int first = sc.nextInt();

        System.out.print("Enter second number: ");
        int second = sc.nextInt();

        System.out.print("Enter third number: ");
        int third = sc.nextInt();

        int max = findMaximum(first, second, third);

        System.out.println("Maximum number is: " + max);

        sc.close();
    }
}
