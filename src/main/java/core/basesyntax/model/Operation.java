package core.basesyntax.model;

import java.util.Arrays;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private static final String INCORRECT_DATA_EXCEPTION
            = "Incorrect operation type! Insert correct type to input file";
    private String code;

    Operation(String code) {
        this.code = code;
    }

    public static Operation getOperationType(String type) {
        return Arrays.stream(values())
                .filter(operation -> operation.code.equals(type))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(INCORRECT_DATA_EXCEPTION));
    }
}
