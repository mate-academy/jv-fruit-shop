package model;

import java.util.Arrays;

public enum Operation {
    BALANCE("b"),
    PURCHASE("p"),
    SUPPLY("s"),
    RETURN("r");

    private String operation;

    Operation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    public static Operation fromString(String stringType) {
        for (Operation type : Operation.values()) {
            if (type.operation.equals(stringType)) {
                return type;
            }
        }
        throw new IllegalArgumentException("You have entered invalid operation: "
                + stringType + "." + "\nValid operations: "
                + Arrays.toString(Operation.values()));
    }
}
