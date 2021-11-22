package core.basesyntax.services;

public enum OperationType {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private String operation;

    OperationType(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    public static OperationType fromString(String operation) {
        for (OperationType operations : OperationType.values()) {
            if (operations.operation.equalsIgnoreCase(operation)) {
                return operations;
            }
        }
        throw new RuntimeException("invalid operation");
    }
}



