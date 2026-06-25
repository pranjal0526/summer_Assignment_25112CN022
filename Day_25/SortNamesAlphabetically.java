// Write a program to sort names alphabetically.

import java.util.Scanner;

public class SortNamesAlphabetically {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of names: ");
        int numberOfNames = sc.nextInt();
        sc.nextLine();

        if (numberOfNames <= 0) {
            System.out.println("Number of names must be greater than 0.");
            sc.close();
            return;
        }

        String[] names = new String[numberOfNames];

        System.out.println("Enter the names:");
        for (int i = 0; i < numberOfNames; i++) {
            names[i] = sc.nextLine();
        }

        for (int i = 0; i < numberOfNames - 1; i++) {
            for (int j = 0; j < numberOfNames - i - 1; j++) {
                if (names[j].compareToIgnoreCase(names[j + 1]) > 0) {
                    String temp = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = temp;
                }
            }
        }

        System.out.println("Names in alphabetical order are:");
        for (int i = 0; i < numberOfNames; i++) {
            System.out.println(names[i]);
        }

        sc.close();
    }
}
