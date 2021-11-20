package core.basesyntax.model;

public enum Fruit {
    BANANA("banana", 0),
    APPLE("apple", 0);

    private final String name;
    private int quantity;

    Fruit(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}
