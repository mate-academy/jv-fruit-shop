package core.basesyntax.model;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private String operation;

    Operation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    public static Operation operationCheck(String text) {
        for (Operation o : Operation.values()) {
            if (o.operation.equalsIgnoreCase(text)) {
                return o;
            }
        }
        throw new IllegalArgumentException("Operation type is not valid");
    }
}
