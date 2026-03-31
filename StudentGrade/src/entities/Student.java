package entities;

public class Student {

    public String name;
    public double grade1;
    public double grade2;
    public double grade3;

    public double FinalGrade() {
        return grade1 + grade2 + grade3;
    }

    public String Situation() {
        double finalGrade = FinalGrade();

        if (finalGrade >= 60) {
            return "PASS";
        } else {
            double missingPoints = 60 - finalGrade;
            return "FAILED \nMISSING " + missingPoints + " POINTS";
        }
    }

    @Override
    public String toString() {
        return "\nFINAL GRADE: " + FinalGrade() +
                "\n" + Situation();
    }
}
