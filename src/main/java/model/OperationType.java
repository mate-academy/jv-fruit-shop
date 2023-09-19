package model;

import service.exception.InvalidDataException;

public enum OperationType {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");
    private final String name;

    OperationType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static OperationType getOperation(String operation) {
        for (OperationType operationType : OperationType.values()) {
            if (operationType.getName().equals(operation)) {
                return operationType;
            }
        }
        throw new InvalidDataException(operation + " operation doesn't exist");
    }
}
