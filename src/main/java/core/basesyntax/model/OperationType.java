package core.basesyntax.model;

public enum OperationType {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private String operation;

    OperationType(String operation) {
        this.operation = operation;
    }

    public static OperationType getOperation(String operation) {
        for (OperationType value : values()) {
            if (value.operation.equals(operation)) {
                return value;
            }
        }
        throw new IllegalArgumentException();
    }
}
