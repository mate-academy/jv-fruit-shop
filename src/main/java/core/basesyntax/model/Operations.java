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

    public static Operations checkOperation(String operations) {
        return Arrays.stream(Operations.values())
                .filter(type -> type.getOperation().equalsIgnoreCase(operations))
                .findFirst().orElseThrow(()
                        -> new RuntimeException("Wrong operation " + operations));
    }
}
