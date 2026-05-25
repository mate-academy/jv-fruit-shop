package core.basesyntax.model;

public class FruitTransaction {
    private final Operation operation;
    private final String fruit;
    private final int quantity;

    public FruitTransaction(String fruit, Operation operation, int quantity) {
        this.fruit = fruit;
        this.operation = operation;
        this.quantity = quantity;
    }

    public String getFruit() {
        return fruit;
    }

    public Operation getOperation() {
        return operation;
    }
    
    public int getQuantity() {
        return quantity;
    }
}
