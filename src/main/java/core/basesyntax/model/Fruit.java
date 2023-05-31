package core.basesyntax.model;

public class Fruit {
    private final String name;
    private int quantity;

    public Fruit(String name) {
        this.name = name;
    }

    public Fruit(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
