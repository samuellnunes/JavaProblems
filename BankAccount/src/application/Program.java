package application;

import entities.Account;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Enter the account holder name: ");
        String name = scanner.nextLine();

        System.out.print("Is there a initial deposit value (Y/N)? ");
        String choice = scanner.nextLine();

        Account account;

        if (choice.toUpperCase().trim().equals("Y")) {

            System.out.print("Enter initial deposit value: ");
            double initialDeposit = scanner.nextDouble();

            account = new Account(accountNumber, name, initialDeposit);

        } else {
            account = new Account(accountNumber, name);
        }

        System.out.println("\nAccount data: ");
        System.out.print(account.toString());

        System.out.print("\nEnter a deposit value: ");
        double deposit = scanner.nextDouble();

        account.deposit(deposit);

        System.out.println("Updated account data: ");
        System.out.print(account.toString());

        System.out.print("\nEnter a withdraw value: ");
        double withdraw = scanner.nextDouble();

        account.withdraw(withdraw);

        System.out.println("Updated account data: ");
        System.out.print(account.toString());
    }
}
