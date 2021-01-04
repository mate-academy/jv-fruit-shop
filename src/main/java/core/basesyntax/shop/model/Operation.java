package core.basesyntax.shop.model;

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

    public static Operation fromString(String operation) {
        for (Operation b : Operation.values()) {
            if (b.operation.equalsIgnoreCase(operation)) {
                return b;
            }
        }
        throw new IllegalArgumentException("No constant with operation " + operation + " found");
    }
}
