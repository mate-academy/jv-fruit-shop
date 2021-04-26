package core.basesyntax.model;

import core.basesyntax.exception.OperationFormatException;
import java.util.Arrays;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");
    private static final String EXCEPTION_MESSAGE = "Wrong operation type";
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
                .orElseThrow(()
                        -> new OperationFormatException(EXCEPTION_MESSAGE + "[" + letter + "]"));
    }
}
