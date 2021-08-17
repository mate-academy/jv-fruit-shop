package core.basesyntax.model;

public class Fruit {
    private final String name;
    private long quantity;

    public Fruit(String name) {
        this.name = name;
        this.quantity = 0;
    }

    public String getName() {
        return name;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Fruit{" + "name='" + name + '\''
                + ", quantity=" + quantity
                + '}';
    }

}
