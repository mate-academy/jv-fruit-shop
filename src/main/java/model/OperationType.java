package model;

import exception.InvalidOperationTypeException;
import java.util.Arrays;

public enum OperationType {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");
    private String operation;

    OperationType(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    public static OperationType getOperationType(String letter) {
        return Arrays.stream(OperationType.values())
                 .filter(value -> value.getOperation().equals(letter))
                 .findFirst()
                 .orElseThrow(() -> new InvalidOperationTypeException("Invalid Operation Type"));
    }
}
