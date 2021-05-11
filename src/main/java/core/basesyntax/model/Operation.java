package core.basesyntax.model;

import java.util.Arrays;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private static final String INVALID_OPERATION_MESSAGE = "Invalid operation format";

    private final String operation;

    Operation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    public static Operation getOperationByLetter(String operation) {
        return Arrays
                .stream(Operation.values()).filter(e -> e.getOperation().equals(operation))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_OPERATION_MESSAGE
                        + " ," + operation));
    }
}
