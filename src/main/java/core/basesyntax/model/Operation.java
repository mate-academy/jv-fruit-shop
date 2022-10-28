package core.basesyntax.model;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String operation;

    Operation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    public static Operation getOperationFromString(String value) {
        for (Operation operation : Operation.values()) {
            if (operation.getOperation().equals(value)) {
                return operation;
            }
        }
        return null;
    }
}
