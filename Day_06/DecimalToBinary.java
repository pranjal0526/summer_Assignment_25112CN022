// Write a program to Convert decimal to binary.

import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a decimal number: ");
        int num = sc.nextInt();

        int binary = 0;
        int place = 1;

        while (num > 0) {
            int remainder = num % 2;
            binary = binary + (remainder * place);
            place *= 10;
            num /= 2;
        }

        System.out.println("Binary number = " + binary);

        sc.close();
    }
}