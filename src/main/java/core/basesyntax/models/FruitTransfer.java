package core.basesyntax.models;

public class FruitTransfer {
    private Operation action;
    private String fruit;
    private int quantity;

    public FruitTransfer() {
    }

    public FruitTransfer(Operation action, String fruit, int quantity) {
        this.action = action;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Operation getAction() {
        return action;
    }

    public String getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }
}
