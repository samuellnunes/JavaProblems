package entities;

public class JuridicPerson extends Person {

    private Integer employeesQuantity;

    public JuridicPerson() {
        super();
    }

    public JuridicPerson(String name, Double annualIncome, Integer employeesQuantity) {
        super(name, annualIncome);
        this.employeesQuantity = employeesQuantity;
    }

    public Integer getEmployeesQuantity() {

        return employeesQuantity;
    }

    public void setEmployeesQuantity(Integer employeesQuantity) {
        this.employeesQuantity = employeesQuantity;
    }

    @Override
    public double taxAmount() {
        if (employeesQuantity > 10) {
            return getAnnualIncome() * 0.14;

        } else {
            return getAnnualIncome() * 0.16;
        }
    }

    @Override
    public String toString() {
        return getName() + ": $ " + taxAmount();
    }
}
