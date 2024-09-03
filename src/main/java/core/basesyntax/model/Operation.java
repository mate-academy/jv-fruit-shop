package core.basesyntax.model;

import core.basesyntax.exception.UnsupportedOperationException;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private String code;

    Operation(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Operation getOperationByCode(String code) {
        for (Operation operation : Operation.values()) {
            if (operation.getCode().equals(code)) {
                return operation;
            }
        }
        throw new UnsupportedOperationException(
                "Operation type not found -> "
                + "( "
                + code
                + " )");
    }
}
