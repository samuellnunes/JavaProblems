package application;

import entities.Student;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        Student[] rooms = new Student[10];

        System.out.print("How many rooms will be rented? ");
        int quantityRented = scanner.nextInt();

        for (int i = 0; i < quantityRented; i++) {
            System.out.printf("\nRent #%d%n", i + 1);

            scanner.nextLine();

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Email: ");
            String email = scanner.nextLine();

            System.out.print("Room: ");
            int room = scanner.nextInt();

            rooms[room] = new Student(name, email);
        }

        System.out.println("\nBusy rooms: ");
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i] != null) {
                System.out.print(i + rooms[i].toString());
            }
        }

        scanner.close();
    }
}
