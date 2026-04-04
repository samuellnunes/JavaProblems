package application;

import model.entities.Account;
import model.exception.AccountException;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter account data");

        try {
            System.out.print("\nNumber: ");
            int number = scanner.nextInt();

            scanner.nextLine();

            System.out.print("Holder: ");
            String holder = scanner.nextLine();

            System.out.print("Initial balance: ");
            double balance = scanner.nextInt();

            System.out.print("Withdraw limit: ");
            double withdrawLimit = scanner.nextDouble();

            Account account = new Account(number, holder, balance, withdrawLimit);

            System.out.print("\nEnter amount for withdraw: ");
            double amount = scanner.nextDouble();

            account.withdraw(amount);

            System.out.print("New balance: " + account.getBalance());

        } catch (AccountException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.print("Unexpected error!");
        }

        scanner.close();
    }
}
