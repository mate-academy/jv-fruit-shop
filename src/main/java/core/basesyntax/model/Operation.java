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

    public static Operation fromString(String str) {
        for (Operation operation: Operation.values()) {
            if (operation.operation.equals(str)) {
                return operation;
            }
        }
        throw new RuntimeException("Incorrect work method fromString");
    }
}
