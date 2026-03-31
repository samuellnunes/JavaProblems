package application;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many employees will be registered? ");
        int employeesQuantity = scanner.nextInt();

        List<Employee> employeesList = new ArrayList<>();

        for (int i = 1; i <= employeesQuantity; i++) {

            System.out.println("\nEmployee #" + i + ": ");

            System.out.print("ID: ");
            Integer id = scanner.nextInt();

            scanner.nextLine();

            System.out.print("Name: ");
            String name  = scanner.nextLine();

            System.out.print("Salary: ");
            Double salary = scanner.nextDouble();

            employeesList.add(new Employee(id, name, salary));
        }

        System.out.print("\nEnter the employee ID that will have salary increase: ");
        int idIncreased = scanner.nextInt();

        Employee emp = employeesList.stream().filter(x -> x.getId() == idIncreased).findFirst().orElse(null);

        if (emp == null) {
            System.out.println("This id does not exist!");
        }
        else {
            System.out.print("Enter the percentage: ");
            double percentage = scanner.nextDouble();
            emp.increaseSalary(percentage);
        }

        System.out.println("\nList of employees: ");
        for (Employee employee: employeesList) {
            System.out.println(employee.toString());
        }

        scanner.close();
    }
}
