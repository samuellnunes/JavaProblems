package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String [] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many numbers you will type? ");
        int quantityNumbers = scanner.nextInt();

        int[] numbers = new int[quantityNumbers];

        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("Number %d: ", i + 1);
            numbers[i] = scanner.nextInt();
        }

        System.out.println("Negative numbers: ");

        for (int number : numbers) {
            if (number < 0) {
                System.out.println(number);
            }
        }

        scanner.close();
    }
}
