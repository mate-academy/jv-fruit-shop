package core.basesyntax.model;

public class Fruit {
    private int quantity;
    private String name;

    public Fruit() {
    }

    public Fruit(int quantity, String name) {
        this.quantity = quantity;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Fruit{"
                + "quantity=" + quantity
                + ", name='" + name + '\''
                + '}';
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }
}
