package core.basesyntax.model;

public enum FruitOperation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String operation;

    FruitOperation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }
}
