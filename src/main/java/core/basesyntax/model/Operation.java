package core.basesyntax.model;

import java.util.Arrays;

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

    public static Operation findOperationByFirstLetter(String firstLetter) {
        return Arrays.stream(Operation.values())
                .filter(operation -> operation.getFirstLetter().equals(firstLetter.trim()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Can't find operation with first letter: "
                        + firstLetter));
    }

    private String getFirstLetter() {
        return getOperation().substring(0, 1).toLowerCase();
    }

}
