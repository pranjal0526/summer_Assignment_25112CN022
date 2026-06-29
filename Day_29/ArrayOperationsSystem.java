// Write a program to create menu-driven array operations system.

import java.util.Scanner;

public class ArrayOperationsSystem {
    private static final int MAX_SIZE = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[MAX_SIZE];
        int size = 0;
        int choice;

        System.out.println("Menu-Driven Array Operations System");

        do {
            System.out.println();
            System.out.println("1. Create Array");
            System.out.println("2. Display Array");
            System.out.println("3. Insert Element");
            System.out.println("4. Delete Element");
            System.out.println("5. Search Element");
            System.out.println("6. Update Element");
            System.out.println("7. Sort Array");
            System.out.println("8. Reverse Array");
            System.out.println("9. Find Sum and Average");
            System.out.println("10. Find Largest and Smallest");
            System.out.println("11. Exit");

            choice = readInt(sc, "Enter your choice: ");

            switch (choice) {
                case 1:
                    size = createArray(sc, array);
                    break;
                case 2:
                    displayArray(array, size);
                    break;
                case 3:
                    size = insertElement(sc, array, size);
                    break;
                case 4:
                    size = deleteElement(sc, array, size);
                    break;
                case 5:
                    searchElement(sc, array, size);
                    break;
                case 6:
                    updateElement(sc, array, size);
                    break;
                case 7:
                    sortArray(array, size);
                    break;
                case 8:
                    reverseArray(array, size);
                    break;
                case 9:
                    findSumAndAverage(array, size);
                    break;
                case 10:
                    findLargestAndSmallest(array, size);
                    break;
                case 11:
                    System.out.println("Exiting array operations system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select between 1 and 11.");
            }
        } while (choice != 11);

        sc.close();
    }

    private static int createArray(Scanner sc, int[] array) {
        int size;

        while (true) {
            size = readInt(sc, "Enter number of elements (1 to 100): ");
            if (size >= 1 && size <= MAX_SIZE) {
                break;
            }
            System.out.println("Size must be between 1 and 100.");
        }

        for (int i = 0; i < size; i++) {
            array[i] = readInt(sc, "Enter element " + (i + 1) + ": ");
        }

        System.out.println("Array created successfully.");
        return size;
    }

    private static void displayArray(int[] array, int size) {
        if (!hasElements(size)) {
            return;
        }

        System.out.print("Array elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i]);
            if (i < size - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    private static int insertElement(Scanner sc, int[] array, int size) {
        if (size == MAX_SIZE) {
            System.out.println("Array is full. Cannot insert more elements.");
            return size;
        }

        if (!hasElements(size)) {
            System.out.println("Create the array first.");
            return size;
        }

        int position;
        while (true) {
            position = readInt(sc, "Enter position to insert (1 to " + (size + 1) + "): ");
            if (position >= 1 && position <= size + 1) {
                break;
            }
            System.out.println("Please enter a valid position.");
        }

        int element = readInt(sc, "Enter element to insert: ");

        for (int i = size; i >= position; i--) {
            array[i] = array[i - 1];
        }

        array[position - 1] = element;
        System.out.println("Element inserted successfully.");
        return size + 1;
    }

    private static int deleteElement(Scanner sc, int[] array, int size) {
        if (!hasElements(size)) {
            return size;
        }

        int position;
        while (true) {
            position = readInt(sc, "Enter position to delete (1 to " + size + "): ");
            if (position >= 1 && position <= size) {
                break;
            }
            System.out.println("Please enter a valid position.");
        }

        int deletedElement = array[position - 1];

        for (int i = position - 1; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        System.out.println("Deleted element: " + deletedElement);
        System.out.println("Element deleted successfully.");
        return size - 1;
    }

    private static void searchElement(Scanner sc, int[] array, int size) {
        if (!hasElements(size)) {
            return;
        }

        int target = readInt(sc, "Enter element to search: ");

        for (int i = 0; i < size; i++) {
            if (array[i] == target) {
                System.out.println("Element found at position " + (i + 1) + ".");
                return;
            }
        }

        System.out.println("Element not found in the array.");
    }

    private static void updateElement(Scanner sc, int[] array, int size) {
        if (!hasElements(size)) {
            return;
        }

        int position;
        while (true) {
            position = readInt(sc, "Enter position to update (1 to " + size + "): ");
            if (position >= 1 && position <= size) {
                break;
            }
            System.out.println("Please enter a valid position.");
        }

        int newValue = readInt(sc, "Enter new value: ");
        array[position - 1] = newValue;
        System.out.println("Element updated successfully.");
    }

    private static void sortArray(int[] array, int size) {
        if (!hasElements(size)) {
            return;
        }

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        System.out.println("Array sorted in ascending order.");
    }

    private static void reverseArray(int[] array, int size) {
        if (!hasElements(size)) {
            return;
        }

        int start = 0;
        int end = size - 1;

        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }

        System.out.println("Array reversed successfully.");
    }

    private static void findSumAndAverage(int[] array, int size) {
        if (!hasElements(size)) {
            return;
        }

        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += array[i];
        }

        double average = (double) sum / size;
        System.out.println("Sum of elements: " + sum);
        System.out.printf("Average of elements: %.2f%n", average);
    }

    private static void findLargestAndSmallest(int[] array, int size) {
        if (!hasElements(size)) {
            return;
        }

        int largest = array[0];
        int smallest = array[0];

        for (int i = 1; i < size; i++) {
            if (array[i] > largest) {
                largest = array[i];
            }
            if (array[i] < smallest) {
                smallest = array[i];
            }
        }

        System.out.println("Largest element: " + largest);
        System.out.println("Smallest element: " + smallest);
    }

    private static boolean hasElements(int size) {
        if (size <= 0) {
            System.out.println("Array is empty. Create the array first.");
            return false;
        }
        return true;
    }

    private static int readInt(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            if (sc.hasNextInt()) {
                int value = sc.nextInt();
                sc.nextLine();
                return value;
            }
            System.out.println("Please enter a valid integer.");
            sc.next();
        }
    }
}
