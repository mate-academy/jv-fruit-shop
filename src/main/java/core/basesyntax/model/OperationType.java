package core.basesyntax.model;

public enum OperationType {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String operation;

    OperationType(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }
}
