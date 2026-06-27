// Write a program to create employee management system.

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagementSystem {
    static class Employee {
        int employeeId;
        String name;
        String department;
        String designation;
        int experienceYears;

        Employee(int employeeId, String name, String department, String designation, int experienceYears) {
            this.employeeId = employeeId;
            this.name = name;
            this.department = department;
            this.designation = designation;
            this.experienceYears = experienceYears;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<Employee>();
        int choice;

        System.out.println("Employee Management System");

        do {
            System.out.println();
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");

            choice = readInt(sc, "Enter your choice: ");

            switch (choice) {
                case 1:
                    addEmployee(sc, employees);
                    break;
                case 2:
                    viewEmployees(employees);
                    break;
                case 3:
                    searchEmployee(sc, employees);
                    break;
                case 4:
                    updateEmployee(sc, employees);
                    break;
                case 5:
                    deleteEmployee(sc, employees);
                    break;
                case 6:
                    System.out.println("Exiting employee management system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select between 1 and 6.");
            }
        } while (choice != 6);

        sc.close();
    }

    private static void addEmployee(Scanner sc, ArrayList<Employee> employees) {
        int employeeId = readInt(sc, "Enter employee ID: ");

        if (findEmployee(employees, employeeId) != null) {
            System.out.println("Employee with this ID already exists.");
            return;
        }

        String name = readNonEmptyString(sc, "Enter employee name: ");
        String department = readNonEmptyString(sc, "Enter department: ");
        String designation = readNonEmptyString(sc, "Enter designation: ");
        int experienceYears = readInt(sc, "Enter years of experience: ");

        if (experienceYears < 0) {
            System.out.println("Experience cannot be negative.");
            return;
        }

        employees.add(new Employee(employeeId, name, department, designation, experienceYears));
        System.out.println("Employee record added successfully.");
    }

    private static void viewEmployees(ArrayList<Employee> employees) {
        if (employees.isEmpty()) {
            System.out.println("No employee records available.");
            return;
        }

        System.out.printf(
            "%-12s %-20s %-18s %-18s %-12s%n",
            "Employee ID",
            "Name",
            "Department",
            "Designation",
            "Experience"
        );

        for (Employee employee : employees) {
            System.out.printf(
                "%-12d %-20s %-18s %-18s %-12d%n",
                employee.employeeId,
                employee.name,
                employee.department,
                employee.designation,
                employee.experienceYears
            );
        }
    }

    private static void searchEmployee(Scanner sc, ArrayList<Employee> employees) {
        int employeeId = readInt(sc, "Enter employee ID to search: ");
        Employee employee = findEmployee(employees, employeeId);

        if (employee == null) {
            System.out.println("Employee record not found.");
            return;
        }

        System.out.println("Employee found:");
        System.out.println("Employee ID: " + employee.employeeId);
        System.out.println("Name: " + employee.name);
        System.out.println("Department: " + employee.department);
        System.out.println("Designation: " + employee.designation);
        System.out.println("Experience: " + employee.experienceYears + " years");
    }

    private static void updateEmployee(Scanner sc, ArrayList<Employee> employees) {
        int employeeId = readInt(sc, "Enter employee ID to update: ");
        Employee employee = findEmployee(employees, employeeId);

        if (employee == null) {
            System.out.println("Employee record not found.");
            return;
        }

        String name = readNonEmptyString(sc, "Enter new name: ");
        String department = readNonEmptyString(sc, "Enter new department: ");
        String designation = readNonEmptyString(sc, "Enter new designation: ");
        int experienceYears = readInt(sc, "Enter new years of experience: ");

        if (experienceYears < 0) {
            System.out.println("Experience cannot be negative.");
            return;
        }

        employee.name = name;
        employee.department = department;
        employee.designation = designation;
        employee.experienceYears = experienceYears;
        System.out.println("Employee record updated successfully.");
    }

    private static void deleteEmployee(Scanner sc, ArrayList<Employee> employees) {
        int employeeId = readInt(sc, "Enter employee ID to delete: ");
        Employee employee = findEmployee(employees, employeeId);

        if (employee == null) {
            System.out.println("Employee record not found.");
            return;
        }

        employees.remove(employee);
        System.out.println("Employee record deleted successfully.");
    }

    private static Employee findEmployee(ArrayList<Employee> employees, int employeeId) {
        for (Employee employee : employees) {
            if (employee.employeeId == employeeId) {
                return employee;
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
