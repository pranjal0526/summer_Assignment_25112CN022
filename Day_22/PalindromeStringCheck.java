// Write a program to check palindrome string.

import java.util.Scanner;

public class PalindromeStringCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String lowerCaseInput = input.toLowerCase();
        boolean isPalindrome = true;
        int left = 0;
        int right = lowerCaseInput.length() - 1;

        while (left < right) {
            if (lowerCaseInput.charAt(left) != lowerCaseInput.charAt(right)) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        if (isPalindrome) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }

        sc.close();
    }
}
