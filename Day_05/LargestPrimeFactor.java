// Write a program to Find largest prime factor.

import java.util.Scanner;

public class LargestPrimeFactor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        long num = sc.nextLong();

        long largestPrimeFactor = 1;

        for (long i = 2; i <= num; i++) {
            while (num % i == 0) {
                largestPrimeFactor = i;
                num = num / i;
            }
        }

        System.out.println("Largest Prime Factor = " + largestPrimeFactor);

        sc.close();
    }
}