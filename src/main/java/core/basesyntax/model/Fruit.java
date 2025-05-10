package core.basesyntax.model;

public class Fruit {
    private String name;
    private int quantity;

    public Fruit(String name, int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity to add cannot be negative");
        }
        this.quantity += quantity;
    }

    public void reduceQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity to reduce cannot be negative");
        }
        if (this.quantity - quantity < 0) {
            throw new IllegalArgumentException("Cannot reduce quantity below zero");
        }
        this.quantity -= quantity;
    }

    @Override
    public String toString() {
        return "Fruit{"
                + "name='"
                + name + '\''
                + ", quantity=" + quantity
                + '}';
    }
}
