package application;


import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String [] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("How many numbers will be typing? ");
        int numbersQuantity = sc.nextInt();

        double [] numbers = new double[numbersQuantity];

        for (int i = 0; i < numbers.length; i++) {

            System.out.printf("Number %d: ", i + 1);
            numbers[i] = sc.nextInt();
        }

        double sum = 0;
        for (double number : numbers) {

            sum += number;
        }

        System.out.print("\nNumbers: ");
        for (double number : numbers) {
            System.out.print(number + " ");
        }

        System.out.printf("\nSum: %.2f%n", sum);

        double average = sum / numbers.length;
        System.out.printf("Average: %.2f", average);

        sc.close();
    }
}
