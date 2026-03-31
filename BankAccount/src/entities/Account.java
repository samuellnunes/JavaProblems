package entities;

public class Account {

    private final int accountNumber;
    private String name;
    private double balance;

    public Account(int accountNumber, String name, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.name = name;
        deposit(initialDeposit);
    }

    public Account(int accountNumber, String name) {
        this.accountNumber = accountNumber;
        this.name = name;
    }


    public int getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double value) {
        balance += value;
    }

    public void withdraw(double value) {

        int bankInterest = 5;

        if (value <= balance + bankInterest) {
            balance -= value + bankInterest;
        }
    }

    @Override
    public String toString() {
        return "Account " + getAccountNumber() +
                ", Holder: " + getName() +
                " and Balance: $ " + getBalance() + "\n";
    }
}
