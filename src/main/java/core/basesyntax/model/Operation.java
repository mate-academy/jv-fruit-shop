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

    public static Operation fromString(String input) {
        for (Operation constant : Operation.values()) {
            if (constant.operation.equals(input)) {
                return constant;
            }
        }
        throw new IllegalArgumentException("No such constant with " + input + " marker!");
    }
}
