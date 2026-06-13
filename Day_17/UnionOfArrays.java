//  Write a program to find union of arrays.

import java.util.Scanner;

public class UnionOfArrays {
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
        int[] unionArray = new int[size1 + size2];

        System.out.println("Enter elements of first array:");
        for (int i = 0; i < size1; i++) {
            arr1[i] = sc.nextInt();
        }

        System.out.println("Enter elements of second array:");
        for (int i = 0; i < size2; i++) {
            arr2[i] = sc.nextInt();
        }

        int unionCount = 0;

        for (int i = 0; i < size1; i++) {
            boolean isDuplicate = false;

            for (int j = 0; j < unionCount; j++) {
                if (arr1[i] == unionArray[j]) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                unionArray[unionCount] = arr1[i];
                unionCount++;
            }
        }

        for (int i = 0; i < size2; i++) {
            boolean isDuplicate = false;

            for (int j = 0; j < unionCount; j++) {
                if (arr2[i] == unionArray[j]) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                unionArray[unionCount] = arr2[i];
                unionCount++;
            }
        }

        System.out.println("Union of arrays is:");
        for (int i = 0; i < unionCount; i++) {
            System.out.print(unionArray[i] + " ");
        }
        System.out.println();

        sc.close();
    }
}
