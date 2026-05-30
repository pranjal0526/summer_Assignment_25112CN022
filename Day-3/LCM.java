import java.util.Scanner;

public class LCM {
    static int findGcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = input.nextInt();
        System.out.print("Enter second number: ");
        int b = input.nextInt();
        long lcm = ((long) a / findGcd(a, b)) * b;
        System.out.println("LCM of " + a + " and " + b + " = " + lcm);
        input.close();
    }
}
