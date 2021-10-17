package core.basesyntax.model;

public class FruitOperation {
    private final Operation operation;
    private final String name;
    private final int quantity;

    public FruitOperation(Operation operation, String name, int quantity) {
        this.operation = operation;
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public Operation getOperation() {
        return operation;
    }

    public int getQuantity() {
        return quantity;
    }

    public enum Operation {
        BALANCE,
        SUPPLY,
        PURCHASE,
        RETURN;
    }
}
