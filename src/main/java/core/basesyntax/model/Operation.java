package core.basesyntax.model;

import java.util.Arrays;

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

    public static Operation getOperationType(String code) {
        return Arrays.stream(Operation.values())
                .filter(operation1 -> operation1.getCode().equals(code.trim()))
                .findFirst()
                .get();
    }
}
