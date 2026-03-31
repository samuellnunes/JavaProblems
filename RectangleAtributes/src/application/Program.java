package application;

import entities.Rectangle;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter rectangle width and height: ");

        double width = scanner.nextDouble();
        double height = scanner.nextDouble();

        Rectangle rectangle = new Rectangle();
        rectangle.width = width;
        rectangle.height = height;

        System.out.println(rectangle.toString());

        scanner.close();

    }
}
