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

    public static Operation getOperationByLetter(String letter) {
        return Arrays.stream(Operation.values())
                .filter(o -> o.getOperation().equals(letter))
                .findFirst()
                .get();
    }
}