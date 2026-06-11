//  Write a program to find maximum frequency element.

import java.util.Scanner;

public class ArrayMaximumFrequencyElement {
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

        int maxFrequencyElement = arr[0];
        int maxFrequency = 0;

        for (int i = 0; i < size; i++) {
            int count = 0;

            for (int j = 0; j < size; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            if (count > maxFrequency) {
                maxFrequency = count;
                maxFrequencyElement = arr[i];
            }
        }

        System.out.println("Maximum frequency element: " + maxFrequencyElement);
        System.out.println("Frequency: " + maxFrequency);

        sc.close();
    }
}
