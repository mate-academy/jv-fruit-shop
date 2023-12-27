package core.basesyntax.model;

import java.util.Arrays;

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

    public static Operation getOperationFromCode(String code) {
        return Arrays.stream(Operation.values())
                .filter(o -> o.getCode().equals(code))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Can't find operation with code: " + code));
    }
}
