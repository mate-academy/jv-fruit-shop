package core.basesyntax.model;

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

    public static Operation getOperation(String operation) {
        return Arrays.stream(values())
                .filter(o -> o.getOperation().equals(operation))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("operation \""
                        + operation + "\" not exist"));
    }
}
