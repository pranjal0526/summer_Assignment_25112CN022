//  Write a program to Recursive reverse number.

import java.util.Scanner;

public class RecursiveReverseNumber {
    public static int reverseNumber(int num, int reversed) {
        if (num == 0) {
            return reversed;
        }
        return reverseNumber(num / 10, reversed * 10 + (num % 10));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int value = Math.abs(num);
        int reversed = reverseNumber(value, 0);

        if (num < 0) {
            reversed = -reversed;
        }

        System.out.println("Reversed number is: " + reversed);

        sc.close();
    }
}
