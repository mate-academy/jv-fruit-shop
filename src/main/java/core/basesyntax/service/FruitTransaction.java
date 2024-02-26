package core.basesyntax.service;

public class FruitTransaction {
    private final Operation operation;
    private final String fruitType;
    private final int quantity;

    public FruitTransaction(Operation operation, String fruitType, int quantity) {
        this.operation = operation;
        this.fruitType = fruitType;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruitType() {
        return fruitType;
    }

    public int getQuantity() {
        return quantity;
    }
}
