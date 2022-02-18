package core.basesyntax.service;

import java.util.Arrays;

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

    public static Operation getOperationValue(String str) {
        return Arrays.stream(Operation.values())
                .filter(operation -> operation.getOperation().equals(str))
                .findFirst()
                .get();
    }
}
