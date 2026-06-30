import java.util.Scanner;

public class CollegeManagment {
    // ─── Student Data ───────────────────────────────────────
    static final int STUDENT_CAP  = 50;
    static int[]    sRoll         = new int[STUDENT_CAP];
    static String[] sName         = new String[STUDENT_CAP];
    static String[] sCourse       = new String[STUDENT_CAP];
    static double[] sFeePaid      = new double[STUDENT_CAP];
    static double[] sFeeTotal     = new double[STUDENT_CAP];
    static int      sCount        = 0;

    // ─── Faculty Data ────────────────────────────────────────
    static final int FACULTY_CAP  = 20;
    static int[]    fId           = new int[FACULTY_CAP];
    static String[] fName         = new String[FACULTY_CAP];
    static String[] fSubject      = new String[FACULTY_CAP];
    static int      fCount        = 0;

    // ─── Utility functions ───────────────────────────────────
    static String computeFeesStatus(double paid, double total) {
        if (paid >= total) return "CLEARED";
        double pct = (paid / total) * 100;
        if (pct >= 50) return "PARTIAL";
        return "PENDING";
    }

    static String getGrade(double marks) {
        if (marks >= 90) return "A+";
        if (marks >= 80) return "A";
        if (marks >= 70) return "B";
        if (marks >= 60) return "C";
        if (marks >= 50) return "D";
        return "F";
    }

    // ─── Student Functions ───────────────────────────────────
    static void admitStudent(Scanner sc) {
        if (sCount >= STUDENT_CAP) { System.out.println("Admission closed. Capacity full."); return; }
        System.out.print("Roll Number    : "); sRoll[sCount]   = sc.nextInt(); sc.nextLine();
        System.out.print("Student Name   : "); sName[sCount]   = sc.nextLine();
        System.out.print("Course Enrolled: "); sCourse[sCount] = sc.nextLine();
        System.out.print("Total Fees Due : Rs. "); sFeeTotal[sCount] = sc.nextDouble();
        System.out.print("Fees Paid Now  : Rs. "); sFeePaid[sCount]  = sc.nextDouble(); sc.nextLine();
        sCount++;
        System.out.println("Student admitted successfully.");
    }

    static void studentDirectory() {
        if (sCount == 0) { System.out.println("No students admitted yet."); return; }
        System.out.println("\n============ STUDENT DIRECTORY ============");
        System.out.printf("%-6s %-20s %-15s %-12s %-10s%n",
                "Roll", "Name", "Course", "Fees Status", "Balance");
        System.out.println("-------------------------------------------------------------");
        for (int i = 0; i < sCount; i++) {
            double balance = sFeeTotal[i] - sFeePaid[i];
            System.out.printf("%-6d %-20s %-15s %-12s Rs.%-7.2f%n",
                    sRoll[i], sName[i], sCourse[i],
                    computeFeesStatus(sFeePaid[i], sFeeTotal[i]), balance);
        }
    }

    static void collectFee(Scanner sc) {
        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt(); sc.nextLine();
        for (int i = 0; i < sCount; i++) {
            if (sRoll[i] == roll) {
                double outstanding = sFeeTotal[i] - sFeePaid[i];
                if (outstanding <= 0) { System.out.println("Fees already cleared."); return; }
                System.out.printf("Outstanding: Rs. %.2f%n", outstanding);
                System.out.print("Amount collecting now: Rs. ");
                double collected = sc.nextDouble(); sc.nextLine();
                sFeePaid[i] += Math.min(collected, outstanding);
                System.out.printf("Updated fee status: %s%n", computeFeesStatus(sFeePaid[i], sFeeTotal[i]));
                return;
            }
        }
        System.out.println("Student not found.");
    }

