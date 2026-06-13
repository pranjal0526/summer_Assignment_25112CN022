//  Write a program to find intersection of arrays.

import java.util.Scanner;

public class IntersectionOfArrays {
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
        int[] intersectionArray = new int[size1 < size2 ? size1 : size2];

        System.out.println("Enter elements of first array:");
        for (int i = 0; i < size1; i++) {
            arr1[i] = sc.nextInt();
        }

        System.out.println("Enter elements of second array:");
        for (int i = 0; i < size2; i++) {
            arr2[i] = sc.nextInt();
        }

        int intersectionCount = 0;

        for (int i = 0; i < size1; i++) {
            boolean isPresentInSecond = false;
            boolean isAlreadyAdded = false;

            for (int j = 0; j < size2; j++) {
                if (arr1[i] == arr2[j]) {
                    isPresentInSecond = true;
                    break;
                }
            }

            for (int j = 0; j < intersectionCount; j++) {
                if (arr1[i] == intersectionArray[j]) {
                    isAlreadyAdded = true;
                    break;
                }
            }

            if (isPresentInSecond && !isAlreadyAdded) {
                intersectionArray[intersectionCount] = arr1[i];
                intersectionCount++;
            }
        }

        if (intersectionCount == 0) {
            System.out.println("No common elements found in both arrays.");
        } else {
            System.out.println("Intersection of arrays is:");
            for (int i = 0; i < intersectionCount; i++) {
                System.out.print(intersectionArray[i] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
