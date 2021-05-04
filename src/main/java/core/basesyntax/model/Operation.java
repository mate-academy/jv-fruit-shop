package core.basesyntax.model;

public enum Operation {
    BALANCE("b"), SUPPLY("s"), PURCHASE("p"), RETURN("r");

    private String operation;

    Operation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    public static Operation getOperationFromString(String operation) {
        for (Operation operations : Operation.values()) {
            if (operations.operation.equalsIgnoreCase(operation)) {
                return operations;
            }
        }
        throw new IllegalArgumentException("This operation is illegal - " + operation);
    }
}
