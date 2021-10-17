package core.basesyntax.service;

public class FruitOperation {
    private final Operation operation;
    private final String name;

    public FruitOperation(String name, Operation operation) {
        this.operation = operation;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Operation getOperation() {
        return operation;
    }

    public enum Operation {
        BALANCE,
        SUPPLY,
        PURCHASE,
        RETURN
    }
}
