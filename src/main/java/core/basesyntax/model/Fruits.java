package core.basesyntax.model;

public abstract class Fruits {
    int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Fruits{" +
                "quantity=" + quantity +
                '}';
    }
}
