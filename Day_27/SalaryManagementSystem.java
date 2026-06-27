// Write a program to create salary management system.

import java.util.ArrayList;
import java.util.Scanner;

public class SalaryManagementSystem {
    static class SalaryRecord {
        int employeeId;
        String employeeName;
        double basicSalary;
        double hra;
        double da;
        double bonus;
        double deductions;

        SalaryRecord(
            int employeeId,
            String employeeName,
            double basicSalary,
            double hra,
            double da,
            double bonus,
            double deductions
        ) {
            this.employeeId = employeeId;
            this.employeeName = employeeName;
            this.basicSalary = basicSalary;
            this.hra = hra;
            this.da = da;
            this.bonus = bonus;
            this.deductions = deductions;
        }

        double getGrossSalary() {
            return basicSalary + hra + da + bonus;
        }

        double getNetSalary() {
            return getGrossSalary() - deductions;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<SalaryRecord> salaryRecords = new ArrayList<SalaryRecord>();
        int choice;

        System.out.println("Salary Management System");

        do {
            System.out.println();
            System.out.println("1. Add Salary Record");
            System.out.println("2. View All Salary Records");
            System.out.println("3. Search Salary Record");
            System.out.println("4. Update Salary Record");
            System.out.println("5. Delete Salary Record");
            System.out.println("6. Exit");

            choice = readInt(sc, "Enter your choice: ");

            switch (choice) {
                case 1:
                    addSalaryRecord(sc, salaryRecords);
                    break;
                case 2:
                    viewSalaryRecords(salaryRecords);
                    break;
                case 3:
                    searchSalaryRecord(sc, salaryRecords);
                    break;
                case 4:
                    updateSalaryRecord(sc, salaryRecords);
                    break;
                case 5:
                    deleteSalaryRecord(sc, salaryRecords);
                    break;
                case 6:
                    System.out.println("Exiting salary management system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select between 1 and 6.");
            }
        } while (choice != 6);

        sc.close();
    }

    private static void addSalaryRecord(Scanner sc, ArrayList<SalaryRecord> salaryRecords) {
        int employeeId = readInt(sc, "Enter employee ID: ");

        if (findSalaryRecord(salaryRecords, employeeId) != null) {
            System.out.println("Salary record for this employee already exists.");
            return;
        }

        String employeeName = readNonEmptyString(sc, "Enter employee name: ");
        double basicSalary = readDouble(sc, "Enter basic salary: ");
        double hra = readDouble(sc, "Enter HRA: ");
        double da = readDouble(sc, "Enter DA: ");
        double bonus = readDouble(sc, "Enter bonus: ");
        double deductions = readDouble(sc, "Enter deductions: ");

        if (!isValidSalaryInput(basicSalary, hra, da, bonus, deductions)) {
            System.out.println("Salary amounts cannot be negative.");
            return;
        }

        salaryRecords.add(new SalaryRecord(employeeId, employeeName, basicSalary, hra, da, bonus, deductions));
        System.out.println("Salary record added successfully.");
    }

    private static void viewSalaryRecords(ArrayList<SalaryRecord> salaryRecords) {
        if (salaryRecords.isEmpty()) {
            System.out.println("No salary records available.");
            return;
        }

        for (SalaryRecord record : salaryRecords) {
            printSalarySlip(record);
        }
    }

    private static void searchSalaryRecord(Scanner sc, ArrayList<SalaryRecord> salaryRecords) {
        int employeeId = readInt(sc, "Enter employee ID to search: ");
        SalaryRecord record = findSalaryRecord(salaryRecords, employeeId);

        if (record == null) {
            System.out.println("Salary record not found.");
            return;
        }

        printSalarySlip(record);
    }

    private static void updateSalaryRecord(Scanner sc, ArrayList<SalaryRecord> salaryRecords) {
        int employeeId = readInt(sc, "Enter employee ID to update: ");
        SalaryRecord record = findSalaryRecord(salaryRecords, employeeId);

        if (record == null) {
            System.out.println("Salary record not found.");
            return;
        }

        String employeeName = readNonEmptyString(sc, "Enter new employee name: ");
        double basicSalary = readDouble(sc, "Enter new basic salary: ");
        double hra = readDouble(sc, "Enter new HRA: ");
        double da = readDouble(sc, "Enter new DA: ");
        double bonus = readDouble(sc, "Enter new bonus: ");
        double deductions = readDouble(sc, "Enter new deductions: ");

        if (!isValidSalaryInput(basicSalary, hra, da, bonus, deductions)) {
            System.out.println("Salary amounts cannot be negative.");
            return;
        }

        record.employeeName = employeeName;
        record.basicSalary = basicSalary;
        record.hra = hra;
        record.da = da;
        record.bonus = bonus;
        record.deductions = deductions;
        System.out.println("Salary record updated successfully.");
    }

    private static void deleteSalaryRecord(Scanner sc, ArrayList<SalaryRecord> salaryRecords) {
        int employeeId = readInt(sc, "Enter employee ID to delete: ");
        SalaryRecord record = findSalaryRecord(salaryRecords, employeeId);

        if (record == null) {
            System.out.println("Salary record not found.");
            return;
        }

        salaryRecords.remove(record);
        System.out.println("Salary record deleted successfully.");
    }

    private static void printSalarySlip(SalaryRecord record) {
        System.out.println();
        System.out.println("Salary Slip");
        System.out.println("Employee ID   : " + record.employeeId);
        System.out.println("Employee Name : " + record.employeeName);
        System.out.printf("Basic Salary  : %.2f%n", record.basicSalary);
        System.out.printf("HRA           : %.2f%n", record.hra);
        System.out.printf("DA            : %.2f%n", record.da);
        System.out.printf("Bonus         : %.2f%n", record.bonus);
        System.out.printf("Gross Salary  : %.2f%n", record.getGrossSalary());
        System.out.printf("Deductions    : %.2f%n", record.deductions);
        System.out.printf("Net Salary    : %.2f%n", record.getNetSalary());
    }

    private static SalaryRecord findSalaryRecord(ArrayList<SalaryRecord> salaryRecords, int employeeId) {
        for (SalaryRecord record : salaryRecords) {
            if (record.employeeId == employeeId) {
                return record;
            }
        }
        return null;
    }

    private static boolean isValidSalaryInput(double basicSalary, double hra, double da, double bonus, double deductions) {
        return basicSalary >= 0 && hra >= 0 && da >= 0 && bonus >= 0 && deductions >= 0;
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
