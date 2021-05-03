package core.basesyntax.servise;

import core.basesyntax.servise.exception.IncorrectOperationException;
import java.util.Arrays;

public enum Operation {
    BALANCE("b"), SUPPLY("s"), RETURN("r"), PURCHASE("p");
    private final String operation;

    Operation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    public static Operation getOperationType(String letter) {
        return Arrays.stream(Operation.values())
                .filter(value -> value.getOperation().equals(letter))
                .findFirst()
                .orElseThrow(() -> new IncorrectOperationException("Incorrect Operation Type!"
                        + " Please check your file and try again."));
    }
}
