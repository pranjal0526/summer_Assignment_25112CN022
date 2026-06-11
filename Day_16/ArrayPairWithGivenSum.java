//  Write a program to find pair with given sum.

import java.util.Scanner;

public class ArrayPairWithGivenSum {
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

        System.out.print("Enter target sum: ");
        int targetSum = sc.nextInt();

        boolean pairFound = false;

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (arr[i] + arr[j] == targetSum) {
                    System.out.println("Pair found: " + arr[i] + " and " + arr[j]);
                    pairFound = true;
                    break;
                }
            }

            if (pairFound) {
                break;
            }
        }

        if (!pairFound) {
            System.out.println("No pair found with the given sum.");
        }

        sc.close();
    }
}
