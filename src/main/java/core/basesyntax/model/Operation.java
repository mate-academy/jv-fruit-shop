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

    public static Operation getByCode(String code) {
        return Arrays.stream(Operation.values())
                .filter(o -> o.code.equals(code))
                .findFirst().orElseThrow(() -> new RuntimeException("Invalid code " + code));
    }
}
