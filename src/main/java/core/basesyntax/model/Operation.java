package core.basesyntax.model;

import java.util.NoSuchElementException;

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

    public static Operation getByCode(String code) {
        for (Operation operation : Operation.values()) {
            if (code.equalsIgnoreCase(operation.getCode())) {
                return operation;
            }
        }
        throw new NoSuchElementException("No operation " + code);
    }
}
