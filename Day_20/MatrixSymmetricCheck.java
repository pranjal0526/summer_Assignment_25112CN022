// Write a program to check symmetric matrix.

import java.util.Scanner;

public class MatrixSymmetricCheck {
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
            System.out.println("Symmetric check can be done only for a square matrix.");
            sc.close();
            return;
        }

        int[][] matrix = new int[rows][cols];
        boolean isSymmetric = true;

        System.out.println("Enter elements of matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = i + 1; j < cols; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    isSymmetric = false;
                    break;
                }
            }

            if (!isSymmetric) {
                break;
            }
        }

        if (isSymmetric) {
            System.out.println("Matrix is symmetric.");
        } else {
            System.out.println("Matrix is not symmetric.");
        }

        sc.close();
    }
}
