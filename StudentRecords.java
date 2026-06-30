import java.util.Scanner;

public class StudentRecords {
    static final int ROOM_SIZE  = 30;
    static int[]    rollNumbers = new int[ROOM_SIZE];
    static String[] fullNames   = new String[ROOM_SIZE];
    static int[]    mathMarks   = new int[ROOM_SIZE];
    static int[]    scienceMarks= new int[ROOM_SIZE];
    static int[]    engMarks    = new int[ROOM_SIZE];
    static int      enrolled    = 0;

    static String gradeCalc(double pct) {
        if (pct >= 90) return "A+";
        if (pct >= 80) return "A";
        if (pct >= 70) return "B";
        if (pct >= 60) return "C";
        if (pct >= 50) return "D";
        return "F";
    }

    static void enrollStudent(Scanner sc) {
        if (enrolled >= ROOM_SIZE) { System.out.println("Class full."); return; }
        System.out.print("Roll No      : "); rollNumbers[enrolled]  = sc.nextInt(); sc.nextLine();
        System.out.print("Full Name    : "); fullNames[enrolled]    = sc.nextLine();
        System.out.print("Math Marks   : "); mathMarks[enrolled]    = sc.nextInt();
        System.out.print("Science Marks: "); scienceMarks[enrolled] = sc.nextInt();
        System.out.print("English Marks: "); engMarks[enrolled]     = sc.nextInt(); sc.nextLine();
        enrolled++;
        System.out.println("Student enrolled.");
    }

    static void displayClassReport() {
        if (enrolled == 0) { System.out.println("No students enrolled."); return; }
        System.out.println("\n========== CLASS REPORT ==========");
        System.out.printf("%-5s %-18s %-6s %-7s %-7s %-8s %-6s %-7s%n",
                "Roll", "Name", "Math", "Science", "Eng", "Total", "Pct", "Grade");
        System.out.println("------------------------------------------------------------------");
        for (int i = 0; i < enrolled; i++) {
            int total = mathMarks[i] + scienceMarks[i] + engMarks[i];
            double pct = total / 3.0;
            System.out.printf("%-5d %-18s %-6d %-7d %-7d %-8d %-6.1f %-7s%n",
                    rollNumbers[i], fullNames[i], mathMarks[i], scienceMarks[i],
                    engMarks[i], total, pct, gradeCalc(pct));
        }
    }

    static void topPerformer() {
        if (enrolled == 0) { System.out.println("No data."); return; }
        int topIdx = 0, topTotal = mathMarks[0] + scienceMarks[0] + engMarks[0];
        for (int i = 1; i < enrolled; i++) {
            int t = mathMarks[i] + scienceMarks[i] + engMarks[i];
            if (t > topTotal) { topTotal = t; topIdx = i; }
        }
        System.out.println("Top Performer: " + fullNames[topIdx] + " (Roll: " + rollNumbers[topIdx] + ", Total: " + topTotal + ")");
    }

    static void searchStudent(Scanner sc) {
        System.out.print("Enter roll number: ");
        int r = sc.nextInt(); sc.nextLine();
        for (int i = 0; i < enrolled; i++) {
            if (rollNumbers[i] == r) {
                int total = mathMarks[i] + scienceMarks[i] + engMarks[i];
                System.out.println("Name: " + fullNames[i] + " | Total: " + total + " | Grade: " + gradeCalc(total / 3.0));
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opt;
        do {
            System.out.println("\n=== Student Record System ===");
            System.out.println("1.Enroll  2.Class Report  3.Top Performer  4.Search  5.Exit");
            System.out.print("Option: ");
            opt = sc.nextInt(); sc.nextLine();
            switch (opt) {
                case 1: enrollStudent(sc);   break;
                case 2: displayClassReport(); break;
                case 3: topPerformer();      break;
                case 4: searchStudent(sc);   break;
                case 5: System.out.println("System closed."); break;
                default: System.out.println("Invalid option.");
            }
        } while (opt != 5);
        sc.close();
    }
}
