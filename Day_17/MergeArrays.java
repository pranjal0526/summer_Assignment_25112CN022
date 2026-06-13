//  Write a program to merge arrays.

import java.util.Scanner;

public class MergeArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of first array: ");
        int size1 = sc.nextInt();

        System.out.print("Enter size of second array: ");
        int size2 = sc.nextInt();

        if (size1 <= 0 || size2 <= 0) {
            System.out.println("Array sizes must be greater than 0.");
            sc.close();
            return;
        }

        int[] arr1 = new int[size1];
        int[] arr2 = new int[size2];
        int[] mergedArray = new int[size1 + size2];

        System.out.println("Enter elements of first array:");
        for (int i = 0; i < size1; i++) {
            arr1[i] = sc.nextInt();
        }

        System.out.println("Enter elements of second array:");
        for (int i = 0; i < size2; i++) {
            arr2[i] = sc.nextInt();
        }

        int index = 0;

        for (int i = 0; i < size1; i++) {
            mergedArray[index] = arr1[i];
            index++;
        }

        for (int i = 0; i < size2; i++) {
            mergedArray[index] = arr2[i];
            index++;
        }

        System.out.println("Merged array is:");
        for (int i = 0; i < mergedArray.length; i++) {
            System.out.print(mergedArray[i] + " ");
        }
        System.out.println();

        sc.close();
    }
}
