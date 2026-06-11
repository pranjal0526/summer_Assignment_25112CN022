//  Write a program to rotate array right.

import java.util.Scanner;

public class ArrayRotateRight {
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

        System.out.print("Enter number of positions to rotate right: ");
        int positions = sc.nextInt();
        positions = positions % size;
        if (positions < 0) {
            positions = positions + size;
        }

        int[] rotated = new int[size];

        for (int i = 0; i < size; i++) {
            rotated[(i + positions) % size] = arr[i];
        }

        System.out.println("Array after right rotation is:");
        for (int i = 0; i < size; i++) {
            System.out.print(rotated[i] + " ");
        }
        System.out.println();

        sc.close();
    }
}
