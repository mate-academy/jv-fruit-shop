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

    public static Operation fromString(String text) {
        for (Operation operation : Operation.values()) {
            if (operation.operation.equals(text)) {
                return operation;
            }
        }
        throw new IllegalArgumentException("No constants was found");
    }
}
