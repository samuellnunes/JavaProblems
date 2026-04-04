package application;

import entities.JuridicPerson;
import entities.Person;
import entities.PhysicsPerson;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String [] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        List<Person> personList = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int payersQuantity = scanner.nextInt();

        for (int i = 1; i <= payersQuantity; i++) {

            System.out.printf("%nTax payer #%d data%n", i);

            System.out.print("Individual or company (i/c)? ");
            char personType = scanner.next().charAt(0);

            if (personType == 'i') {

                scanner.nextLine();

                System.out.print("Name: ");
                String name = scanner.nextLine();

                System.out.print("Annual income: ");
                double annualIncome = scanner.nextInt();

                System.out.print("Health costs: ");
                double healthCosts = scanner.nextInt();

                personList.add(new PhysicsPerson(name, annualIncome, healthCosts));

            } else if (personType == 'c'){

                scanner.nextLine();

                System.out.print("Name: ");
                String name = scanner.nextLine();

                System.out.print("Annual income: ");
                double annualIncome = scanner.nextInt();

                System.out.print("Number of employees: ");
                int employeesQuantity = scanner.nextInt();

                personList.add(new JuridicPerson(name, annualIncome, employeesQuantity));
            }
        }

        System.out.println("\nTAXES PAID");

        double sumTaxes = 0.0;
        for (Person person : personList) {
            System.out.println(person.toString());

            sumTaxes += person.taxAmount();
        }

        System.out.print("\nTOTAL TAXES: " + sumTaxes);
        scanner.close();
    }
}
