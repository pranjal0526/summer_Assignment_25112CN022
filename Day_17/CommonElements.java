//  Write a program to find common elements.

import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of first array: ");
        int size1 = sc.nextInt();

        System.out.print("Enter size of second array: ");
        int size2 = sc.nextInt();

        System.out.print("Enter size of third array: ");
        int size3 = sc.nextInt();

        if (size1 <= 0 || size2 <= 0 || size3 <= 0) {
            System.out.println("Array sizes must be greater than 0.");
            sc.close();
            return;
        }

        int[] arr1 = new int[size1];
        int[] arr2 = new int[size2];
        int[] arr3 = new int[size3];
        int minSize = size1;

        if (size2 < minSize) {
            minSize = size2;
        }

        if (size3 < minSize) {
            minSize = size3;
        }

        int[] commonArray = new int[minSize];

        System.out.println("Enter elements of first array:");
        for (int i = 0; i < size1; i++) {
            arr1[i] = sc.nextInt();
        }

        System.out.println("Enter elements of second array:");
        for (int i = 0; i < size2; i++) {
            arr2[i] = sc.nextInt();
        }

        System.out.println("Enter elements of third array:");
        for (int i = 0; i < size3; i++) {
            arr3[i] = sc.nextInt();
        }

        int commonCount = 0;

        for (int i = 0; i < size1; i++) {
            boolean isPresentInSecond = false;
            boolean isPresentInThird = false;
            boolean isAlreadyAdded = false;

            for (int j = 0; j < size2; j++) {
                if (arr1[i] == arr2[j]) {
                    isPresentInSecond = true;
                    break;
                }
            }

            for (int j = 0; j < size3; j++) {
                if (arr1[i] == arr3[j]) {
                    isPresentInThird = true;
                    break;
                }
            }

            for (int j = 0; j < commonCount; j++) {
                if (arr1[i] == commonArray[j]) {
                    isAlreadyAdded = true;
                    break;
                }
            }

            if (isPresentInSecond && isPresentInThird && !isAlreadyAdded) {
                commonArray[commonCount] = arr1[i];
                commonCount++;
            }
        }

        if (commonCount == 0) {
            System.out.println("No common elements found.");
        } else {
            System.out.println("Common elements are:");
            for (int i = 0; i < commonCount; i++) {
                System.out.print(commonArray[i] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
