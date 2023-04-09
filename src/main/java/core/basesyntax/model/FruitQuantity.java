package core.basesyntax.model;

public class FruitQuantity {
    private String fruit;
    private int quantity;

    public FruitQuantity(String fruit, int quantity) {
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
