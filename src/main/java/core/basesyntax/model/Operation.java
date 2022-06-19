package core.basesyntax.model;

import java.util.Arrays;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String value;

    Operation(String value) {
        this.value = value;
    }

    public static Operation fromString(String s) throws IllegalArgumentException {
        return Arrays.stream(Operation.values())
                .filter(v -> v.value.equals(s))
                .findFirst()
                .orElse(null);
    }
}
