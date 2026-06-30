import java.util.Scanner;

public class MiniLibrary {
    static final int MAX_BOOKS = 30;
    static int[]     bookCode     = new int[MAX_BOOKS];
    static String[]  bookName     = new String[MAX_BOOKS];
    static String[]  authorName   = new String[MAX_BOOKS];
    static boolean[] bookIssued   = new boolean[MAX_BOOKS];
    static String[]  issuedTo     = new String[MAX_BOOKS];
    static int[]     daysIssued   = new int[MAX_BOOKS];
    static int       totalBooks   = 0;

    static double computeFine(int days) {
        int freeDays = 7;
        return days > freeDays ? (days - freeDays) * 2.0 : 0.0;
    }

    static void catalogueBook(Scanner sc) {
        if (totalBooks >= MAX_BOOKS) { System.out.println("No shelf space."); return; }
        System.out.print("Book Code  : "); bookCode[totalBooks]   = sc.nextInt(); sc.nextLine();
        System.out.print("Book Title : "); bookName[totalBooks]   = sc.nextLine();
        System.out.print("Author     : "); authorName[totalBooks] = sc.nextLine();
        bookIssued[totalBooks] = false;
        totalBooks++;
        System.out.println("Book catalogued.");
    }

    static void viewCatalogue() {
        System.out.println("\n--- Library Catalogue ---");
        System.out.printf("%-6s %-22s %-18s %-12s%n", "Code", "Title", "Author", "Status");
        System.out.println("----------------------------------------------------------");
        for (int i = 0; i < totalBooks; i++) {
            String status = bookIssued[i] ? "Issued to: " + issuedTo[i] : "Available";
            System.out.printf("%-6d %-22s %-18s %-12s%n", bookCode[i], bookName[i], authorName[i], status);
        }
    }

    static void issueToMember(Scanner sc) {
        System.out.print("Book code: "); int code = sc.nextInt(); sc.nextLine();
        for (int i = 0; i < totalBooks; i++) {
            if (bookCode[i] == code) {
                if (bookIssued[i]) { System.out.println("Already issued to " + issuedTo[i]); return; }
                System.out.print("Member name: "); issuedTo[i]   = sc.nextLine();
                System.out.print("Days to keep: "); daysIssued[i] = sc.nextInt(); sc.nextLine();
                bookIssued[i] = true;
                System.out.println("Book issued to " + issuedTo[i] + " for " + daysIssued[i] + " days.");
                double fine = computeFine(daysIssued[i]);
                if (fine > 0) System.out.printf("Fine applicable: Rs. %.2f%n", fine);
                return;
            }
        }
        System.out.println("Book not found.");
    }

    static void returnFromMember(Scanner sc) {
        System.out.print("Book code: "); int code = sc.nextInt(); sc.nextLine();
        for (int i = 0; i < totalBooks; i++) {
            if (bookCode[i] == code) {
                if (!bookIssued[i]) { System.out.println("Book was not issued."); return; }
                double fine = computeFine(daysIssued[i]);
                System.out.println("Book returned by " + issuedTo[i]);
                if (fine > 0) System.out.printf("Fine collected: Rs. %.2f%n", fine);
                else System.out.println("No fine. Returned on time.");
                bookIssued[i] = false;
                issuedTo[i]   = null;
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch;
        do {
            System.out.println("\n=== Mini Library System ===");
            System.out.println("1.Add Book  2.Catalogue  3.Issue  4.Return  5.Exit");
            System.out.print("Choice: ");
            ch = sc.nextInt(); sc.nextLine();
            switch (ch) {
                case 1: catalogueBook(sc);   break;
                case 2: viewCatalogue();     break;
                case 3: issueToMember(sc);   break;
                case 4: returnFromMember(sc); break;
                case 5: System.out.println("Library closed."); break;
                default: System.out.println("Invalid choice.");
            }
        } while (ch != 5);
        sc.close();
    }
}
