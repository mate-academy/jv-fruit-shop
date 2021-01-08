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

    public static Operation getOperationByLetter(String letter) {
        return Arrays.stream(Operation.values())
                .filter(operation1 -> operation1.getOperation().equals(letter))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("This operation don't find " + letter));
    }
}
