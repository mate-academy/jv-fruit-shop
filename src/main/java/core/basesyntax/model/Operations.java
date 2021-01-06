package core.basesyntax.model;

import java.util.Arrays;

public enum Operations {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String operation;

    Operations(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    public static Operations checkOperation(String operation) {
        return Arrays.stream(Operations.values())
                .filter(type -> type.getOperation().equalsIgnoreCase(operation))
                .findFirst().orElseThrow(()
                        -> new RuntimeException("Wrong operation " + operation));
    }
}
