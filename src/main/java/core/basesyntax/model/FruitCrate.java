package core.basesyntax.model;

public class FruitCrate {
    protected int quantity;
    protected String name;

    public FruitCrate(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }
}
