package core.basesyntax.models;

public class FruitTransfer {
    private Operation operations;
    private String fruit;
    private int quantity;

    public FruitTransfer() {
    }

    public FruitTransfer(Operation operation, String fruit, int quantity) {
        this.operations = operation;
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
