// Write a program to Count set bits in a number. 

import java.util.Scanner;

public class CountSetBits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int count = 0;

        while (num > 0) {
            count += num % 2;
            num /= 2;
        }

        System.out.println("Number of set bits = " + count);

        sc.close();
    }
}