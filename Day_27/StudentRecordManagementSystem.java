// Write a program to create student record management system.

import java.util.ArrayList;
import java.util.Scanner;

public class StudentRecordManagementSystem {
    static class Student {
        int rollNumber;
        String name;
        int age;
        String course;
        double percentage;

        Student(int rollNumber, String name, int age, String course, double percentage) {
            this.rollNumber = rollNumber;
            this.name = name;
            this.age = age;
            this.course = course;
            this.percentage = percentage;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<Student>();
        int choice;

        System.out.println("Student Record Management System");

        do {
            System.out.println();
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            choice = readInt(sc, "Enter your choice: ");

            switch (choice) {
                case 1:
                    addStudent(sc, students);
                    break;
                case 2:
                    viewStudents(students);
                    break;
                case 3:
                    searchStudent(sc, students);
                    break;
                case 4:
                    updateStudent(sc, students);
                    break;
                case 5:
                    deleteStudent(sc, students);
                    break;
                case 6:
                    System.out.println("Exiting student management system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select between 1 and 6.");
            }
        } while (choice != 6);

        sc.close();
    }

    private static void addStudent(Scanner sc, ArrayList<Student> students) {
        int rollNumber = readInt(sc, "Enter roll number: ");

        if (findStudent(students, rollNumber) != null) {
            System.out.println("Student with this roll number already exists.");
            return;
        }

        String name = readNonEmptyString(sc, "Enter student name: ");
        int age = readInt(sc, "Enter age: ");
        String course = readNonEmptyString(sc, "Enter course: ");
        double percentage = readDouble(sc, "Enter percentage: ");

        if (age <= 0 || percentage < 0 || percentage > 100) {
            System.out.println("Age must be positive and percentage must be between 0 and 100.");
            return;
        }

        students.add(new Student(rollNumber, name, age, course, percentage));
        System.out.println("Student record added successfully.");
    }

    private static void viewStudents(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        System.out.printf("%-12s %-20s %-8s %-18s %-12s%n", "Roll No", "Name", "Age", "Course", "Percentage");
        for (Student student : students) {
            System.out.printf(
                "%-12d %-20s %-8d %-18s %-12.2f%n",
                student.rollNumber,
                student.name,
                student.age,
                student.course,
                student.percentage
            );
        }
    }

    private static void searchStudent(Scanner sc, ArrayList<Student> students) {
        int rollNumber = readInt(sc, "Enter roll number to search: ");
        Student student = findStudent(students, rollNumber);

        if (student == null) {
            System.out.println("Student record not found.");
            return;
        }

        System.out.println("Student found:");
        System.out.println("Roll Number: " + student.rollNumber);
        System.out.println("Name: " + student.name);
        System.out.println("Age: " + student.age);
        System.out.println("Course: " + student.course);
        System.out.printf("Percentage: %.2f%n", student.percentage);
    }

    private static void updateStudent(Scanner sc, ArrayList<Student> students) {
        int rollNumber = readInt(sc, "Enter roll number to update: ");
        Student student = findStudent(students, rollNumber);

        if (student == null) {
            System.out.println("Student record not found.");
            return;
        }

        String name = readNonEmptyString(sc, "Enter new name: ");
        int age = readInt(sc, "Enter new age: ");
        String course = readNonEmptyString(sc, "Enter new course: ");
        double percentage = readDouble(sc, "Enter new percentage: ");

        if (age <= 0 || percentage < 0 || percentage > 100) {
            System.out.println("Age must be positive and percentage must be between 0 and 100.");
            return;
        }

        student.name = name;
        student.age = age;
        student.course = course;
        student.percentage = percentage;
        System.out.println("Student record updated successfully.");
    }

    private static void deleteStudent(Scanner sc, ArrayList<Student> students) {
        int rollNumber = readInt(sc, "Enter roll number to delete: ");
        Student student = findStudent(students, rollNumber);

        if (student == null) {
            System.out.println("Student record not found.");
            return;
        }

        students.remove(student);
        System.out.println("Student record deleted successfully.");
    }

    private static Student findStudent(ArrayList<Student> students, int rollNumber) {
        for (Student student : students) {
            if (student.rollNumber == rollNumber) {
                return student;
            }
        }
        return null;
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

    private static double readDouble(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            if (sc.hasNextDouble()) {
                double value = sc.nextDouble();
                sc.nextLine();
                return value;
            }
            System.out.println("Please enter a valid number.");
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
