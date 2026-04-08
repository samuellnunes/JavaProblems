package domain.application;

import domain.entities.Contract;
import domain.entities.Installment;
import domain.services.ContractService;
import domain.services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("\nEnter the contract data");
        System.out.println("----------------------------");

        System.out.print("Contract number: ");
        int number = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Contract data (DD/MM/YYYY): ");
        LocalDate date = LocalDate.parse(scanner.nextLine(), dateTimeFormatter);

        System.out.print("Contract value: ");
        double totalValue = scanner.nextInt();

        Contract contract = new Contract(number, date, totalValue);

        System.out.print("Enter the quantity of installments: ");
        int quantityInstallment = scanner.nextInt();

        ContractService contractService = new ContractService(new PaypalService());

        contractService.processContract(contract, quantityInstallment);

        System.out.println("Installments: ");
        System.out.println("--------------------------");
        for (Installment installment : contract.getInstallments()) {
            System.out.println(installment);
        }
        System.out.println("--------------------------");


        scanner.close();
    }
}
