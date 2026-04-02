package application;

import entitites.Client;
import entitites.Order;
import entitites.OrderItem;
import entitites.Product;
import entitites.enums.OrderStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String [] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter output = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        System.out.println("-----------------");
        System.out.println("CLIENT DATA");
        System.out.println("-----------------");

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Birth date (DD/MM/YYYY): ");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine(), dateTimeFormatter);

        Client client = new Client(name, email, birthDate);

        System.out.println("\n-----------------");
        System.out.println("ORDER DATA");
        System.out.println("-----------------");

        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(scanner.nextLine());

        Order order = new Order(LocalDateTime.now(), status, client);

        System.out.print("How many items to this order? ");
        int quantityItems = scanner.nextInt();

        for (int i = 1; i <= quantityItems; i++) {

            System.out.printf("%n#%d item data%n", i);

            System.out.print("Product name: ");
            scanner.nextLine();
            String productName = scanner.nextLine();

            System.out.print("Product price: ");
            Double price = scanner.nextDouble();

            Product product = new Product(productName, price);

            System.out.print("Quantity: ");
            int quantity = scanner.nextInt();

            OrderItem orderItem = new OrderItem(quantity, price, product);

            order.addItem(orderItem);
        }

        System.out.println();

        System.out.println("ORDER SUMMARY");
        System.out.println("-----------------");

        System.out.print(order.toString());

        scanner.close();
    }
}
