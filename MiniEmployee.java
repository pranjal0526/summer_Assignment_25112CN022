import java.util.Scanner;

public class MiniEmployee {
    static final int WORKFORCE_CAP = 40;
    static int[]    staffId        = new int[WORKFORCE_CAP];
    static String[] staffName      = new String[WORKFORCE_CAP];
    static String[] staffDept      = new String[WORKFORCE_CAP];
    static double[] basicPay       = new double[WORKFORCE_CAP];
    static int[]    yearsWorked    = new int[WORKFORCE_CAP];
    static int      headCount      = 0;

    static double netSalary(double basic) {
        double hra = basic * 0.20, da = basic * 0.15;
        double pf  = basic * 0.12, tax = (basic + hra + da) * 0.10;
        return (basic + hra + da) - (pf + tax);
    }

    static double appraisalHike(int years) {
        if (years >= 10) return 0.20;
        if (years >= 5)  return 0.10;
        return 0.05;
    }

    static void hireEmployee(Scanner sc) {
        if (headCount >= WORKFORCE_CAP) { System.out.println("Workforce capacity reached."); return; }
        System.out.print("Staff ID    : "); staffId[headCount]     = sc.nextInt(); sc.nextLine();
        System.out.print("Name        : "); staffName[headCount]   = sc.nextLine();
        System.out.print("Department  : "); staffDept[headCount]   = sc.nextLine();
        System.out.print("Basic Pay   : Rs. "); basicPay[headCount]   = sc.nextDouble();
        System.out.print("Years Served: "); yearsWorked[headCount] = sc.nextInt(); sc.nextLine();
        headCount++;
        System.out.println("Employee hired and recorded.");
    }

    static void payrollReport() {
        if (headCount == 0) { System.out.println("No employees."); return; }
        System.out.println("\n========== PAYROLL REPORT ==========");
        System.out.printf("%-6s %-16s %-12s %-12s %-12s%n", "ID", "Name", "Dept", "Basic", "Net Pay");
        System.out.println("----------------------------------------------------------");
        for (int i = 0; i < headCount; i++) {
            System.out.printf("%-6d %-16s %-12s Rs.%-9.2f Rs.%-9.2f%n",
                    staffId[i], staffName[i], staffDept[i], basicPay[i], netSalary(basicPay[i]));
        }
    }

    static void deptFilter(Scanner sc) {
        System.out.print("Enter department name: ");
        String dept = sc.nextLine().toLowerCase();
        System.out.println("\nEmployees in department \"" + dept + "\":");
        boolean found = false;
        for (int i = 0; i < headCount; i++) {
            if (staffDept[i].toLowerCase().equals(dept)) {
                System.out.println("  " + staffName[i] + " (ID: " + staffId[i] + ")");
                found = true;
            }
        }
        if (!found) System.out.println("  No employees found in that department.");
    }

    static void appraisalCalc() {
        System.out.println("\n--- Appraisal Report ---");
        for (int i = 0; i < headCount; i++) {
            double hike     = appraisalHike(yearsWorked[i]);
            double hikeAmt  = basicPay[i] * hike;
            double newBasic = basicPay[i] + hikeAmt;
            System.out.printf("%s | Years: %d | Hike: %.0f%% | New Basic: Rs.%.2f%n",
                    staffName[i], yearsWorked[i], hike * 100, newBasic);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sel;
        do {
            System.out.println("\n=== Mini Employee Management System ===");
            System.out.println("1.Hire Employee  2.Payroll Report  3.Filter by Dept  4.Appraisal  5.Exit");
            System.out.print("Selection: ");
            sel = sc.nextInt(); sc.nextLine();
            switch (sel) {
                case 1: hireEmployee(sc);  break;
                case 2: payrollReport();   break;
                case 3: deptFilter(sc);    break;
                case 4: appraisalCalc();   break;
                case 5: System.out.println("HR system closed."); break;
                default: System.out.println("Invalid selection.");
            }
        } while (sel != 5);
        sc.close();
    }
}
