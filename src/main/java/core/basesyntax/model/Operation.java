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

    public static Operation getInstanceFromString(String operation) {
        for (Operation o : Operation.values()) {
            if (o.operation.equals(operation)) {
                return o;
            }
        }
        throw new RuntimeException("No such operation" + operation);
    }

    public String getOperation() {
        return operation;
    }
}
