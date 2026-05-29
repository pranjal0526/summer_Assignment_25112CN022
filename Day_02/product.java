// Write a program to Find product of digits. 
import java.util.Scanner;
public class product {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int p = 1, r;
        System.out.println("Enter the number");
        int n = sc.nextInt();
         while(n!=0)
         {
            r= n%10;
            p = p*r;
            n=n/10;
         }
         System.out.println("Product of the digit are : "+p);
         sc.close();
    }
}
