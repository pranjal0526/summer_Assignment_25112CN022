//  Write a program to find frequency of an element in array.

import java.util.Scanner;

public class ArrayElementFrequency {
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

        System.out.print("Enter element to find frequency: ");
        int target = sc.nextInt();

        int count = 0;

        for (int i = 0; i < size; i++) {
            if (arr[i] == target) {
                count++;
            }
        }

        System.out.println("Frequency of " + target + " is: " + count);

        sc.close();
    }
}
