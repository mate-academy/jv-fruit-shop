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

    public static Operation fromString(String operation) {
        for (Operation operations : Operation.values()) {
            if (operations.operation.equalsIgnoreCase(operation)) {
                return operations;
            }
        }
        throw new IllegalArgumentException("No constant with operation " + operation + " found");
    }
}
