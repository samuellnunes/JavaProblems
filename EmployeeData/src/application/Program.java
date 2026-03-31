package application;

import entities.Employee;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Gross salary: ");
        double grossSalary = scanner.nextDouble();

        System.out.print("Tax: ");
        double tax = scanner.nextDouble();

        Employee employee = new Employee();
        employee.name = name;
        employee.grossSalary = grossSalary;
        employee.tax = tax;

        System.out.println("Employee: " + employee.toString());

        System.out.print("\nWhich percentage to increase salary? ");
        double percentageIncrease = scanner.nextDouble();

        employee.IncreaseSalary(percentageIncrease);

        System.out.println("Updated data: " + employee.toString());

        scanner.close();
    }
}
