import java.util.Scanner;

public class GCD {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = input.nextInt();
        System.out.print("Enter second number: ");
        int b = input.nextInt();
        int x = a, y = b;
        while (y != 0) {
            int remainder = x % y;
            x = y;
            y = remainder;
        }
        System.out.println("GCD of " + a + " and " + b + " = " + x);
        input.close();
    }
}
