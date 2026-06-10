//  Write a program to perform linear search in array.

import java.util.Scanner;

public class ArrayLinearSearch {
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

        System.out.print("Enter element to search: ");
        int target = sc.nextInt();

        int position = -1;

        for (int i = 0; i < size; i++) {
            if (arr[i] == target) {
                position = i;
                break;
            }
        }

        if (position != -1) {
            System.out.println("Element found at position: " + (position + 1));
        } else {
            System.out.println("Element not found in the array.");
        }

        sc.close();
    }
}
