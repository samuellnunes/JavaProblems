package entitites;

import entitites.enums.OrderStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private LocalDateTime moment;
    private OrderStatus status;

    private Client client;
    private List<OrderItem> orderItems = new ArrayList<>();

    public Order() {

    }

    public Order(LocalDateTime moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void addItem(OrderItem item) {
        orderItems.add(item);
    }

    public void removeItem(OrderItem item) {
        orderItems.remove(item);
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Double total() {
        Double total = 0.0;

        for (OrderItem item : orderItems) {
            total += item.subTotal();
        }

        return total;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Order moment: " + dateTimeFormatter.format(moment));
        stringBuilder.append("\nOrder status: " + status);
        stringBuilder.append("\nClient: " + client.toString());

        stringBuilder.append("\n\nOrder items\n");
        stringBuilder.append("---------------------------------------------\n");

        for (OrderItem item : orderItems) {
            stringBuilder.append(item + "\n");
        }

        stringBuilder.append("---------------------------------------------\n");

        stringBuilder.append("\nTotal price: $");
        stringBuilder.append(String.format("%.2f", total()));

        return stringBuilder.toString();
    }
}
