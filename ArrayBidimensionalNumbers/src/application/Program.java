package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String [] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of lines: ");
        int numberLines = scanner.nextInt();

        System.out.print("Enter the number of columns: ");
        int numberColumns = scanner.nextInt();

        int[][] matrixNumbers = new int[numberLines][numberColumns];

        for (int i = 0; i < numberLines; i++) {
            for (int j = 0; j < numberColumns; j++) {
                matrixNumbers[i][j] = scanner.nextInt();
            }
        }

        System.out.print("Enter a number in the matrix: ");
        int numberInMatrix = scanner.nextInt();

        for (int i = 0; i < numberLines; i++) {
            for (int j = 0; j < numberColumns; j++) {
                if (matrixNumbers[i][j] == numberInMatrix) {
                    System.out.println("\nPosition " + (i + 1) + ", " + (j + 1));


                    if (j > 0) {
                        System.out.println("Left: " + matrixNumbers[i][j - 1]);
                    }

                    if (j < numberColumns - 1) {
                        System.out.println("Right: " + matrixNumbers[i][j + 1]);
                    }

                    if (i > 0) {
                        System.out.println("Up: " + matrixNumbers[i - 1][j]);
                    }

                    if (i < numberLines - 1) {
                        System.out.println("Down: " + matrixNumbers[i + 1][j]);
                    }
                }
            }
        }
    }
}
