package entities;

public class PhysicsPerson extends Person {

    private Double healthCosts;

    public PhysicsPerson() {
        super();
    }

    public PhysicsPerson(String name, Double annualIncome, Double healthCosts) {
        super(name, annualIncome);
        this.healthCosts = healthCosts;
    }

    public Double getHealthCosts() {
        return healthCosts;
    }

    public void setHealthCosts(Double healthCosts) {
        this.healthCosts = healthCosts;
    }

    @Override
    public double taxAmount() {

        if (getAnnualIncome() < 20000) {

            if (healthCosts > 0) {
                return getAnnualIncome() * 0.15 - healthCosts * 0.50;
            } else {
                return getAnnualIncome() * 0.15;
            }
        } else {

            if (healthCosts > 0) {
                return getAnnualIncome() * 0.25 - healthCosts * 0.50;
            }
            else {
                return getAnnualIncome() * 0.25;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        return getName() + ": $ " + taxAmount();
    }
}
