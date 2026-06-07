// Write a program to Write function for Armstrong.

import java.util.Scanner;

public class FunctionArmstrongCheck {
    public static int countDigits(int num) {
        int count = 0;

        do {
            count++;
            num = num / 10;
        } while (num != 0);

        return count;
    }

    public static int power(int base, int exponent) {
        int result = 1;

        for (int i = 1; i <= exponent; i++) {
            result = result * base;
        }

        return result;
    }

    public static boolean isArmstrong(int num) {
        if (num < 0) {
            return false;
        }

        int digits = countDigits(num);
        int original = num;
        int sum = 0;

        while (num != 0) {
            int digit = num % 10;
            sum = sum + power(digit, digits);
            num = num / 10;
        }

        if (original == 0) {
            sum = 0;
        }

        return sum == original;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        if (isArmstrong(num)) {
            System.out.println(num + " is an Armstrong number.");
        } else {
            System.out.println(num + " is not an Armstrong number.");
        }

        sc.close();
    }
}
