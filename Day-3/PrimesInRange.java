import java.util.Scanner;

public class PrimesInRange {
    static boolean checkPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter start of range: ");
        int start = input.nextInt();
        System.out.print("Enter end of range: ");
        int end = input.nextInt();
        System.out.println("Prime numbers between " + start + " and " + end + ":");
        for (int i = start; i <= end; i++) {
            if (checkPrime(i)) System.out.print(i + " ");
        }
        System.out.println();
        input.close();
    }
}
