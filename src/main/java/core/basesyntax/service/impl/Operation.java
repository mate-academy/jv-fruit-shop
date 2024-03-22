package core.basesyntax.service.impl;

import core.basesyntax.exceptions.InvalidOperationException;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String code;

    Operation(String code) {
        this.code = code;
    }

    public static Operation getByCode(String operationCode) {
        for (Operation operation : Operation.values()) {
            if (operation.code.equals(operationCode)) {
                return operation;
            }
        }
        throw new InvalidOperationException("Invalid operation code: " + operationCode);
    }
}
