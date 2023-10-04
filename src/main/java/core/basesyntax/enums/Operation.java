package core.basesyntax.enums;

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

    public static Operation fromString(String text) {
        for (Operation operation : Operation.values()) {
            if (operation.operation.equalsIgnoreCase(text)) {
                return operation;
            }
        }
        return null;
    }
}
