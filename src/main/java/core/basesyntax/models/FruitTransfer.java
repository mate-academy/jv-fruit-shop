package core.basesyntax.models;

public class FruitTransfer {
    private Operation operations;
    private String fruit;
    private int quantity;

    public FruitTransfer() {
    }

    public FruitTransfer(Operation operations, String fruit, int quantity) {
        this.operations = operations;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Operation getOperations() {
        return operations;
    }

    public String getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }
}
