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

    public static Operation convertToOperation(String code) {
        return Arrays.stream(Operation.values())
                .filter(operation -> operation.code.equals(code))
                .findFirst()
                .orElseThrow(() ->
                        new RuntimeException("There is no such operation with code: " + code));
    }
}
