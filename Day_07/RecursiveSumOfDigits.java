//  Write a program to Recursive sum of digits.

import java.util.Scanner;

public class RecursiveSumOfDigits {
    public static int sumOfDigits(int num) {
        if (num == 0) {
            return 0;
        }
        return (num % 10) + sumOfDigits(num / 10);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int value = Math.abs(num);
        int sum = sumOfDigits(value);

        System.out.println("Sum of digits is: " + sum);

        sc.close();
    }
}
