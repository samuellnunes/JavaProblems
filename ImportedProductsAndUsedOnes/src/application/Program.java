package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        List<Product> productList = new ArrayList<>();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Enter the quantity of products: ");
        int productsQuantity = scanner.nextInt();

        for (int i = 1; i <= productsQuantity; i++) {
            System.out.printf("%n#%d product data%n", i);

            scanner.nextLine();

            System.out.print("Common, used or imported (c/u/i)? ");
            char productType = scanner.next().charAt(0);

            if (productType == 'c') {

                scanner.nextLine();

                System.out.print("Name: ");
                String name = scanner.nextLine();

                System.out.print("Price: ");
                double price = scanner.nextDouble();

                Product product = new Product(name, price);
                productList.add(product);

            } else if (productType == 'u') {

                scanner.nextLine();

                System.out.print("Name: ");
                String name = scanner.nextLine();

                System.out.print("Price: ");
                double price = scanner.nextDouble();

                scanner.nextLine();

                System.out.print("Manufacture date: ");
                LocalDate localDate = LocalDate.parse(scanner.nextLine(), dateTimeFormatter);

                Product usedProduct = new UsedProduct(name, price, localDate);
                productList.add(usedProduct);

            } else {

                scanner.nextLine();

                System.out.print("Name: ");
                String name = scanner.nextLine();

                System.out.print("Price: ");
                double price = scanner.nextDouble();

                System.out.print("Customs fee: ");
                double customsFee = scanner.nextDouble();

                Product importedProduct = new ImportedProduct(name, price, customsFee);
                productList.add(importedProduct);
            }
        }

        System.out.println();

        System.out.println("=============");
        System.out.println("PRICES TAGS");
        System.out.println("=============");

        for (Product product : productList) {
            System.out.println(product.priceTag());
        }

        scanner.close();
    }
}
