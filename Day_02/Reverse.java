// Write a program to Reverse a number. 
import java.util.Scanner;

public class Reverse {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int rev=0, r;
        System.out.println("Enter the number");
        int n = sc.nextInt();

        while(n!=0)
        {
            r = n%10;
            rev = rev*10 + r;
            n = n/10;
        }
        sc.close();
        System.out.println("Reverse of the number is: "+ rev);

    }
}
