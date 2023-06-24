package core.basesyntax.model;

public class FruitReport {

    private final String fruit;
    private final int quantity;

    public FruitReport(String fruit, int quantity) {
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public String getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }
}