    static void findStudent(Scanner sc) {
        System.out.print("Enter roll number or name keyword: ");
        String query = sc.nextLine().toLowerCase();
        boolean matched = false;
        for (int i = 0; i < sCount; i++) {
            if (String.valueOf(sRoll[i]).equals(query) || sName[i].toLowerCase().contains(query)) {
                System.out.println("Roll: " + sRoll[i] + " | Name: " + sName[i] +
                        " | Course: " + sCourse[i] + " | Status: " + computeFeesStatus(sFeePaid[i], sFeeTotal[i]));
                matched = true;
            }
        }
        if (!matched) System.out.println("No matching student found.");
    }

    // ─── Faculty Functions ───────────────────────────────────
    static void addFaculty(Scanner sc) {
        if (fCount >= FACULTY_CAP) { System.out.println("Faculty roster full."); return; }
        System.out.print("Faculty ID   : "); fId[fCount]      = sc.nextInt(); sc.nextLine();
        System.out.print("Faculty Name : "); fName[fCount]    = sc.nextLine();
        System.out.print("Subject      : "); fSubject[fCount] = sc.nextLine();
        fCount++;
        System.out.println("Faculty member added.");
    }

    static void facultyList() {
        if (fCount == 0) { System.out.println("No faculty on record."); return; }
        System.out.println("\n===== FACULTY ROSTER =====");
        System.out.printf("%-6s %-20s %-20s%n", "ID", "Name", "Subject");
        System.out.println("------------------------------------------");
        for (int i = 0; i < fCount; i++) {
            System.out.printf("%-6d %-20s %-20s%n", fId[i], fName[i], fSubject[i]);
        }
    }

    // ─── Analytics ───────────────────────────────────────────
    static void collegeStats() {
        System.out.println("\n===== COLLEGE ANALYTICS =====");
        System.out.println("Total Students Admitted : " + sCount);
        System.out.println("Total Faculty Members   : " + fCount);
        double totalCollected = 0, totalPending = 0;
        int cleared = 0, partial = 0, pending = 0;
        for (int i = 0; i < sCount; i++) {
            totalCollected += sFeePaid[i];
            totalPending   += (sFeeTotal[i] - sFeePaid[i]);
            String st = computeFeesStatus(sFeePaid[i], sFeeTotal[i]);
            if (st.equals("CLEARED")) cleared++;
            else if (st.equals("PARTIAL")) partial++;
            else pending++;
        }
        System.out.printf("Total Fees Collected    : Rs. %.2f%n", totalCollected);
        System.out.printf("Total Fees Outstanding  : Rs. %.2f%n", totalPending);
        System.out.println("Fee Cleared Students    : " + cleared);
        System.out.println("Partial Payment         : " + partial);
        System.out.println("Fee Pending Students    : " + pending);
    }

    // ─── Main Menu ───────────────────────────────────────────
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║   GL BAJAJ COLLEGE MANAGEMENT SYSTEM     ║");
        System.out.println("╚══════════════════════════════════════════╝");

        int menuChoice;
        do {
            System.out.println("\n─────────── MAIN MENU ───────────");
            System.out.println(" 1. Admit Student");
            System.out.println(" 2. Student Directory");
            System.out.println(" 3. Search Student");
            System.out.println(" 4. Collect Fee");
            System.out.println(" 5. Add Faculty");
            System.out.println(" 6. Faculty List");
            System.out.println(" 7. College Statistics");
            System.out.println(" 8. Exit System");
            System.out.println("─────────────────────────────────");
            System.out.print("Enter choice: ");
            menuChoice = sc.nextInt(); sc.nextLine();

            switch (menuChoice) {
                case 1: admitStudent(sc);   break;
                case 2: studentDirectory(); break;
                case 3: findStudent(sc);    break;
                case 4: collectFee(sc);     break;
                case 5: addFaculty(sc);     break;
                case 6: facultyList();      break;
                case 7: collegeStats();     break;
                case 8:
                    System.out.println("╔══════════════════════════════════╗");
                    System.out.println("║  System Closed. Have a great day!║");
                    System.out.println("╚══════════════════════════════════╝");
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1-8.");
            }
        } while (menuChoice != 8);
        sc.close();
    }
}
