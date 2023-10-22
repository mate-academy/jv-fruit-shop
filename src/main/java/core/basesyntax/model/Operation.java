package core.basesyntax.model;

import java.util.Arrays;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private static final String UNKNOWN_OPERATION = "Unknown operation: ";

    private final String code;

    Operation(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Operation getOperationByCode(String operationCode) {
        return Arrays.stream(Operation.values())
                .filter(o -> o.getCode().equals(operationCode))
                .findAny()
                .orElseThrow(() -> new RuntimeException(UNKNOWN_OPERATION + operationCode));
    }
}
