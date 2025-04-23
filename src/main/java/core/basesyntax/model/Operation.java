package core.basesyntax.model;

import java.util.stream.Stream;

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
        return Stream.of(Operation.values())
                .filter(op -> op.getCode().equals(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown operation: " + code));
    }
}
