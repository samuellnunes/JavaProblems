package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product{

    private LocalDate localDate;
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public UsedProduct() {

    }

    public UsedProduct(String name, Double price, LocalDate localDate) {
        super(name, price);
        this.localDate = localDate;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    @Override
    public String priceTag() {
        return getName() + " (used) $ " + getPrice() +
                " (Manufacture date: " + dateTimeFormatter.format(localDate) + ")";
    }
}
