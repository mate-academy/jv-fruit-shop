package core.basesyntax;

public class FruitTransfer {
    private Operations operations;
    private String fruit;
    private int quantity;

    public FruitTransfer(Operations operations, String fruit, int quantity) {
        this.operations = operations;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Operations getOperations() {
        return operations;
    }

    public String getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }
}
