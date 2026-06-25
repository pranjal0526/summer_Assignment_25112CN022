// Write a program to merge two sorted arrays.

import java.util.Scanner;

public class MergeSortedArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of first sorted array: ");
        int size1 = sc.nextInt();

        System.out.print("Enter size of second sorted array: ");
        int size2 = sc.nextInt();

        if (size1 < 0 || size2 < 0) {
            System.out.println("Array sizes cannot be negative.");
            sc.close();
            return;
        }

        int[] firstArray = new int[size1];
        int[] secondArray = new int[size2];
        int[] mergedArray = new int[size1 + size2];

        System.out.println("Enter elements of first sorted array:");
        for (int i = 0; i < size1; i++) {
            firstArray[i] = sc.nextInt();
        }

        System.out.println("Enter elements of second sorted array:");
        for (int i = 0; i < size2; i++) {
            secondArray[i] = sc.nextInt();
        }

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < size1 && j < size2) {
            if (firstArray[i] <= secondArray[j]) {
                mergedArray[k] = firstArray[i];
                i++;
            } else {
                mergedArray[k] = secondArray[j];
                j++;
            }
            k++;
        }

        while (i < size1) {
            mergedArray[k] = firstArray[i];
            i++;
            k++;
        }

        while (j < size2) {
            mergedArray[k] = secondArray[j];
            j++;
            k++;
        }

        System.out.println("Merged sorted array is:");
        for (int index = 0; index < mergedArray.length; index++) {
            System.out.print(mergedArray[index] + " ");
        }
        System.out.println();

        sc.close();
    }
}
