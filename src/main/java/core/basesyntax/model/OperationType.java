package core.basesyntax.model;

import core.basesyntax.exeptions.InvalidOperationTypeException;
import java.util.Arrays;

public enum OperationType {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");
    private static final String EXCEPTION_MESSAGE = "Invalid Operation Type";
    private final String operation;

    OperationType(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    public static OperationType getOperationType(String letter) {
        return Arrays.stream(OperationType.values())
                .filter(operationType -> operationType.getOperation().equals(letter))
                .findFirst()
                .orElseThrow(() -> new InvalidOperationTypeException(EXCEPTION_MESSAGE
                        + "["
                        + letter
                        + "]"));
    }
}
