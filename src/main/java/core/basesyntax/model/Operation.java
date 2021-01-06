package core.basesyntax.model;

import java.util.NoSuchElementException;

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

    public static Operation parseString(String stringToParse) {
        for (Operation operation : Operation.values()) {
            if (operation.operation.equalsIgnoreCase(stringToParse)) {
                return operation;
            }
        }
        throw new NoSuchElementException("No such operation for input: " + stringToParse);
    }
}
