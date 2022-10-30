package core.basesyntax.model;

public class Fruit {
    private String type;
    private int quantity;

    public Fruit(String type, int quantity) {
        this.type = type;
        this.quantity = quantity;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Fruit{"
                + "type='" + type + '\''
                + ", quantity=" + quantity
                + '}';
    }
}
