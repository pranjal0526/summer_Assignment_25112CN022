// Write a program to multiply matrices.

import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows for first matrix: ");
        int rowsFirst = sc.nextInt();

        System.out.print("Enter number of columns for first matrix: ");
        int colsFirst = sc.nextInt();

        System.out.print("Enter number of rows for second matrix: ");
        int rowsSecond = sc.nextInt();

        System.out.print("Enter number of columns for second matrix: ");
        int colsSecond = sc.nextInt();

        if (rowsFirst <= 0 || colsFirst <= 0 || rowsSecond <= 0 || colsSecond <= 0) {
            System.out.println("Matrix dimensions must be greater than 0.");
            sc.close();
            return;
        }

        if (colsFirst != rowsSecond) {
            System.out.println("Matrix multiplication is not possible.");
            sc.close();
            return;
        }

        int[][] firstMatrix = new int[rowsFirst][colsFirst];
        int[][] secondMatrix = new int[rowsSecond][colsSecond];
        int[][] productMatrix = new int[rowsFirst][colsSecond];

        System.out.println("Enter elements of first matrix:");
        for (int i = 0; i < rowsFirst; i++) {
            for (int j = 0; j < colsFirst; j++) {
                firstMatrix[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter elements of second matrix:");
        for (int i = 0; i < rowsSecond; i++) {
            for (int j = 0; j < colsSecond; j++) {
                secondMatrix[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < rowsFirst; i++) {
            for (int j = 0; j < colsSecond; j++) {
                for (int k = 0; k < colsFirst; k++) {
                    productMatrix[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }
            }
        }

        System.out.println("Product of matrices is:");
        for (int i = 0; i < rowsFirst; i++) {
            for (int j = 0; j < colsSecond; j++) {
                System.out.print(productMatrix[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
