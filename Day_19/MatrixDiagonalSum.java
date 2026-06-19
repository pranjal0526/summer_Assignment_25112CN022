// Write a program to find diagonal sum of a matrix.

import java.util.Scanner;

public class MatrixDiagonalSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        if (rows <= 0 || cols <= 0) {
            System.out.println("Matrix dimensions must be greater than 0.");
            sc.close();
            return;
        }

        if (rows != cols) {
            System.out.println("Diagonal sum can be found only for a square matrix.");
            sc.close();
            return;
        }

        int[][] matrix = new int[rows][cols];
        int diagonalSum = 0;

        System.out.println("Enter elements of matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < rows; i++) {
            diagonalSum += matrix[i][i];
        }

        System.out.println("Diagonal sum is: " + diagonalSum);

        sc.close();
    }
}
