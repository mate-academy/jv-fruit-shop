package core.basesyntax.model;

import java.util.Arrays;

public enum Operation {
    BALANCE("b"),
    PURCHASE("p"),
    SUPPLY("s"),
    RETURN("r");

    private final String code;

    Operation(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Operation getValueFromCode(String code) {
        return Arrays.stream(Operation.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst().orElseThrow();
    }
}
