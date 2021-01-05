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

    public static Operation getOperation(String operation) {
        for (Operation o : Operation.values()) {
            if (o.operation.equalsIgnoreCase(operation)) {
                return o;
            }
        }
        throw new IllegalArgumentException("No constant with operation " + operation + " found");
    }
}
