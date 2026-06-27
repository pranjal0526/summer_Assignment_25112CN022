// Write a program to create marksheet generation system.

import java.util.ArrayList;
import java.util.Scanner;

public class MarksheetGenerationSystem {
    static class Marksheet {
        int rollNumber;
        String studentName;
        String className;
        int[] marks;

        Marksheet(int rollNumber, String studentName, String className, int[] marks) {
            this.rollNumber = rollNumber;
            this.studentName = studentName;
            this.className = className;
            this.marks = marks;
        }

        int getTotalMarks() {
            int total = 0;
            for (int mark : marks) {
                total += mark;
            }
            return total;
        }

        double getPercentage() {
            return getTotalMarks() / (double) marks.length;
        }

        boolean isPass() {
            for (int mark : marks) {
                if (mark < 33) {
                    return false;
                }
            }
            return true;
        }

        String getGrade() {
            double percentage = getPercentage();

            if (!isPass()) {
                return "F";
            } else if (percentage >= 90) {
                return "A+";
            } else if (percentage >= 80) {
                return "A";
            } else if (percentage >= 70) {
                return "B";
            } else if (percentage >= 60) {
                return "C";
            } else if (percentage >= 50) {
                return "D";
            } else {
                return "E";
            }
        }
    }

    private static final String[] SUBJECTS = {
        "English",
        "Mathematics",
        "Science",
        "Computer",
        "Social Science"
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Marksheet> marksheets = new ArrayList<Marksheet>();
        int choice;

        System.out.println("Marksheet Generation System");

        do {
            System.out.println();
            System.out.println("1. Generate Marksheet");
            System.out.println("2. View All Marksheets");
            System.out.println("3. Search Marksheet");
            System.out.println("4. Update Marksheet");
            System.out.println("5. Delete Marksheet");
            System.out.println("6. Exit");

            choice = readInt(sc, "Enter your choice: ");

            switch (choice) {
                case 1:
                    addMarksheet(sc, marksheets);
                    break;
                case 2:
                    viewMarksheets(marksheets);
                    break;
                case 3:
                    searchMarksheet(sc, marksheets);
                    break;
                case 4:
                    updateMarksheet(sc, marksheets);
                    break;
                case 5:
                    deleteMarksheet(sc, marksheets);
                    break;
                case 6:
                    System.out.println("Exiting marksheet generation system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select between 1 and 6.");
            }
        } while (choice != 6);

        sc.close();
    }

    private static void addMarksheet(Scanner sc, ArrayList<Marksheet> marksheets) {
        int rollNumber = readInt(sc, "Enter roll number: ");

        if (findMarksheet(marksheets, rollNumber) != null) {
            System.out.println("Marksheet for this roll number already exists.");
            return;
        }

        String studentName = readNonEmptyString(sc, "Enter student name: ");
        String className = readNonEmptyString(sc, "Enter class: ");
        int[] marks = readMarks(sc);

        if (marks == null) {
            return;
        }

        marksheets.add(new Marksheet(rollNumber, studentName, className, marks));
        System.out.println("Marksheet generated successfully.");
    }

    private static void viewMarksheets(ArrayList<Marksheet> marksheets) {
        if (marksheets.isEmpty()) {
            System.out.println("No marksheets available.");
            return;
        }

        for (Marksheet marksheet : marksheets) {
            printMarksheet(marksheet);
        }
    }

    private static void searchMarksheet(Scanner sc, ArrayList<Marksheet> marksheets) {
        int rollNumber = readInt(sc, "Enter roll number to search: ");
        Marksheet marksheet = findMarksheet(marksheets, rollNumber);

        if (marksheet == null) {
            System.out.println("Marksheet not found.");
            return;
        }

        printMarksheet(marksheet);
    }

    private static void updateMarksheet(Scanner sc, ArrayList<Marksheet> marksheets) {
        int rollNumber = readInt(sc, "Enter roll number to update: ");
        Marksheet marksheet = findMarksheet(marksheets, rollNumber);

        if (marksheet == null) {
            System.out.println("Marksheet not found.");
            return;
        }

        String studentName = readNonEmptyString(sc, "Enter new student name: ");
        String className = readNonEmptyString(sc, "Enter new class: ");
        int[] marks = readMarks(sc);

        if (marks == null) {
            return;
        }

        marksheet.studentName = studentName;
        marksheet.className = className;
        marksheet.marks = marks;
        System.out.println("Marksheet updated successfully.");
    }

    private static void deleteMarksheet(Scanner sc, ArrayList<Marksheet> marksheets) {
        int rollNumber = readInt(sc, "Enter roll number to delete: ");
        Marksheet marksheet = findMarksheet(marksheets, rollNumber);

        if (marksheet == null) {
            System.out.println("Marksheet not found.");
            return;
        }

        marksheets.remove(marksheet);
        System.out.println("Marksheet deleted successfully.");
    }

    private static void printMarksheet(Marksheet marksheet) {
        System.out.println();
        System.out.println("Student Marksheet");
        System.out.println("Roll Number  : " + marksheet.rollNumber);
        System.out.println("Student Name : " + marksheet.studentName);
        System.out.println("Class        : " + marksheet.className);
        System.out.println();
        System.out.printf("%-18s %-10s%n", "Subject", "Marks");

        for (int i = 0; i < SUBJECTS.length; i++) {
            System.out.printf("%-18s %-10d%n", SUBJECTS[i], marksheet.marks[i]);
        }

        System.out.println();
        System.out.println("Total Marks : " + marksheet.getTotalMarks() + "/" + (marksheet.marks.length * 100));
        System.out.printf("Percentage  : %.2f%n", marksheet.getPercentage());
        System.out.println("Result      : " + (marksheet.isPass() ? "Pass" : "Fail"));
        System.out.println("Grade       : " + marksheet.getGrade());
    }

    private static Marksheet findMarksheet(ArrayList<Marksheet> marksheets, int rollNumber) {
        for (Marksheet marksheet : marksheets) {
            if (marksheet.rollNumber == rollNumber) {
                return marksheet;
            }
        }
        return null;
    }

    private static int[] readMarks(Scanner sc) {
        int[] marks = new int[SUBJECTS.length];

        for (int i = 0; i < SUBJECTS.length; i++) {
            marks[i] = readInt(sc, "Enter marks in " + SUBJECTS[i] + ": ");

            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Marks must be between 0 and 100.");
                return null;
            }
        }

        return marks;
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

    private static String readNonEmptyString(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String value = sc.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("Input cannot be empty.");
        }
    }
}
