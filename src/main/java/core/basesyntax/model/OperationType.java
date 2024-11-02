package core.basesyntax.model;

import exception.OperationException;

public enum OperationType {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String codeOperation;

    OperationType(String codeOperation) {
        this.codeOperation = codeOperation;
    }

    public String getCodeOperation() {
        return codeOperation;
    }

    public static OperationType getOperationType(String codeOperation) {
        for (OperationType type : OperationType.values()) {
            if (type.getCodeOperation().equals(codeOperation)) {
                return type;
            }
        }
        throw new OperationException("Operation not found by code: " + codeOperation);
    }
}
