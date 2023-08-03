package core.basesyntax.model;

import core.basesyntax.exceptions.OperationNotFoundException;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String code;

    Operation(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Operation getOperationType(String operationTypeSymbol) {
        for (Operation operation : Operation.values()) {
            if (operation.getCode().equals(operationTypeSymbol)) {
                return operation;
            }
        }
        throw new OperationNotFoundException("Invalid operation type: " + operationTypeSymbol);
    }
}
