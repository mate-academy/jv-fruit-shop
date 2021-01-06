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
        throw new IllegalArgumentException(String.format("You have entered invalid "
                        + "operation: %s \n.Valid operations: %s",
                stringType, Arrays.toString(Operation.values())));
    }
}
