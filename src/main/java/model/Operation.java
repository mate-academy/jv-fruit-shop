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

    public static Operation getByValue(String type) {
        for (Operation operation : values()) {
            if (operation.getOperation().equals(type)) {
                return operation;
            }
        }
        throw new RuntimeException("Invalid operation type: " + type);
    }

    public String getOperation() {
        return operation;
    }
}
