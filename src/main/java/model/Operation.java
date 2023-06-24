package model;

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

    public static Operation parseOperation(String stringOperation) {
        for (Operation each : values()) {
            if (each.operation.equals(stringOperation)) {
                return each;
            }
        }
        throw new RuntimeException("This operation is not listed");
    }
}
