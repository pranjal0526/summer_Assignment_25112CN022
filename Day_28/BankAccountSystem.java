// Write a program to create bank account system.

import java.util.ArrayList;
import java.util.Scanner;

public class BankAccountSystem {
    static class BankAccount {
        int accountNumber;
        String accountHolderName;
        String accountType;
        double balance;

        BankAccount(int accountNumber, String accountHolderName, String accountType, double balance) {
            this.accountNumber = accountNumber;
            this.accountHolderName = accountHolderName;
            this.accountType = accountType;
            this.balance = balance;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
        int choice;

        System.out.println("Bank Account System");

        do {
            System.out.println();
            System.out.println("1. Create Account");
            System.out.println("2. View All Accounts");
            System.out.println("3. Search Account");
            System.out.println("4. Deposit Money");
            System.out.println("5. Withdraw Money");
            System.out.println("6. Update Account");
            System.out.println("7. Delete Account");
            System.out.println("8. Exit");

            choice = readInt(sc, "Enter your choice: ");

            switch (choice) {
                case 1:
                    createAccount(sc, accounts);
                    break;
                case 2:
                    viewAccounts(accounts);
                    break;
                case 3:
                    searchAccount(sc, accounts);
                    break;
                case 4:
                    depositMoney(sc, accounts);
                    break;
                case 5:
                    withdrawMoney(sc, accounts);
                    break;
                case 6:
                    updateAccount(sc, accounts);
                    break;
                case 7:
                    deleteAccount(sc, accounts);
                    break;
                case 8:
                    System.out.println("Exiting bank account system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select between 1 and 8.");
            }
        } while (choice != 8);

        sc.close();
    }

    private static void createAccount(Scanner sc, ArrayList<BankAccount> accounts) {
        int accountNumber = readInt(sc, "Enter account number: ");

        if (findAccount(accounts, accountNumber) != null) {
            System.out.println("Account with this number already exists.");
            return;
        }

        String accountHolderName = readNonEmptyString(sc, "Enter account holder name: ");
        String accountType = readNonEmptyString(sc, "Enter account type: ");
        double balance = readDouble(sc, "Enter opening balance: ");

        if (balance < 0) {
            System.out.println("Opening balance cannot be negative.");
            return;
        }

        accounts.add(new BankAccount(accountNumber, accountHolderName, accountType, balance));
        System.out.println("Account created successfully.");
    }

    private static void viewAccounts(ArrayList<BankAccount> accounts) {
        if (accounts.isEmpty()) {
            System.out.println("No bank accounts available.");
            return;
        }

        System.out.printf(
            "%-15s %-22s %-18s %-15s%n",
            "Account No",
            "Holder Name",
            "Account Type",
            "Balance"
        );

        for (BankAccount account : accounts) {
            System.out.printf(
                "%-15d %-22s %-18s %-15.2f%n",
                account.accountNumber,
                account.accountHolderName,
                account.accountType,
                account.balance
            );
        }
    }

    private static void searchAccount(Scanner sc, ArrayList<BankAccount> accounts) {
        int accountNumber = readInt(sc, "Enter account number to search: ");
        BankAccount account = findAccount(accounts, accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        printAccountDetails(account);
    }

    private static void depositMoney(Scanner sc, ArrayList<BankAccount> accounts) {
        int accountNumber = readInt(sc, "Enter account number: ");
        BankAccount account = findAccount(accounts, accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        double amount = readDouble(sc, "Enter amount to deposit: ");

        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than zero.");
            return;
        }

        account.balance += amount;
        System.out.printf("Deposit successful. Updated balance: %.2f%n", account.balance);
    }

    private static void withdrawMoney(Scanner sc, ArrayList<BankAccount> accounts) {
        int accountNumber = readInt(sc, "Enter account number: ");
        BankAccount account = findAccount(accounts, accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        double amount = readDouble(sc, "Enter amount to withdraw: ");

        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than zero.");
            return;
        }

        if (amount > account.balance) {
            System.out.println("Insufficient balance.");
            return;
        }

        account.balance -= amount;
        System.out.printf("Withdrawal successful. Updated balance: %.2f%n", account.balance);
    }

    private static void updateAccount(Scanner sc, ArrayList<BankAccount> accounts) {
        int accountNumber = readInt(sc, "Enter account number to update: ");
        BankAccount account = findAccount(accounts, accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        account.accountHolderName = readNonEmptyString(sc, "Enter new account holder name: ");
        account.accountType = readNonEmptyString(sc, "Enter new account type: ");
        System.out.println("Account details updated successfully.");
    }

    private static void deleteAccount(Scanner sc, ArrayList<BankAccount> accounts) {
        int accountNumber = readInt(sc, "Enter account number to delete: ");
        BankAccount account = findAccount(accounts, accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        accounts.remove(account);
        System.out.println("Account deleted successfully.");
    }

    private static void printAccountDetails(BankAccount account) {
        System.out.println("Account found:");
        System.out.println("Account Number     : " + account.accountNumber);
        System.out.println("Account Holder     : " + account.accountHolderName);
        System.out.println("Account Type       : " + account.accountType);
        System.out.printf("Current Balance    : %.2f%n", account.balance);
    }

    private static BankAccount findAccount(ArrayList<BankAccount> accounts, int accountNumber) {
        for (BankAccount account : accounts) {
            if (account.accountNumber == accountNumber) {
                return account;
            }
        }
        return null;
    }

    private static int readInt(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            if (sc.hasNextInt()) {
                int value = sc.nextInt();
                sc.nextLine();
                return value;
            }
            System.out.println("Please enter a valid integer.");
            sc.next();
        }
    }

    private static double readDouble(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            if (sc.hasNextDouble()) {
                double value = sc.nextDouble();
                sc.nextLine();
                return value;
            }
            System.out.println("Please enter a valid number.");
            sc.next();
        }
    }

    private static String readNonEmptyString(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String value = sc.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("Input cannot be empty.");
        }
    }
}
