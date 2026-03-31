package application;

import entities.Student;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int grade1 = scanner.nextInt();
        int grade2 = scanner.nextInt();
        int grade3 = scanner.nextInt();

        Student student = new Student();
        student.name = name;
        student.grade1 = grade1;
        student.grade2 = grade2;
        student.grade3 = grade3;

        System.out.println(student.toString());

        scanner.close();
    }
}
