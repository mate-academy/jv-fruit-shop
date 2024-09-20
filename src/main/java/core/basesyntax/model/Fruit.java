package core.basesyntax.model;

public class Fruit {
    private String name;
    private int quantity;

    public Fruit(String name) {
        this.name = name;
        this.quantity = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    public void subtractQuantity(int quantity) {
        this.quantity -= quantity;
    }
}
