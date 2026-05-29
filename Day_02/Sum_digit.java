// Write a program to Find sum of digits of a number.
import java.util.Scanner;

public class Sum_digit {
    public static void main(String[] args)
        {
            int sum=0, r;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the number");
            int n = sc.nextInt();

            while(n!=0)
            {
                r = n%10;
                sum = sum+r;
                n = n/10;
            }
            System.out.println("Sum of the digit is : "+ sum);
            sc.close();
        }
}
