//  Write a program to find missing number in array.

import java.util.Scanner;

public class ArrayMissingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int size = sc.nextInt();

        if (size <= 0) {
            System.out.println("Array size must be greater than 0.");
            sc.close();
            return;
        }

        int[] arr = new int[size];

        System.out.println("Enter array elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        int expectedSum = (size + 1) * (size + 2) / 2;
        int actualSum = 0;

        for (int i = 0; i < size; i++) {
            actualSum = actualSum + arr[i];
        }

        int missingNumber = expectedSum - actualSum;

        System.out.println("Missing number is: " + missingNumber);

        sc.close();
    }
}
